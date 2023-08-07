import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../services/book.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-administrator',
  templateUrl: './administrator.component.html',
  styleUrls: ['./administrator.component.css']
})
export class AdministratorComponent {

  constructor(private router: Router,private bookService: BookService){}

  id!: number;
  //book!: Book;
  //messageError!: string;

  // enregistrerUtilisateur(formulaire: NgForm){
  //     this.bookService.createBook(this.book).subscribe(
  //       data => {
  //         console.log(data);
  //         this.router.navigate(['/utilisateurs']);
  //       }
  //     );
  //   }
  }
