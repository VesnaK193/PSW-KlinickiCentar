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
}