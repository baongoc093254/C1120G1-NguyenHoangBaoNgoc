import { Injectable } from '@angular/core';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [{
    id: 1,
    name: 'Iphone 12'
  }, {
    id: 2,
    name: 'Iphone 13'
  }, {
    id: 3,
    name: 'Iphone 11'
  }];
  constructor() { }

  getAllProduct() {
    return this.categories;
  }

  saveCategory(category) {
    this.categories.push(category);
  }

  findById(id: number) {
    return this.categories.find(category => category.id === id);
  }

  updateCategory(id: number, category: Category) {
    for (let i = 0; i < this.categories.length ; i++) {
      if (this.categories[i] == id) {
        this.categories[i] = category
      }
    }
  }

  deleteCategory(id: number) {
    this.categories = this.categories.filter(category => {
      return category.id !== id;
    })
  }
}
