import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RatingComponent } from './rating/rating.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
