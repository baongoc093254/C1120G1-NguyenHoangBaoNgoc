import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Student} from '../../model/Student';
import {StudentService} from '../../service/student.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Group} from '../../model/Group';
import {Tutor} from '../../model/Tutor';


@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css']
})
export class StudentEditComponent implements OnInit {
  rfEditStudent: FormGroup;
  public students: Student[] = [];
  public groups: Group[] = [];
  id: number = 0;
  public tutors: Tutor[] = [];
  constructor(private studentService: StudentService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log('id edit ' + this.id);
    this.studentService.getStudentById(this.id).subscribe(data => {
      this.rfEditStudent.patchValue(data);
    })
    this.getAllGroup();
    this.getAllTutor();
    this.rfEditStudent = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9 ]+$')]],
      group: ['', [Validators.required]],
      nameProject: ['', [Validators.required]],
      tutor: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern("(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)")]]
    });
  }


  onSubmit() {
    console.log(this.rfEditStudent.value);
    this.studentService.editProductById(this.rfEditStudent.value, this.id).subscribe(data => {
      this.router.navigateByUrl('/student');
    }, error => {
      console.log("Error !");
    })

  }

  private getAllGroup() {
    this.studentService.getAllGroup().subscribe(data => {
      this.groups = data;
    })
  }
  backToList() {
    this.router.navigate(['/','student']);
    // this.router.navigateByUrl('/home');
  }
  cancel() {
    this.router.navigate(['/', 'student']);
  }

  getAllTutor() {
    this.studentService.getAllTutors().subscribe(data => {
      this.tutors = data;
    })
  }
}
