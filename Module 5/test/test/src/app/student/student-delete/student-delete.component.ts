import {Component, Inject, OnInit} from '@angular/core';
import {StudentService} from '../../service/student.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-student-delete',
  templateUrl: './student-delete.component.html',
  styleUrls: ['./student-delete.component.css']
})
export class StudentDeleteComponent implements OnInit {
  public studentName;
  public studentId;
  id: number;
  constructor(private studentService: StudentService,
              private dialogRef: MatDialogRef<StudentDeleteComponent>,
              @Inject(MAT_DIALOG_DATA)private data: any) { }

  ngOnInit(): void {
    this.studentName = this.data.data1.name;
    this.studentId = this.data.data1.id;
    console.log(this.studentName);
    console.log(this.studentId);
  }


  deleteProduct() {
    this.studentService.deleteProductById(this.studentId).subscribe(data => {
      console.log(data);
      this.dialogRef.close();
    })
  }
  close() {
    this.dialogRef.close();
  }
}
