import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { Book } from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {
  constructor(private bookService: BookService) { }

  books: Book[] = [];
  ngOnInit():void{
    this.getBooksList();
    console.log("récup des livres")
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
