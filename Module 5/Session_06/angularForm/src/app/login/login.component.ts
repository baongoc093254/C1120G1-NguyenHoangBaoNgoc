import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public user: User = {email: '', password: '', gender: 0, age: 19, country: 'Viet Nam', phone: ''};
  constructor() { }

  ngOnInit(): void {
  }

  onSubmitForm(userLogin: NgForm) {
   if (userLogin.valid) {
     console.log(this.user);
   }
  }
}
