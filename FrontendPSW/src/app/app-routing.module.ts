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


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'accountActivated/:id', component: AccountActivatedComponent },
  { path: 'adminkc', component: AdminKcComponent , children: [
    { path: 'zahtevi-za-registraciju', component: ZahteviZaRegistracijuComponent },
    ]
  },
  { path: 'pacijent', component: PacijentComponent , children: [
    { path: 'profil', component: PacijentProfilComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
