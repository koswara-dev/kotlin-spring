package com.juaracoding.kotlin_spring.controllers

import com.juaracoding.kotlin_spring.models.Student
import com.juaracoding.kotlin_spring.service.StudentService
import jakarta.validation.Valid
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
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/students")
class StudentController(@Autowired private val studentService: StudentService) {

    /*@GetMapping
    fun index() = "Starter Kotlin with Spring Boot 3"

    @GetMapping("/check")
    fun getVersion(@RequestParam("version") version: Int) = "Kotlin Spring Boot 3 version: $version"*/

    @GetMapping
    fun getAllStudents(): List<Student> = studentService.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) ResponseEntity.ok(student) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createStudent(@Valid @RequestBody student: Student): ResponseEntity<Student> {
        val savedStudent = studentService.saveStudent(student)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent)
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @Valid @RequestBody student: Student): ResponseEntity<Student> {
        val updatedStudent = studentService.updateStudent(id, student)
        return if (updatedStudent != null) ResponseEntity.ok(updatedStudent) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteStudent(id)
        return ResponseEntity.noContent().build()
    }

    // TODO: pageable, sorting, search


}