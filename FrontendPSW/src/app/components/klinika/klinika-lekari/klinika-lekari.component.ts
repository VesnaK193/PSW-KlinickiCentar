import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Lekar } from 'src/app/models/lekar.model';
import { LekarService } from 'src/app/services/lekar.service';
import { Route } from '@angular/compiler/src/core';
import { PretragaLekar } from 'src/app/models/pretraga-lekar.model';
import { MatSort, Sort } from '@angular/material';

@Component({
  selector: 'app-klinika-lekari',
  templateUrl: './klinika-lekari.component.html',
  styleUrls: ['./klinika-lekari.component.css']
})
export class KlinikaLekariComponent implements OnInit {
  pretraga : PretragaLekar = new PretragaLekar();
  id: number;
  
  dataSource: Lekar[] = [];
  dataSorted: Lekar[] = [];
  sviLekari: Lekar[] = [];
  tipoviPregleda : String[] = [];
  listaFiltriranja: String[] = ["Po imenu uzlazno", "Po imenu silazno", "Po prezimenu uzlazno", "Po prezimenu silazno", "Po oceni uzlazno", "Po oceni silazno"];
  pomocniFilterModel: String = new String();

  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private route: ActivatedRoute, private lekarService: LekarService) {
    this.id = +this.route.parent.snapshot.paramMap.get("id");
    this.pretraga.idKlinike = this.id;
  }

  ngOnInit() {
    this.pretraga.ime="";
    this.pretraga.prezime = "";
    this.lekarService.getAllLekarsByKlinikaId(this.id).subscribe(data => {
      this.dataSource = data;
      this.sviLekari = data;
    })
  }

  resetuj_Click() {
    this.dataSource = this.sviLekari;
    this.pretraga.ime = "";
    this.pretraga.prezime = "";
  }

  onPretrazi_Click() {
    this.lekarService.getSearchedLekars(this.pretraga).subscribe(data => {
      this.dataSource = data;
    });
  }

  sortData_Select(odabranaOpcija) {
    let sort: Sort;
    switch (odabranaOpcija) {
      case "Po imenu uzlazno":
        sort = { "active": "ime", "direction": "asc" };
        break;
      case "Po imenu silazno":
        sort = { "active": "ime", "direction": "desc" };
        break;
      case "Po prezimenu silazno":
        sort = { "active": "prezime", "direction": "desc" };
        break;
      case "Po prezimenu uzlazno":
        sort = { "active": "prezime", "direction": "asc" };
        break;
      case "Po oceni silazno":
        sort = { "active": "ocena", "direction": "desc" };
        break;
      case "Po oceni uzlazno":
        sort = { "active": "ocena", "direction": "asc" };
        break;
      default:
        this.dataSource = this.sviLekari;
        return;
    }

    const data = this.dataSource.slice();
    if (!sort.active || sort.direction === '') {
      this.dataSorted = data;
      return;
    }

    this.dataSorted = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'ime': return compare(a.user.firstname, b.user.firstname, isAsc);
        case 'prezime': return compare(a.user.lastname, b.user.lastname, isAsc);
        case 'ocena': return compare(a.user.lastname, b.user.lastname, isAsc);
        default: return 0;
      }
    });
    this.dataSource = this.dataSorted;
  }

  proveriTipPregleda() {
    console.log("Proveri tip");
  }

  getDaysInMonth(month, year) {
    var date = new Date(year, month, 1);
    var days = [];
    while (date.getMonth() === month) {
      days.push(new Date(date));
      date.setDate(date.getDate() + 1);
    }
    return days;
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}