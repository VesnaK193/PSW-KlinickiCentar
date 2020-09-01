import { Component, OnInit } from '@angular/core';
import { PregledService } from 'src/app/services/pregled.service';
import { ActivatedRoute } from '@angular/router';
import { PredefinisaniPregled } from 'src/app/models/predefinisani-pregled.model';
import { Pacijent } from 'src/app/models/pacijent.model';
import { PacijentService } from 'src/app/services/pacijent.service';
import { User } from 'src/app/models/user.model';
import { Pregled } from 'src/app/models/pregled.model';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-klinika-predefinisani-pregledi',
  templateUrl: './klinika-predefinisani-pregledi.component.html',
  styleUrls: ['./klinika-predefinisani-pregledi.component.css']
})
export class KlinikaPredefinisaniPreglediComponent implements OnInit {
  id:number;
  dataSource : PredefinisaniPregled[]=[];
  pacijent : Pacijent;
  loggedUser : User;
  spinner : boolean;
  constructor(private pregledService: PregledService, private route: ActivatedRoute, private pacijentService : PacijentService, private snackBar : MatSnackBar) {
    this.id = +this.route.parent.snapshot.paramMap.get("id");
    this.loggedUser = JSON.parse(localStorage.getItem("loggedUser"));
   }

  ngOnInit() {
    this.spinner=true;
    this.pacijentService.getPacijentByUserId(this.loggedUser.id).subscribe(data=>{
      this.pacijent = data;
      this.pregledService.getAllPredefinisaniPreglediKlinike(this.id).subscribe(data=>{
       data.map(pregled=>{
         this.pregledService.getCenaByKlinikaAndTip(pregled).subscribe(cena=>{
           let predefPregled : PredefinisaniPregled = new PredefinisaniPregled();
           predefPregled.tipPregleda=pregled.tipPregleda;
           predefPregled.lekar=pregled.lekar;
           predefPregled.sala=pregled.sala;
           predefPregled.termin=pregled.termin;
           predefPregled.id = pregled.id;
           predefPregled.cena = cena.cena;
           predefPregled.popust = cena.popust;
           this.dataSource.push(predefPregled);
           this.spinner=false;
         })
       })
      })
    })
  }
  onRezervisi(predefPregled : PredefinisaniPregled){
    this.spinner=true;
    let pregled : Pregled = new Pregled();
    pregled.termin = predefPregled.termin;
    pregled.lekar = predefPregled.lekar;
    pregled.sala = predefPregled.sala;
    pregled.tipPregleda = predefPregled.tipPregleda;
    pregled.pacijent = this.pacijent;
    pregled.id = predefPregled.id;
    this.pregledService.postExamination(pregled).subscribe(data=>{
      let temp : PredefinisaniPregled[]=[];
      this.dataSource.map(preg =>{
        preg.id==data.id?null:temp.push(preg);
      })
      this.dataSource = temp;
      console.log(data);
      this.snackBar.open('Uspesno ste rezervisali pregled.', 'U redu', { duration: 5000 });
      this.spinner=false;
    })
  }
  getCenaPopust(cena:number, popust:number){
    return cena*((100-popust)/100);
  }
  popustActive(popust:number){
    return popust>0?true:false;
  }
  formatDate(datum: string){
    let d = new Date(datum);
    return d.getDate() + "." + d.getMonth()  + "." + d.getFullYear()  + " " + d.getHours()  + ":" + (d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes());
  }
}
