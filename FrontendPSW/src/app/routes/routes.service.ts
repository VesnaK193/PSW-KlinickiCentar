import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class RoutesService {

    private _app_url = 'http://localhost:8088/'

    get getAllUsers(): string{
        return this._app_url + 'getAllUsers';
    }

    get login(): string{
        return this._app_url + 'login';
    }

    get saveUser() : string{
        return this._app_url + 'saveUser';
    }

    get getAllUsersOnHold(): string{
        return this._app_url + 'getAllUsersOnHold';
    }

    get getUserById(): string{
        return this._app_url + 'getUserById';
    }

    get sendLink(): string{
        return this._app_url + 'sendLink';
    }

    get rejectRequest(): string{
        return this._app_url + 'rejectRequest';
    }

    get getAllLekarsByKlinikaId(): string {
        return this._app_url + 'getAllLekarsByKlinikaId';
    }

    get getAllKlinikaByTipPregledaId(): string {
        return this._app_url + 'getAllKlinikaByTipPregledaId';
    }

    get getSearchedLekars(): string {
        return this._app_url + 'getSearchedLekars';
    }

    get getAllTipovePregleda(): string {
        return this._app_url + 'getAllTipovePregleda';
    }

    get getPacijentByUserId(): string {
        return this._app_url + 'getPacijentByUserId';
    }

    get getAllPredefinisaniPreglediKlinike(): string {
        return this._app_url + 'getAllPredefinisaniPreglediKlinike';
    }

    get postExaminationRequest(): string {
        return this._app_url + 'postExaminationRequest';
    }

    get getCenaByKlinikaAndTip(): string {
        return this._app_url + 'getCenaByKlinikaAndTip';
    }

    get postExamination(): string {
        return this._app_url + 'postExamination';
    }
}