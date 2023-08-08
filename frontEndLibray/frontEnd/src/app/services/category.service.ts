import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from '../category/category';
import { URL_BACK_END_API } from '../environments/environment';
import { map } from 'rxjs';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  getAllCategories() {
    return this.http.get<Category[]>(`${URL_BACK_END_API}/api/category/getAllCategories`).pipe(
      map(
        data => {
          console.log("data categories")
          return data;
        }
      )
    )
  }

  createCategory(newBook: any) {
    return this.http.post(`${URL_BACK_END_API}/admin/createCategory`, newBook);
  }
}
