import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { Book } from './book';


@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {

  pages: number = 1;
  dataset: any[] = ['1','2','3','4','5','6','7','8','9','10'];


  constructor(private bookService: BookService) { }

  books: Book[] = [];

  ngOnInit():void{
    this.pages =1;
    this.getBooksList();
  };

  getBooksList() {
    this.bookService.getAllBooks().subscribe({
      next: dataBooks => {
        this.books = dataBooks;
      }
    }
    )
  }
}
