import { KlinikaComponent } from '../components/klinika/klinika.component';
import { Klinika } from './klinika.model';
import { TipPregleda } from './tip-pregleda.model';

export class Cenovnik {
    id  : number;
    klinika : Klinika;
    tipPregleda : TipPregleda;
    cena : number;
    popust : number;

}
