import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Observable } from 'rxjs';
import { Lekar } from '../models/lekar.model';
import { PretragaLekar } from '../models/pretraga-lekar.model';

@Injectable({
  providedIn: 'root'
})
export class LekarService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public getAllLekarsByKlinikaId(id : number): Observable<Lekar[]> {
    return this.httpClient.get<Lekar[]>(this.routes.getAllLekarsByKlinikaId + "/" + id);
  }

  public getSearchedLekars(pretraga : PretragaLekar): Observable<Lekar[]> {
    return this.httpClient.post<Lekar[]>(this.routes.getSearchedLekars,pretraga);
  }
}
