import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL_BACK_END_API } from '../environments/environment';
import { map } from 'rxjs';
import { Author } from '../author/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  getAllAuthors() {
    return this.http.get<Author[]>(`${URL_BACK_END_API}/getAllAuthors`).pipe(
      map(
        data => {
          return data;
        }
      )
    )
  }

  createAuthor(newAuthor: any) {
    return this.http.post(`${URL_BACK_END_API}/admin/createAuthor`, newAuthor);
  }
}
