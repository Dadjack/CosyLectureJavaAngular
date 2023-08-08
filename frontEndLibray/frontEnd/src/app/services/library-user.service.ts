import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL_BACK_END_API } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LibraryUserService {

  constructor(private http: HttpClient) {}

  createLibraryUser(newUser: any) {
    return this.http.post(`${URL_BACK_END_API}/api/auth/signup`, newUser);
  }
}
