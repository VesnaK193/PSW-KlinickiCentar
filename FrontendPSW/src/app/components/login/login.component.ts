import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailField : string;
  passwordField : string;
  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  loginClick():void{
    console.log(this.emailField + ", " + this.passwordField);
    var user : User = new User();
    user.email = this.emailField;
    user.password = this.passwordField;
    this.authService.login(user).subscribe(data=> {
      console.log(data);
    });
  }
}
