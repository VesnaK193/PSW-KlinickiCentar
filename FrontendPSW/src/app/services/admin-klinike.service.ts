import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdminKlinike} from '../models/adminKlinike.model';
import {Klinika} from '../models/klinika.model';
import {Observable} from 'rxjs';
import {User} from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AdminKlinikeService {

  constructor(private http: HttpClient) { }

  public getAdminaIzBaze(): Observable<AdminKlinike> {
    const header = new HttpHeaders();
    header.append('Content-Type', 'application/json');
    return this.http.get<AdminKlinike>('http://localhost:8088/getAdminaKlinike/', {headers: header});
  }
  public getKlinikaByAdminId(id: number): Observable<Klinika> {
    return this.http.get<Klinika>('http://localhost:8088/getKlinikaByAdminId/' + id);
  }
  public getAdmini(): Observable<AdminKlinike[]> {
    return this.http.get<AdminKlinike[]>('http://localhost:8088/getAdmineKlinike');
  }
  public getAdmin(id: number): Observable<AdminKlinike> {
    return this.http.get<AdminKlinike>('http://localhost:8088/getAdminaKlinike/' + id);
  }
  public updateKliniku(klinika: Klinika): void {
    this.http.put('http://localhost:8088/klinika', klinika).subscribe();
  }

  public updateAdminaK(admin: AdminKlinike): void {
    this.http.put('http://localhost:8088/adminKlinike', admin).subscribe();
  }
  public updateUser(user: User): void {
    this.http.put('http://localhost:8088/useraAdminaKlinike', user).subscribe();
  }
  public getUserById(id: number): Observable<User> {
    return this.http.get<User>('http://localhost:8088/user/' + id);
  }
}
