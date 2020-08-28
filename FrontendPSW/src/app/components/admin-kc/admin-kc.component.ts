import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-kc',
  templateUrl: './admin-kc.component.html',
  styleUrls: ['./admin-kc.component.css']
})
export class AdminKcComponent implements OnInit {
  loggerUser : User;
  constructor(private authService : AuthService) {
    this.loggerUser = JSON.parse(localStorage.getItem("loggedUser"));
   }

  ngOnInit() {
  }
  logout(){
    this.authService.logout();
  }
}
