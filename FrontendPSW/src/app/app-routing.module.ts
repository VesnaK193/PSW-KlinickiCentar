import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './components/user/user.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { AdminKcComponent } from './components/admin-kc/admin-kc.component';
import { ZahteviZaRegistracijuComponent } from './components/admin-kc/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { AccountActivatedComponent } from './components/register/account-activated/account-activated.component';
import { PacijentComponent } from './components/pacijent/pacijent.component';
import { PacijentProfilComponent } from './components/pacijent/pacijent-profil/pacijent-profil.component';
import { KlinikaComponent } from './components/klinika/klinika.component';
import { KlinikaLekariComponent } from './components/klinika/klinika-lekari/klinika-lekari.component';
// tslint:disable-next-line:max-line-length
import { PacijentZakazivanjePregledaComponent } from './components/pacijent/pacijent-zakazivanje-pregleda/pacijent-zakazivanje-pregleda.component';
// tslint:disable-next-line:max-line-length
import { KlinikaPredefinisaniPreglediComponent } from './components/klinika/klinika-predefinisani-pregledi/klinika-predefinisani-pregledi.component';
import {AdminKComponent} from './components/admin-k/admin-k.component';
import {AdminKProfilComponent} from './components/admin-k/admin-k-profil/admin-k-profil.component';
import {LekarComponent} from './components/lekar/lekar.component';
import {LekarProfilComponent} from './components/lekar/lekar-profil/lekar-profil.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'accountActivated/:id', component: AccountActivatedComponent },
  { path: 'klinika/:id', component: KlinikaComponent , children: [
    { path: 'lekari', component: KlinikaLekariComponent },
    { path: 'predefinisaniPregledi', component: KlinikaPredefinisaniPreglediComponent },
  ]},
  { path: 'adminkc', component: AdminKcComponent , children: [
    { path: 'zahtevi-za-registraciju', component: ZahteviZaRegistracijuComponent },
    ]
  },
  { path: 'pacijent', component: PacijentComponent , children: [
    { path: 'profil', component: PacijentProfilComponent },
    { path: 'zakazliPregled', component: PacijentZakazivanjePregledaComponent },
    ]
  },
  { path: 'adminK', component: AdminKComponent, children: [
      {path: 'profil', component: AdminKProfilComponent},
    ]
  },
  { path: 'lekar', component: LekarComponent, children: [
      {path: 'profil', component: LekarProfilComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
