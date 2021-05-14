import {Component, Inject, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../model/Product';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  public product1;
  public product2;
  constructor(private productService: ProductService,
              private  router: Router,
              private dialogRef: MatDialogRef<DeleteComponent>,
              @Inject(MAT_DIALOG_DATA)private data: any) { }

  ngOnInit(): void {
    this.product1 = this.data.data1.id;
    this.product2 = this.data.data1.id;

  }

  deleteProductById() {
    this.productService.deleteProductById(this.product2).subscribe(data => {
      this.dialogRef.close();
    })
  }

}
