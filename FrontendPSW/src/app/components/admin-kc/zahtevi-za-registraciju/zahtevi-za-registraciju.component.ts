import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { DataSource } from '@angular/cdk/table';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-zahtevi-za-registraciju',
  templateUrl: './zahtevi-za-registraciju.component.html',
  styleUrls: ['./zahtevi-za-registraciju.component.css']
})
export class ZahteviZaRegistracijuComponent implements OnInit {

  dataSource : User[];
  displayedColumns: string[] = ['id','ime','prezime','email','grad','drzava','telefon','akcije'];
  constructor(private userService : UserService, private authService : AuthService, private snackBar : MatSnackBar) { }

  ngOnInit() {
    this.userService.getUsersOnHold().subscribe(data=> {
      this.dataSource = data;
    });
  }
  acceptClicked(user : User){
    this.authService.sendLink(user).subscribe(data=> {
      let temp : User[];
      this.dataSource.map(u=>{
        if(u != user) {
          temp.push(u);
        }
      })
      this.dataSource = temp;
      this.snackBar.open('Nalog prihvacen, link za aktivaciju je poslat.', 'U redu', { duration: 5000 });
    });
  }

  rejectClicked(){

  }
}
