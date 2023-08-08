import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BookComponent } from './book/book.component';
import { AdministratorComponent } from './administrator/administrator.component';
import { ErrorComponent } from './error/error.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path:'', redirectTo:'home',pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path:'book', component:BookComponent},
  {path:'register', component:RegisterComponent},
  {path:'admin', component:AdministratorComponent},
  {path:'**', component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
