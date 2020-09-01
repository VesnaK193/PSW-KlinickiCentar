import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailField: string;
  passwordField: string;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  loginClick(): void {
    console.log(this.emailField + ', ' + this.passwordField);
    const user: User = new User();
    user.email = this.emailField;
    user.password = this.passwordField;
    this.authService.login(user).subscribe(data => {
      const userString = JSON.stringify(data);
      switch (data.role) {
        case 'adminKC':
          localStorage.setItem('loggedUser', userString);
          this.router.navigateByUrl('/adminkc');
          break;
        case 'pacijent':
          localStorage.setItem('loggedUser', userString);
          this.router.navigateByUrl('/pacijent');
          break;
        case 'lekar':
          localStorage.setItem('loggedUser', userString);
          this.router.navigateByUrl('/lekar');
          break;
        case 'medicinskaSestra':
          localStorage.setItem('loggedUser', userString);
          this.router.navigateByUrl('/medicinskasestra');
          break;
        case 'adminK':
          localStorage.setItem('loggedUser', userString);
          this.router.navigateByUrl('/adminK');
          break;
        default:
          break;
      }
      console.log(data);
    });
  }
}
