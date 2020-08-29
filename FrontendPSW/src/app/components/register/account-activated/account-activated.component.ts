import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-account-activated',
  templateUrl: './account-activated.component.html',
  styleUrls: ['./account-activated.component.css']
})
export class AccountActivatedComponent implements OnInit {
  id:number;
  user:User;

  constructor(private userService: UserService, private route: ActivatedRoute, private authService: AuthService, private router: Router) {
    this.id = +this.route.snapshot.paramMap.get("id");
   }

  ngOnInit() {
    console.log(this.id);
    this.userService.getUserById(this.id).subscribe(data=>{
      this.user=data;
      this.authService.saveUser(this.user).subscribe(data1=>{
        let userString : string = JSON.stringify(data1);
        localStorage.setItem("loggedUser", userString);
      });
    })
  }

  goToHome(){
    this.router.navigateByUrl('/pacijent');
  }

}
