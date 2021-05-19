import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentListComponent} from './student/student-list/student-list.component';
import {StudentEditComponent} from './student/student-edit/student-edit.component';
import {StudentCreateComponent} from './student/student-create/student-create.component';
import {StudentDetailComponent} from './student/student-detail/student-detail.component';


const routes: Routes = [
  {path: '', redirectTo: 'student', pathMatch: 'full'},
  {path: 'student', component: StudentListComponent},
  {path: 'student/edit/:id', component: StudentEditComponent},
  {path: 'student/detail/:id', component: StudentDetailComponent},
  {path: 'student/create', component: StudentCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
