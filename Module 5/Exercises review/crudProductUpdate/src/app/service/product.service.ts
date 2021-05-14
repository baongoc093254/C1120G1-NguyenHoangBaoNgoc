import { Injectable } from '@angular/core';
import {Product} from '../model/Product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  countries: string[] = ['VietNam', 'USA', 'HongKong', 'Russia'];
  // products: Product[] = [
  //   {id: 1, name: 'Iphone 10 Promax', cost: 22000000, dateStart: '2020/01/12', country: 'USA', quantity: 12},
  //   {id: 2, name: 'Iphone 7 Promax', cost: 22000000, dateStart: '2020/05/10', country: 'China' , quantity: 7},
  //   {id: 3, name: 'Iphone 8 Promax', cost: 22000000, dateStart: '2020/09/03', country: 'VietNam' , quantity: 5},
  //   {id: 4, name: 'Iphone 9 promax', cost: 22000000, dateStart: '2020/03/09', country: 'Italy' , quantity: 10},
  //   {id: 5, name: 'Iphone 13 Promax', cost: 22000000, dateStart: '2020/10/10', country: 'Korean' , quantity: 9},
  //   {id: 6, name: 'iphone 14 Promax', cost: 22000000, dateStart: '2020/7/12', country: 'England' , quantity: 15}
  // ];
  private API_URL = "http://localhost:3000/products";
  private API_URL2 = "http://localhost:3000/country";
  constructor(private httpClient: HttpClient) { }

  get products2(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API_URL);
}
  save(product: Product): Observable<Product[]> {
    return this.httpClient.post<Product[]>(this.API_URL, product);
  }

  getProductById(id: number): Observable<Product[]> {
    console.log(id);
    return this.httpClient.get<Product[]>(`${this.API_URL}/${id}`);
  }

  getAllCountry(): Observable<any> {
    return this.httpClient.get(this.API_URL2);

  }
  deleteProductById(id: number): Observable<any> {
    return this.httpClient.delete(this.API_URL + '/' + id);
  }
  // getAllProduct() {
  //   return this.products;
  // }
  //
  // saveProduct(product) {
  //   return this.products.unshift(product);
  // }
  //
  // findProductById(id: number) {
  //   console.log('id nhan dc: ' + id);
  //   for (let i = 0; i < this.products.length ; i++) {
  //     if (this.products[i].id == id) {
  //       console.log(this.products[i]);
  //       return this.products[i];
  //     }
  //   }
  //   return  null;
  // }

}
