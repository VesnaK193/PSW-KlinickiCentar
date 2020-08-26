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

    get register() : string{
        return this._app_url + 'register';
    }
}