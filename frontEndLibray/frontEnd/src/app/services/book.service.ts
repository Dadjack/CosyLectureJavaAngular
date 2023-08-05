import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Book } from '';
import { URL_BACK_END_API } from '../environments/environment';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  createBook(newBook: any) {
    return this.http.post(`${URL_BACK_END_API}/api/createBook`, newBook);
  }
}
