import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../model/Product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  constructor(private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }
  public product: Product;
  ngOnInit(): void {
    const index = this.activatedRoute.snapshot.params['id'];
    console.log('Id nhan duoc: ' + index);
    this.productService.getProductById(index).subscribe(data => {
      // @ts-ignore
      this.product = data;
    });
  }


  showUpdateQuantity() {
    // khi method duoc goi thi element HTML co id la updateQuantity se dc hien thi ra
    document.getElementById('updateQuantity').style.display = 'block';
  }

  setNewQuantity(value: string) {
    // // tslint:disable-next-line:radix
    // this.productDetail.quantity = parseInt(value);
    // this.onUpdate.emit(this.productDetail);
  }

  backToList() {
    this.router.navigate(['/','home']);
    // this.router.navigateByUrl('/home');
  }
}
