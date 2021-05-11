import { Component, OnInit } from '@angular/core';
import {Todo} from '../../model/Todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';

// tslint:disable-next-line:variable-name
let _id = 1;
@Component({
  selector: 'app-angular-todo',
  templateUrl: './angular-todo.component.html',
  styleUrls: ['./angular-todo.component.css']
})
export class AngularTodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  constructor() { }

  ngOnInit(): void {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const  todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }
}
