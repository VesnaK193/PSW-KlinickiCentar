import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Pregled } from '../models/pregled.model';
import { Pacijent } from '../models/pacijent.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PregledService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public postExaminationRequest(pregled : Pregled): Observable<Pregled> {
    return this.httpClient.post<Pregled>(this.routes.postExaminationRequest, pregled);
  }
}
