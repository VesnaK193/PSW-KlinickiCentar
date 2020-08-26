import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public getUsers():Observable<User[]> {
    return this.httpClient.get<User[]>(this.routes.getAllUsers);
}
}
