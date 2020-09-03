import { Component, OnInit, ViewChild } from '@angular/core';
import { Klinika } from 'src/app/models/klinika.model';
import { MatSort, Sort } from '@angular/material';
import { PretragaKlinika } from 'src/app/models/pretraga-klinika.model';
import { ActivatedRoute } from '@angular/router';
import { KlinikaService } from 'src/app/services/klinika.service';
import { TipPregleda } from 'src/app/models/tip-pregleda.model';
import { TipPregledaService } from 'src/app/services/tip-pregleda.service';
import { KlinikaCena } from 'src/app/models/klinika-cena.model';
import { PregledService } from 'src/app/services/pregled.service';
import { Pregled } from 'src/app/models/pregled.model';

@Component({
  selector: 'app-pacijent-klinike',
  templateUrl: './pacijent-klinike.component.html',
  styleUrls: ['./pacijent-klinike.component.css']
})
export class PacijentKlinikeComponent implements OnInit {
  pretraga : PretragaKlinika = new PretragaKlinika();
  id: number;
  startAt = new Date();
  dataBackup: KlinikaCena[] = [];
  dataSource: KlinikaCena[] = [];
  dataSorted: KlinikaCena[] = [];
  sveKlinike: Klinika[] = [];
  tipoviPregleda : TipPregleda[] = [];
  listaFiltriranja: String[] = ["Po nazivu uzlazno", "Po nazivu silazno", "Po ceni uzlazno", "Po ceni silazno", "Po oceni uzlazno", "Po oceni silazno"];
  pomocniFilterModel: String = new String();

  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private route: ActivatedRoute, private klinikaService: KlinikaService, private tipPregledaService : TipPregledaService, private pregledService : PregledService) {
    this.startAt.setDate(this.startAt.getDate() + 1); }

  ngOnInit() {
    this.pretraga.naziv="";
    this.pretraga.adresa = "";
    this.klinikaService.getAllKlinikas().subscribe(data => {
      this.sveKlinike = data; 
      this.sveKlinike.map(klinika =>{
        let kc : KlinikaCena = new KlinikaCena();
        kc.klinika = klinika;
        this.dataBackup.push(kc);
        this.dataSource.push(kc);
      })
      this.tipPregledaService.getAllTipovePregleda().subscribe(data => {
        this.tipoviPregleda = data;
      });
    })
  }

  resetuj_Click() {
    this.dataSource = this.dataBackup;
    this.pretraga.naziv = "";
    this.pretraga.adresa = "";
  }

  onPretrazi_Click() {
    this.klinikaService.getSearchedKlinike(this.pretraga).subscribe(data => {
      this.formatDataSource(data);
    });
  }

  formatDataSource(klinike : Klinika[]){
    klinike.map(klinika => {
      let pregled : Pregled = new Pregled();
      pregled.tipPregleda = this.pretraga.tipPregleda;
      pregled.lekar.klinika =klinika;

      this.pregledService.getCenaByKlinikaAndTip(pregled).subscribe(cena=>{
        let klinikaCena : KlinikaCena = new KlinikaCena();
        klinikaCena.klinika = klinika;
        klinikaCena.cena = cena.cena;
        klinikaCena.popust = cena.popust;
      })
    })
  }

  formValid(){
    return this.pretraga.termin !=null && this.pretraga.tipPregleda != null?true:false;
  }
  
  popustActive(popust:number){
    return popust>0?true:false;
  }

  cenaNotNull(cena:number){
    return cena!=null?true:false;
  }

  getCenaPopust(cena:number, popust:number){
    return cena*((100-popust)/100);
  }
  // sortData_Select(odabranaOpcija) {
  //   let sort: Sort;
  //   switch (odabranaOpcija) {
  //     case "Po nazivu uzlazno":
  //       sort = { "active": "naziv", "direction": "asc" };
  //       break;
  //     case "Po nazivu silazno":
  //       sort = { "active": "naziv", "direction": "desc" };
  //       break;
  //     case "Po ceni silazno":
  //       sort = { "active": "cena", "direction": "desc" };
  //       break;
  //     case "Po ceni uzlazno":
  //       sort = { "active": "cena", "direction": "asc" };
  //       break;
  //     case "Po oceni silazno":
  //       sort = { "active": "ocena", "direction": "desc" };
  //       break;
  //     case "Po oceni uzlazno":
  //       sort = { "active": "ocena", "direction": "asc" };
  //       break;
  //     default:
  //       this.dataSource = this.sviLekari;
  //       return;
  //   }

  //   const data = this.dataSource.slice();
  //   if (!sort.active || sort.direction === '') {
  //     this.dataSorted = data;
  //     return;
  //   }

  //   this.dataSorted = data.sort((a, b) => {
  //     const isAsc = sort.direction === 'asc';
  //     switch (sort.active) {
  //       case 'ime': return compare(a.user.firstname, b.user.firstname, isAsc);
  //       case 'prezime': return compare(a.user.lastname, b.user.lastname, isAsc);
  //       case 'ocena': return compare(a.user.lastname, b.user.lastname, isAsc);
  //       default: return 0;
  //     }
  //   });
  //   this.dataSource = this.dataSorted;
  // }

}


function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}