import { Component, OnInit } from '@angular/core';
import {User} from "../../../models/user.model";
import {MatDialog} from "@angular/material/dialog";
import {LekarProfilDijalogComponent} from "./lekar-profil-dijalog/lekar-profil-dijalog.component";

@Component({
  selector: 'app-lekar-profil',
  templateUrl: './lekar-profil.component.html',
  styleUrls: ['./lekar-profil.component.css']
})
export class LekarProfilComponent implements OnInit {

  loggedUser : User;
  constructor(private dialog: MatDialog) {
    this.loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
  }

  ngOnInit() {
  }

  editDialog(){

    const dialogRef = this.dialog.open(LekarProfilDijalogComponent, {
      data: { user: this.loggedUser}
    });
    dialogRef.afterClosed().subscribe(result => {

    });
  }
}
