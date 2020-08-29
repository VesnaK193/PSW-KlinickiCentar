import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatDialog } from '@angular/material';
import { PacijentProfilDialogComponent } from './pacijent-profil-dialog/pacijent-profil-dialog.component';

@Component({
  selector: 'app-pacijent-profil',
  templateUrl: './pacijent-profil.component.html',
  styleUrls: ['./pacijent-profil.component.css']
})
export class PacijentProfilComponent implements OnInit {
  loggedUser : User;
  constructor(private dialog: MatDialog) {
    this.loggedUser = JSON.parse(localStorage.getItem("loggedUser"));
   }

  ngOnInit() {
  }

  editDialog(){

    const dialogRef = this.dialog.open(PacijentProfilDialogComponent, {
      data: { user: this.loggedUser}
    });
    dialogRef.afterClosed().subscribe(result => {

    });
  }
}
