import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../book/book';
import { URL_BACK_END_API } from '../environments/environment';
import { map } from 'rxjs';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  getAllBooks() {
    return this.http.get<Book[]>(`${URL_BACK_END_API}/getAllBooks`).pipe(
      map(
        data => {
          console.log("data books")
          return data;
        }
      )
    )

  }
  // createBook(newBook: any) {
  //   return this.http.post(`${URL_BACK_END_API}/api/createBook`, newBook);
  // }
}
