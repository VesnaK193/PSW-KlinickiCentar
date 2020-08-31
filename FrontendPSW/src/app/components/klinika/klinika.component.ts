import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-klinika',
  templateUrl: './klinika.component.html',
  styleUrls: ['./klinika.component.css']
})
export class KlinikaComponent implements OnInit {

  constructor(private authService : AuthService) { }

  ngOnInit() {
  }
  logout(){
    this.authService.logout();
  }
}
