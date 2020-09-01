import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { TipPregleda } from '../models/tip-pregleda.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipPregledaService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public getAllTipovePregleda(): Observable<TipPregleda[]> {
    return this.httpClient.get<TipPregleda[]>(this.routes.getAllTipovePregleda);
  }
}
