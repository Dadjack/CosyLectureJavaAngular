import { Component } from '@angular/core';
import { AuthorService } from '../services/author.service';
import { Author } from './author';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent {

  constructor(private authorService: AuthorService) { }

  authors: Author[] = [];

  ngOnInit(): void {
    this.getAuthorsList();
  };

  getAuthorsList() {
    this.authorService.getAllAuthors().subscribe({
      next: authorData => {
        this.authors = authorData;
      }
    })
  }
}
