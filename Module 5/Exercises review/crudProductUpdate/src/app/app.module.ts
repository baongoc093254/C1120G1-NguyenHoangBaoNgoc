import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProductService} from './service/product.service';
import {CreateComponent} from './create/create.component';
import {ListComponent} from './list/list.component';
import {DetailComponent} from './detail/detail.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import { DeleteComponent } from './delete/delete.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  declarations: [ AppComponent,
    CreateComponent,
    ListComponent,
    DetailComponent,
    DeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
      FormsModule,
      HttpClientModule,
      CommonModule,
      BrowserAnimationsModule,
      MatDialogModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
