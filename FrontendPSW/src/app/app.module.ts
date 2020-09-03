import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { UserComponent } from './components/user/user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { AdminKcComponent } from './components/admin-kc/admin-kc.component';
import { ZahteviZaRegistracijuComponent } from './components/admin-kc/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { AccountActivatedComponent } from './components/register/account-activated/account-activated.component';
import { PacijentComponent } from './components/pacijent/pacijent.component';
import { OdbijanjeDialogComponent } from './components/admin-kc/zahtevi-za-registraciju/odbijanje-dialog/odbijanje-dialog.component';
import { PacijentProfilComponent } from './components/pacijent/pacijent-profil/pacijent-profil.component';
// tslint:disable-next-line:max-line-length
import { PacijentProfilDialogComponent } from './components/pacijent/pacijent-profil/pacijent-profil-dialog/pacijent-profil-dialog.component';
import { KlinikaComponent } from './components/klinika/klinika.component';
import { LekarComponent } from './components/lekar/lekar.component';
import { KlinikaLekariComponent } from './components/klinika/klinika-lekari/klinika-lekari.component';
// tslint:disable-next-line:max-line-length
import { PacijentZakazivanjePregledaComponent } from './components/pacijent/pacijent-zakazivanje-pregleda/pacijent-zakazivanje-pregleda.component';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { StarRatingModule } from 'angular-star-rating';
// tslint:disable-next-line:max-line-length
import { KlinikaPredefinisaniPreglediComponent } from './components/klinika/klinika-predefinisani-pregledi/klinika-predefinisani-pregledi.component';
import { AdminKComponent } from './components/admin-k/admin-k.component';
import { AdminKProfilComponent } from './components/admin-k/admin-k-profil/admin-k-profil.component';
import { AdminKProfilDijalogComponent } from './components/admin-k/admin-k-profil/admin-k-profil-dijalog/admin-k-profil-dijalog.component';
import { LekarProfilComponent } from './components/lekar/lekar-profil/lekar-profil.component';
import { LekarProfilDijalogComponent } from './components/lekar/lekar-profil/lekar-profil-dijalog/lekar-profil-dijalog.component';
import { AdminKProfilKlinikeComponent } from './components/admin-k/admin-k-profil-klinike/admin-k-profil-klinike.component';
import { PacijentKlinikeComponent } from './components/pacijent/pacijent-klinike/pacijent-klinike.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    RegisterComponent,
    LoginComponent,
    AdminKcComponent,
    ZahteviZaRegistracijuComponent,
    AccountActivatedComponent,
    PacijentComponent,
    OdbijanjeDialogComponent,
    PacijentProfilComponent,
    PacijentProfilDialogComponent,
    KlinikaComponent,
    LekarComponent,
    KlinikaLekariComponent,
    PacijentZakazivanjePregledaComponent,
    KlinikaPredefinisaniPreglediComponent,
    AdminKComponent,
    AdminKProfilComponent,
    AdminKProfilDijalogComponent,
    LekarProfilComponent,
    LekarProfilDijalogComponent,
    AdminKProfilKlinikeComponent,
    PacijentKlinikeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    StarRatingModule.forRoot(),
  ],
  entryComponents: [PacijentProfilDialogComponent, OdbijanjeDialogComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
