import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  // tslint:disable-next-line:no-output-on-prefix no-output-rename
  @Output('productCreate') onCreate = new EventEmitter<Product>();
  constructor() { }
  public product: Product | undefined;

  ngOnInit(): void {
  }

  createProduct(id: string, name: string, cost: string, dateStart: string, location: string, quantity: string) {
    // tslint:disable-next-line:radix
    this.product = new Product(parseInt(id), name, parseInt(cost), dateStart, location, parseInt(quantity));
    this.onCreate.emit(this.product);
  }


}
