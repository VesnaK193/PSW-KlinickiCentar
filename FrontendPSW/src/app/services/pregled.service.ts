import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Pregled } from '../models/pregled.model';
import { Pacijent } from '../models/pacijent.model';
import { Observable } from 'rxjs';
import { Cenovnik } from '../models/cenovnik.model';

@Injectable({
  providedIn: 'root'
})
export class PregledService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public postExaminationRequest(pregled : Pregled): Observable<Pregled> {
    return this.httpClient.post<Pregled>(this.routes.postExaminationRequest, pregled);
  }

  public postExamination(pregled : Pregled): Observable<Pregled> {
    return this.httpClient.post<Pregled>(this.routes.postExamination, pregled);
  }

  public getAllPredefinisaniPreglediKlinike(id : number): Observable<Pregled[]> {
    return this.httpClient.get<Pregled[]>(this.routes.getAllPredefinisaniPreglediKlinike + "/" + id);
  }

  public getCenaByKlinikaAndTip(pregled : Pregled): Observable<Cenovnik> {
    return this.httpClient.post<Cenovnik>(this.routes.getCenaByKlinikaAndTip, pregled);
  }
}
