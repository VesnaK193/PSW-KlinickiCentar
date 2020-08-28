import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatDialog, MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-odbijanje-dialog',
  templateUrl: './odbijanje-dialog.component.html',
  styleUrls: ['./odbijanje-dialog.component.css']
})
export class OdbijanjeDialogComponent implements OnInit {
  user : User;
  opis : string;
  constructor(private snackBar: MatSnackBar,
    private dialogRef: MatDialogRef<OdbijanjeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any, private router: Router, private userService : UserService) {
      this.user = data.user;
     }

  ngOnInit() {
  }
  private submit() : void {
    this.user.role = this.opis;
    this.userService.rejectRequest(this.user).subscribe(data => {
      this.snackBar.open('Zahtev je uspesno odbijen!', 'U redu', { duration: 2000 });
      this.dialogRef.close("rejected");
    });
  }

  private cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste!', 'U redu', { duration: 2000 });
  }
}
