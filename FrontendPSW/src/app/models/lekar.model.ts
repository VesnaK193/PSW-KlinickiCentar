import { User } from './user.model';
import { Klinika } from './klinika.model';
import { RadniKalendar } from './radni-kalendar.model';

export class Lekar {
    id:number;
    specijalizacija:string;
    opis:string;
    user:User;
    klinika:Klinika;
    radniKalendar:RadniKalendar;
}
