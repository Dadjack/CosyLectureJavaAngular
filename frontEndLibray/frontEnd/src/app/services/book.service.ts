import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../models/book';
import { URL_BACK_END_API } from '../environments/environment';
import { map } from 'rxjs';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) { }

  getAllBooks() {
<<<<<<< HEAD
    return this.http
      .get<Book[]>(`${URL_BACK_END_API}/api/books/getAllBooks`)
      .pipe(
        map((data) => {
          console.log('data books');
=======
    return this.http.get<Book[]>(`${URL_BACK_END_API}/getAllBooks`).pipe(
      map(
        data => {
>>>>>>> 747073d0f0329f64c0531035a9fa9c36aeebaae1
          return data;
        })
      );
  }

  createBook(newBook: any) {
<<<<<<< HEAD
    return this.http.post(`${URL_BACK_END_API}/api/admin/createBook`, newBook);
=======
    return this.http.post(`${URL_BACK_END_API}/admin/createBook`, newBook);
>>>>>>> 747073d0f0329f64c0531035a9fa9c36aeebaae1
  }
}
