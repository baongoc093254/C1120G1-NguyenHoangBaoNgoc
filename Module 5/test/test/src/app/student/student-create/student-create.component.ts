import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../../service/student.service';
import {Student} from '../../model/Student';
import {Router} from '@angular/router';
import {Group} from '../../model/Group';
import {Tutor} from '../../model/Tutor';


@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  rfStudent: FormGroup;
  students: Student;
  groups: Group[] = [];
  tutors: Tutor[] = [];
  constructor(private studentService: StudentService,
              private formBuilder: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllGroupCreate();
    this.getAllTutor();
    this.rfStudent = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9 ]+$')]],
      group: ['', [Validators.required]],
      nameProject: ['', [Validators.required]],
      tutor: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern("(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)")]]
    });
  }

  onCreateForm() {
    console.log(this.rfStudent.value);
    this.studentService.createStudent(this.rfStudent.value).subscribe(data =>  {
      this.router.navigateByUrl('/student');
    }, error =>
      console.log("Error"));

  }

   getAllGroupCreate() {
    this.studentService.getAllGroup().subscribe(data => {
       this.groups = data;
    })

  }

  private getAllTutor() {
    this.studentService.getAllTutors().subscribe(data => {
      this.tutors = data;
    })
  }
}
