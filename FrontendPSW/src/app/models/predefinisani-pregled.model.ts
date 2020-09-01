import { Termin } from './termin.model';
import { Sala } from './sala.model';
import { Lekar } from './lekar.model';
import { TipPregleda } from './tip-pregleda.model';

export class PredefinisaniPregled {
    id:number;
    termin : Termin;
    sala : Sala;
    lekar : Lekar;
    tipPregleda : TipPregleda;
    cena : number;
    popust : number;
}
