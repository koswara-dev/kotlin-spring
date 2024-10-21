package com.juaracoding.kotlin_spring.controllers

import com.juaracoding.kotlin_spring.models.Student
import com.juaracoding.kotlin_spring.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController()
@RequestMapping("/api/students")
class StudentController(@Autowired private val studentService: StudentService) {

    /*@GetMapping
    fun index() = "Starter Kotlin with Spring Boot 3"

    @GetMapping("/check")
    fun getVersion(@RequestParam("version") version: Int) = "Kotlin Spring Boot 3 version: $version"*/

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        return ResponseEntity.ok(studentService.getAllStudents())
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        return ResponseEntity.ok(studentService.getStudentById(id))
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteStudentById(id)
        return ResponseEntity.noContent().build()
    }

    // TODO: create, put, delete


}