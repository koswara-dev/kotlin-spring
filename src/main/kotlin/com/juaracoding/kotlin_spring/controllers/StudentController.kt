package com.juaracoding.kotlin_spring.controllers

import com.juaracoding.kotlin_spring.models.Student
import com.juaracoding.kotlin_spring.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController()
@RequestMapping("/api/students")
class StudentController(@Autowired private val studentService: StudentService) {

    /*@GetMapping()
    fun index() = "Starter Kotlin with Spring Boot 3"

    @GetMapping("/check")
    fun getVersion(@RequestParam("version") version: Int) = "Kotlin Spring Boot 3 version: $version"*/

    @GetMapping()
    fun getAllStudents(): ResponseEntity<List<Student>> {
        return ResponseEntity.ok(studentService.getAllStudents())
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        return ResponseEntity.ok(studentService.getStudentById(id))
    }

    // TODO: create, put, delete


}