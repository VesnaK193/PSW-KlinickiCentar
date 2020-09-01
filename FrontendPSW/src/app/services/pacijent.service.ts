import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoutesService } from '../routes/routes.service';
import { Pacijent } from '../models/pacijent.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacijentService {

  constructor(private httpClient: HttpClient, private routes: RoutesService) { }

  public getPacijentByUserId(id : number): Observable<Pacijent> {
    return this.httpClient.get<Pacijent>(this.routes.getPacijentByUserId + "/" + id);
  }
}
