import { Component, OnInit } from '@angular/core';
import {Student} from '../../model/Student';
import {StudentService} from '../../service/student.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  public student: Student;
  constructor(private studentService: StudentService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
   const index = this.activatedRoute.snapshot.params["id"];
   this.studentService.getStudentById(index).subscribe(data => {
     this.student = data;
   })
  }

}
