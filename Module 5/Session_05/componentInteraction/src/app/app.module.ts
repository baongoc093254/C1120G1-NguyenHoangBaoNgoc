import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NameCardComponent } from './name-card/name-card.component';
import { AngularProgressBarComponent } from './angular-progress-bar/angular-progress-bar.component';
import { RatingComponent } from './rating/rating.component';
import { RatingModule } from 'ng-starrating';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RatingDemoComponent } from './rating-demo/rating-demo.component';


@NgModule({
  declarations: [
    AppComponent,
    NameCardComponent,
    AngularProgressBarComponent,
    RatingComponent,
    RatingDemoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RatingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
