import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user.model';
import {AdminKProfilDijalogComponent} from './admin-k-profil-dijalog/admin-k-profil-dijalog.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-admin-k-profil',
  templateUrl: './admin-k-profil.component.html',
  styleUrls: ['./admin-k-profil.component.css']
})
export class AdminKProfilComponent implements OnInit {

  loggedUser: User;
  constructor(private dialog: MatDialog) {
    this.loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
  }

  ngOnInit() {
  }

  editDialog() {

    const dialogRef = this.dialog.open(AdminKProfilDijalogComponent, {
      data: { user: this.loggedUser}
    });
    dialogRef.afterClosed().subscribe(result => {

    });
  }
}
