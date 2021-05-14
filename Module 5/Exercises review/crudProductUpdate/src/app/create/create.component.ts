import {Component, OnInit} from '@angular/core';
import {Product} from '../model/Product';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../service/product.service';
import {Router} from '@angular/router';
import {Country} from '../model/Country';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  rfProduct: FormGroup;
  countries: Country[] = [];
  products: Product[] = [];
  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private route: Router) { }

  ngOnInit(): void {
    this.getAllCountry();
    this.rfProduct = this.formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      cost: ['', [Validators.required]],
      dateStart: [''],
      country: [''],
      quantity: ['', [Validators.required, Validators.min(1)]]
    });
  }

  onCreateForm() {
    console.log(this.rfProduct.value);
    this.productService.save(this.rfProduct.value).subscribe(data =>  {
      this.route.navigateByUrl('/home');
    }, error =>
    console.log("Error"));
  }
  getAllCountry() {
    this.productService.getAllCountry().subscribe(data => {
      this.countries = data;
    })
  }
}
