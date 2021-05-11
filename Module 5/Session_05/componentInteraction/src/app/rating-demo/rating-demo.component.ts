import { Component, Input, OnInit, Output, EventEmitter, SimpleChanges } from '@angular/core';
import { type } from 'os';

@Component({
  selector: 'app-rating-demo',
  templateUrl: './rating-demo.component.html',
  styleUrls: ['./rating-demo.component.css']
})
export class RatingDemoComponent implements OnInit {
  @Input() max = 10;
  @Input() ratingValue = 5;
  @Input() showRatingValue = true;

  @Output() rateChange = new EventEmitter<number>();
  ratingUnits: Array<IRatingUnit> = [];

  constructor() { }
  
  ngOnChanges(changes: SimpleChanges) {
    if ('max' in changes) {
        let max = changes.max.currentValue;
        max = typeof max === 'underfined' ? 5 : max;
        this.max = max;
        this.calculte(max, this.ratingValue);
    }
  }

  ngOnInit(): void {
  }

}
