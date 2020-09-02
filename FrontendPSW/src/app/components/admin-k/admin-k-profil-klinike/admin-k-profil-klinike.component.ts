import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user.model';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-admin-k-profil-klinike',
  templateUrl: './admin-k-profil-klinike.component.html',
  styleUrls: ['./admin-k-profil-klinike.component.css']
})
export class AdminKProfilKlinikeComponent implements OnInit {

  loggedUser: User;
  constructor(private dialog: MatDialog) {
    this.loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
  }

  ngOnInit() {
  }


}
