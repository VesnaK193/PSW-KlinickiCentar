import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { DataSource } from '@angular/cdk/table';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { MatSnackBar, MatDialog } from '@angular/material';
import { OdbijanjeDialogComponent } from './odbijanje-dialog/odbijanje-dialog.component';

@Component({
  selector: 'app-zahtevi-za-registraciju',
  templateUrl: './zahtevi-za-registraciju.component.html',
  styleUrls: ['./zahtevi-za-registraciju.component.css']
})
export class ZahteviZaRegistracijuComponent implements OnInit {
spinner : boolean;
  dataSource : User[];
  displayedColumns: string[] = ['id','ime','prezime','email','grad','drzava','telefon','akcije'];
  constructor(private dialog: MatDialog,private userService : UserService, private authService : AuthService, private snackBar : MatSnackBar) { }

  ngOnInit() {
    this.userService.getUsersOnHold().subscribe(data=> {
      this.dataSource = data;
    });
  }
  acceptClicked(user : User){
    this.spinner = true;
    this.authService.sendLink(user).subscribe(data=> {
      let temp : User[] = [];
      this.dataSource.map(u=>{
        if(u != user) {
          temp.push(u);
        }
      })
      this.dataSource = temp;
      this.spinner = false;
      this.snackBar.open('Nalog prihvacen, link za aktivaciju je poslat.', 'U redu', { duration: 5000 });
    });
  }

  rejectClicked(user: User){
    const dialogRef = this.dialog.open(OdbijanjeDialogComponent, {
      data: { user: user}
    });
    dialogRef.afterClosed().subscribe(result => {

      let temp : User[];

      if(result=="rejected"){
        this.dataSource.map(u=>{
          if(u != user) {
            temp.push(u);
          }
        })
        this.dataSource = temp;
      }
    });
  }
}
