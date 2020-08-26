import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatSnackBar } from '@angular/material';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  repeatPassword: string;
  public user: User = new User();

  constructor( private snackBar: MatSnackBar, private authService: AuthService ) { }

  ngOnInit() {
  }

  registerClick():void {
    this.authService.register(this.user).subscribe(data=> {
      console.log(data);
    })
  }

}
