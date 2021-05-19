import { Component, OnInit } from '@angular/core';
import {Student} from '../../model/Student';
import {StudentService} from '../../service/student.service';
import {MatDialog} from '@angular/material/dialog';
import {StudentDeleteComponent} from '../student-delete/student-delete.component';
import {Group} from '../../model/Group';
import {Tutor} from '../../model/Tutor';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  public students: Student[] = [];
  public groups: Group[] = [];
  public tutors: Tutor[] = [];
  keySearch = '';
  constructor(private studentService: StudentService,
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.studentService.getAllGroup().subscribe(data => {
      this.groups = data;
    })
    this.studentService.getAllTutors().subscribe(data => {
      this.tutors = data;
    })
    this.studentService.getAllStudent().subscribe(data => {
      this.students = data;
    }, error => {
      alert("Error !");
    })
  }

  openDialog(id: number) {
    this.studentService.getStudentById(id).subscribe(dataStudent => {
      const dialogRef = this.dialog.open(StudentDeleteComponent,{
        data: {data1: dataStudent},
        width: '500px',
        disableClose: true
      })
      console.log('id nhan dc ' + id);
      console.log(dataStudent);
      dialogRef.afterClosed().subscribe(result => {this.ngOnInit()})
    })
  }

  // search() {
  //   this.studentService.search(this.keySearch).subscribe(data => {
  //     this.students = data;
  //     console.log(data);
  //   })
  // }
  search() {
    this.studentService.searchStudent(this.keySearch).subscribe(data => {
      this.students = data;
    })
  }
}
