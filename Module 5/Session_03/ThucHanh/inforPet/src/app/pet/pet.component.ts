import { Component, OnInit } from '@angular/core';
import {Pet} from '../pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'Chery Real',
    image:  'https://www.thesprucepets.com/thmb/MysS9-nXni5Mq53c4H3l7lxLJ8U=/1936x1089/smart/filters:no_upscale()/AmericanPitBullTerrierMoniqueRodriguez-be4b597e914e46f084adbe5f0a2a9ccc.jpg'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
