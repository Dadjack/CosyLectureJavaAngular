import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgxPaginationModule } from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BookComponent } from './book/book.component';
import { AdministratorComponent } from './administrator/administrator.component';
import { AddBookComponent } from './add-book/add-book.component';
import { FormsModule } from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { CategoryComponent } from './category/category.component';
<<<<<<< HEAD
import { RegisterComponent } from './register/register.component';
=======
import { AuthorComponent } from './author/author.component';
>>>>>>> 747073d0f0329f64c0531035a9fa9c36aeebaae1



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookComponent,
    AdministratorComponent,
    AddBookComponent,
    ErrorComponent,
    HeaderComponent,
    CategoryComponent,
<<<<<<< HEAD
    RegisterComponent
=======
    AuthorComponent
>>>>>>> 747073d0f0329f64c0531035a9fa9c36aeebaae1
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgxPaginationModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
