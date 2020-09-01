import { Component, OnInit } from '@angular/core';
import { TipPregledaService } from 'src/app/services/tip-pregleda.service';
import { TipPregleda } from 'src/app/models/tip-pregleda.model';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Klinika } from 'src/app/models/klinika.model';
import { Pregled } from 'src/app/models/pregled.model';
import { LekarService } from 'src/app/services/lekar.service';
import { KlinikaService } from 'src/app/services/klinika.service';
import { Lekar } from 'src/app/models/lekar.model';
import { Pacijent } from 'src/app/models/pacijent.model';
import { PacijentService } from 'src/app/services/pacijent.service';
import { User } from 'src/app/models/user.model';
import { PregledService } from 'src/app/services/pregled.service';
import { Termin } from 'src/app/models/termin.model';
import { Sala } from 'src/app/models/sala.model';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-pacijent-zakazivanje-pregleda',
  templateUrl: './pacijent-zakazivanje-pregleda.component.html',
  styleUrls: ['./pacijent-zakazivanje-pregleda.component.css']
})
export class PacijentZakazivanjePregledaComponent implements OnInit {
  datumValue: Date;
  startAt = new Date();
  tipoviPregleda: TipPregleda[];
  initTipPregleda: TipPregleda = { id: 0, naziv: "", opis: "" };
  initKlinika: Klinika = { id: 0, naziv: "", opis: "", adresa: "" };
  initLekar: Lekar = { id: 0, user: null, opis: "", klinika: null, radniKalendar: null, specijalizacija: null };
  listaKlinika: Klinika[];
  listaLekara: Lekar[];
  klinika: Klinika;
  spinner: boolean;
  user: User;
  pregled: Pregled = { id: null, lekar: new Lekar(), pacijent: new Pacijent(), sala: new Sala(), termin: new Termin(), tipPregleda: new TipPregleda() };

  constructor(private snackBar: MatSnackBar, private tipPregledaService: TipPregledaService, private _formBuilder: FormBuilder, private lekarService: LekarService,
    private klinikaService: KlinikaService, private pacijentService: PacijentService, private pregledService: PregledService) {
    this.startAt.setDate(this.startAt.getDate() + 1);
  }

  ngOnInit() {
    this.spinner = true;
    this.user = JSON.parse(localStorage.getItem('loggedUser'));

    this.pacijentService.getPacijentByUserId(this.user.id).subscribe(data => {
      this.pregled.pacijent = data;

      this.tipPregledaService.getAllTipovePregleda().subscribe(data => {
        this.tipoviPregleda = data;
        this.spinner = false;
      });
    });

  }

  TipPregleda_Changed(event) {
    this.spinner = true;
    if (this.pregled.tipPregleda == null) {
      this.listaKlinika = [];
      this.listaLekara = [];
      this.spinner = false;
    } else {
      this.klinikaService.getAllKlinikaByTipPregledaId(this.pregled.tipPregleda.id).subscribe(data => {
        this.listaKlinika = data;
        this.spinner = false;
      })
    }
  }

  Klinika_Changed(event) {
    this.spinner = true;
    if (this.klinika == null) {
      this.listaLekara = [];
      this.spinner = false;
    } else {
      this.lekarService.getAllLekarsByKlinikaId(this.klinika.id).subscribe(data => {
        this.listaLekara = data;
        this.spinner = false;
      })
    }
  }

  tipNotNull() {
    try {
      return this.pregled.tipPregleda.id > 0 ? true : false;
    } catch (e) {
      return false;
    }
  }
  klinikaNotNull() {
    try {
      return this.klinika.id > 0 ? true : false;
    } catch (e) {
      return false;
    }
  }
  formValid() {
    let tipNotNull = this.tipNotNull();
    let klinikaNotNull = this.klinikaNotNull();
    let lekarNotNull;
    try {
      this.pregled.lekar.id > 0 ? lekarNotNull = true : lekarNotNull = false;
    } catch (e) {
      lekarNotNull = false;
    }
    let terminNotNull;
    try {
      this.pregled.termin.datum != null ? terminNotNull = true : terminNotNull = false;
    } catch (e) {
      terminNotNull = false;
    }

    if (tipNotNull && klinikaNotNull && lekarNotNull && terminNotNull)
      return true;
    return false;
  }

  potvrdiZahtev() {
    this.spinner = true;
    this.pregledService.postExaminationRequest(this.pregled).subscribe(data => {
      this.snackBar.open('Zahtev za pregled je poslat. Odgovor cete dobiti putem email-a.', 'U redu', { duration: 5000 });
      this.spinner = false;
    })
  }
}
