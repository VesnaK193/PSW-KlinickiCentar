import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public login(user: User): Observable<User> {
    return this.httpClient.post<User>(this.routes.login, user);
}

public saveUser(user : User) : Observable<User> {
  return this.httpClient.post<User>(this.routes.saveUser,user);
}
public sendLink(user : User) : Observable<User> {
  return this.httpClient.post<User>(this.routes.sendLink,user);
}
}
