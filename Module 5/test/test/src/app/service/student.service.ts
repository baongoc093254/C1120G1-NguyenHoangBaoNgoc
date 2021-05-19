import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../model/Student';
import {Group} from '../model/Group';
import {Tutor} from '../model/Tutor';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  baseUrl : string = 'http://localhost:8080/student';
  baseUrlTutor : string = 'http://localhost:8080/tutor';
  baseUrlGroup: string = 'http://localhost:8080/group';
  httpOptions:any;
  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'}),
      'Access-Control-Allow-Origin': 'http://localhost:4200/', 
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
      'Access-Control-Allow-Credentials': "true"
    };
  }

  getAllStudent(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.baseUrl);
  }
  getAllGroup(): Observable<Group[]> {
    return this.httpClient.get<Group[]>(this.baseUrlGroup);
  }

  getAllTutors(): Observable<Tutor[]> {
    return this.httpClient.get<Tutor[]>(this.baseUrlTutor);
  }



  getStudentById(id: number): Observable<any> {
    return this.httpClient.get(this.baseUrl + '/' + id);
  }

  editProductById(student: Student, id: number): Observable<any> {
    return this.httpClient.put(this.baseUrl + '/' + id, student);
  }

  createStudent(student: Student): Observable<Student[]> {
    return this.httpClient.post<Student[]>(this.baseUrl, student);
  }
  deleteProductById(id: number): Observable<any> {
    return this.httpClient.delete(this.baseUrl + '/' + id, this.httpOptions);
  }

  // search(keySearch: string): Observable<Student[]> {
  //   return this.httpClient.get<Student[]>(this.baseUrl + '?q=' + keySearch, this.httpOptions);
  //
  // }


}
