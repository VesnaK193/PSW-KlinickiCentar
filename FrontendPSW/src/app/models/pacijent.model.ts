import { User } from './user.model';
import { ZdravstveniKarton } from './zdravstveni-karton.model';

export class Pacijent {
    id:number;
    user:User;
    zdravstveniKarton:ZdravstveniKarton;
}
