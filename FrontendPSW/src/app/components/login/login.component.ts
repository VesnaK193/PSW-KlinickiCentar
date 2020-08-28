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
    console.log(this.emailField + ", " + this.passwordField);
    var user: User = new User();
    user.email = this.emailField;
    user.password = this.passwordField;
    this.authService.login(user).subscribe(data => {
      switch (data.role) {
        case "adminKC":
          this.router.navigateByUrl('/adminkc');
          break;
        case "pacijent":
          this.router.navigateByUrl('/pacijent');
          break;
        case "lekar":
          this.router.navigateByUrl('/lekar');
          break;
        case "medicinskaSestra":
          this.router.navigateByUrl('/medicinskasestra');
          break;
        case "adminKlinike":
          this.router.navigateByUrl('/adminklinike');
          break;
        default:
          break;
      }
      console.log(data);
    });
  }
}
