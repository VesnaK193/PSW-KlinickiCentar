import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Klinika } from '../models/klinika.model';
import { Observable } from 'rxjs';
import { PretragaKlinika } from '../models/pretraga-klinika.model';

@Injectable({
  providedIn: 'root'
})
export class KlinikaService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public getAllKlinikaByTipPregledaId(id : number): Observable<Klinika[]> {
    return this.httpClient.get<Klinika[]>(this.routes.getAllKlinikaByTipPregledaId + "/" + id);
  }
  public getAllKlinikas(): Observable<Klinika[]> {
    return this.httpClient.get<Klinika[]>(this.routes.getAllKlinikas);
  }
  public getSearchedKlinike(pretraga : PretragaKlinika): Observable<Klinika[]> {
    return this.httpClient.post<Klinika[]>(this.routes.getSearchedKlinike,pretraga);
  }
}
