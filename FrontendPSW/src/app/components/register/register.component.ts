import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatSnackBar } from '@angular/material';
import { AuthService } from 'src/app/services/auth.service';
import { stringify } from 'querystring';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  spinner : boolean;
  repeatPassword: string;
  correct: boolean = false;
  public user: User = new User();

  constructor(private snackBar: MatSnackBar, private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  registerClick(): void {
    this.spinner = true;
    if (this.user.password.length < 8) {
      this.snackBar.open('Lozinka mora  imati najmanje 8 karaktera!', 'U redu', { duration: 5000 });
      return;
    } else {
      if (this.user.password != this.repeatPassword) {
        this.snackBar.open('Lozinka nije dobro uneta!', 'U redu', { duration: 5000 });
        return;
      } else {
        this.correct = true;
      }
    }
    if (this.correct) {
      this.authService.saveUser(this.user).subscribe(data => {
        this.spinner = false;
        this.snackBar.open('Zahtev za registraciju je poslat. Odgovor cete dobiti putem email-a.', 'U redu', { duration: 5000 });
        this.router.navigateByUrl('/login');
      }
      )
    };
  }

  formInvalid() : boolean {
    if(this.user.firstname == null || this.user.lastname == null || this.user.email == null
      || this.user.password == null || this.user.address == null || this.user.city == null
      || this.user.country == null || this.user.phone == null) {
        return true;
      }
      return false;
  }

}
