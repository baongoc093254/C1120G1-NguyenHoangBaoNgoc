import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  @Input('productAB') productDetail: Product | undefined;
  constructor() { }

  ngOnInit(): void {
  }

}
