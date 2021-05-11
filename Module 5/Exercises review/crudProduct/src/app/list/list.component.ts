import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  arrProduct = [
    {id: 1, name: 'Iphone 10 Promax', cost: 2200, dateStart: '2020/12/12', location: 'USA', quantity: 12},
    {id: 2, name: 'Iphone 7 Promax', cost: 2200, dateStart: '2020/12/12', location: 'USA' , quantity: 12},
    {id: 3, name: 'Iphone 8 Promax', cost: 2200, dateStart: '2020/12/12', location: 'USA' , quantity: 12},
    {id: 4, name: 'Iphone 9 promax', cost: 2200, dateStart: '2020/12/12', location: 'USA' , quantity: 12},
    {id: 5, name: 'Iphone 13 Promax', cost: 2200, dateStart: '2020/12/12', location: 'USA' , quantity: 12},
    {id: 6, name: 'iphone 14 Promax', cost: 2200, dateStart: '2020/12/12', location: 'USA' , quantity: 12}
  ];
  constructor() { }
  public product: Product | undefined;

  ngOnInit(): void {
  }

  onGetProduct(value: Product) {
    this.arrProduct.unshift(value);
  }

  showDetailProduct(item: Product) {
    this.product = item;
  }
}
