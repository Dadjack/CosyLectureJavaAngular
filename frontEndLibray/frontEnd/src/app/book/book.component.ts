import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { Book } from '../models/book';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/category';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent {
  pages: number = 1;
  dataset: any[] = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'];

  constructor(
    private bookService: BookService,
    private categoryService: CategoryService
  ) {}

  books: Book[] = [];
  categories: Category[] = [];

  ngOnInit(): void {
    this.pages = 1;
    this.getBooksList();
    this.getCategoriesList();
  }

  getBooksList() {
    this.bookService.getAllBooks().subscribe({
      next: (dataBooks) => {
        this.books = dataBooks;
      },
    });
  }

  getCategoriesList() {
    this.categoryService.getAllCategories().subscribe({
      next: (dataCategories) => {
        this.categories = dataCategories;
      },
    });
  }
}
