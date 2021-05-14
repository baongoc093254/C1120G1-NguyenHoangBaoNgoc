import { Component, OnInit } from '@angular/core';
import {Product} from '../model/Product';
import {ProductService} from '../service/product.service';
import {Router} from '@angular/router';
import {Country} from '../model/Country';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public products: Product[] = [];
  public countrys: Country[] = [];

  constructor(private productService: ProductService,
              private route: Router,
              private dialog: MatDialog) { }


  ngOnInit(): void {
   this.productService.products2.subscribe(data => {
     this.products = data;
   }, error => {
     console.log(error);
   })
  }
  // getAllProduct() {
  //   this.products = this.productService.getAllProduct();
  // }

  showDetailProduct(id: number) {
    this.productService.getProductById(id);
    this.route.navigate(['/detail', id]);
  }
  openDialog(id: number): void {
    this.productService.getProductById(id).subscribe(data1 => {
      const dialogRef = this.dialog.open(DeleteComponent,{
        data: {data2: data1},
        width: '500px'
      })
      dialogRef.afterClosed().subscribe(result => {this.ngOnInit()})
    })

  }

}
