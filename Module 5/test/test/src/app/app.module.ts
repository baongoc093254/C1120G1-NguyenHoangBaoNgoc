import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student/student-list/student-list.component';
import {HttpClientModule} from '@angular/common/http';
import { StudentEditComponent } from './student/student-edit/student-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { StudentCreateComponent } from './student/student-create/student-create.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {StudentDeleteComponent} from './student/student-delete/student-delete.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentEditComponent,
    StudentCreateComponent,
    StudentDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        MatDialogModule,
        MatButtonModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
