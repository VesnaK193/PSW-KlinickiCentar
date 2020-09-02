import {Component, Inject, OnInit} from '@angular/core';
import {User} from "../../../../models/user.model";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {UserService} from "../../../../services/user.service";
import {AuthService} from "../../../../services/auth.service";

@Component({
  selector: 'app-lekar-profil-dijalog',
  templateUrl: './lekar-profil-dijalog.component.html',
  styleUrls: ['./lekar-profil-dijalog.component.css']
})
export class LekarProfilDijalogComponent implements OnInit {

  user: User;
  spinner: boolean;

  constructor(private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<LekarProfilDijalogComponent>,
              @Inject(MAT_DIALOG_DATA) private data: any, private router: Router, private userService: UserService, private authService: AuthService) {
    this.user = data.user;
  }

  ngOnInit() {
  }
  private submit(): void {
    this.spinner = true;
    this.authService.saveUser(this.user).subscribe(data => {
      this.snackBar.open('Profil je uspesno izmenjen!', 'U redu', { duration: 2000 });
      const userString = JSON.stringify(this.user);
      localStorage.setItem('loggedUser', userString);
      this.spinner = false;
      this.dialogRef.close();
    });
  }

  private cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste!', 'U redu', { duration: 2000 });
  }
}
