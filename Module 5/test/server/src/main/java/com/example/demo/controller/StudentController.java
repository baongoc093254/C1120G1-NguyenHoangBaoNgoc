package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.model.Tutor;
import com.example.demo.service.GroupService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private TutorService tutorService;

    @GetMapping("/student")
    public List<Student> getStudent() {
        return studentService.findAll();
    }

    @GetMapping("/group")
    public List<Group> getGroup() {
        return groupService.findAll();
    }

    @GetMapping("/tutor")
    public List<Tutor> getTutor() {
        return tutorService.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/student/create")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student student1 = studentService.save(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/student/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        Student editStudent = studentService.findById(id);
        if (editStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        editStudent.setName(student.getName());
        editStudent.setGroup(student.getGroup());
        editStudent.setNameProject(student.getNameProject());
        editStudent.setTutor(student.getTutor());
        editStudent.setEmail(student.getEmail());
        editStudent.setPhone(student.getPhone());
        this.studentService.save(editStudent);
        return new ResponseEntity<>(editStudent, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id) {
        Student deleteStudent = studentService.findById(id);
        if (deleteStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.studentService.delete(id);
        return new ResponseEntity<>(deleteStudent, HttpStatus.OK);
    }

//    @GetMapping("/student")
//    public List<Student> searchStudent(@RequestParam(name = "name") String name) {
//        return studentService.findAllByNameContaining(name);
//    }

}
