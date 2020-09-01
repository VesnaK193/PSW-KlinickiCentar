import { Termin } from './termin.model';
import { Sala } from './sala.model';
import { PacijentZakazivanjePregledaComponent } from '../components/pacijent/pacijent-zakazivanje-pregleda/pacijent-zakazivanje-pregleda.component';
import { Pacijent } from './pacijent.model';
import { TipPregleda } from './tip-pregleda.model';
import { Lekar } from './lekar.model';

export class Pregled {
    id:number;
    termin:Termin;
    sala: Sala;
    pacijent: Pacijent;
    tipPregleda: TipPregleda;
    lekar: Lekar;
}
