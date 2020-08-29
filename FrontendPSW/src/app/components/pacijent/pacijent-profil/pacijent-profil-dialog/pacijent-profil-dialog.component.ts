import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatDialog, MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-pacijent-profil-dialog',
  templateUrl: './pacijent-profil-dialog.component.html',
  styleUrls: ['./pacijent-profil-dialog.component.css']
})
export class PacijentProfilDialogComponent implements OnInit {
  user : User;
  spinner : boolean;

  constructor(private snackBar: MatSnackBar,
    private dialogRef: MatDialogRef<PacijentProfilDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any, private router: Router, private userService : UserService, private authService : AuthService) {
      this.user = data.user; 
    }

  ngOnInit() {
  }
  private submit() : void {
    this.spinner = true;
    this.authService.saveUser(this.user).subscribe(data => {
      this.snackBar.open('Profil je uspesno izmenjen!', 'U redu', { duration: 2000 });
      let userString = JSON.stringify(this.user);
      localStorage.setItem("loggedUser", userString);
      this.spinner = false;
      this.dialogRef.close();
    });
  }
  
  private cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste!', 'U redu', { duration: 2000 });
  }
}
