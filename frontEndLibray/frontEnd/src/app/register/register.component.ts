import { Component } from '@angular/core';
import { LibraryUser } from '../models/libraryUser';
import { LibraryUserService } from '../services/library-user.service'
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title: string = "Création de l'utilisateur";

  constructor(private router: Router,private libraryUserService: LibraryUserService) {}

  libraryUser: LibraryUser = new LibraryUser;

  register(form: NgForm) {
    console.log("je suis là");
    this.libraryUserService.createLibraryUser(this.libraryUser).subscribe(
      result => {
              this.goToConnexion();
            });
  }

  goToConnexion(){
    this.router.navigate(['/connexion'])
  }

}
