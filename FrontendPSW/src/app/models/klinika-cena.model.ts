import { Klinika } from './klinika.model';
import { TipPregleda } from './tip-pregleda.model';

export class KlinikaCena {
    klinika:Klinika;
    tipPregleda : TipPregleda;
    cena : number;
    popust : number;
}
