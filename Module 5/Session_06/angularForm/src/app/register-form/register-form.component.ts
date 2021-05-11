import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  // public user: User = {email: '', password: '', confirmPassword: '', age: 0, gender: 0, country: '', phone: 0};

  rfUser: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.rfUser = this.formBuilder.group({
      email: ['', [Validators.required], [Validators.email]],
      password: ['', [Validators.required]],
      country: [''],
      age: ['', [Validators.required], [Validators.min(18)], [Validators.max(100)]],
      gender: [],
      phone: ['', [Validators.required], ]
    });
  }

  onSubmitForm() {
      console.log(this.rfUser.value);
  }
}
