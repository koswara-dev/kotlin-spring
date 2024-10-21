package com.juaracoding.kotlin_spring.controllers

import com.juaracoding.kotlin_spring.models.Classroom
import com.juaracoding.kotlin_spring.service.ClassroomService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/classrooms")
class ClassroomController(private val classroomService: ClassroomService) {

    @GetMapping
    fun getAllClassrooms(): List<Classroom> = classroomService.getAllClassrooms()

    @GetMapping("/{id}")
    fun getClassroomById(@PathVariable id: Long): ResponseEntity<Classroom> {
        val classroom = classroomService.getClassroomById(id)
        return if (classroom != null) ResponseEntity.ok(classroom) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createClassroom(@Valid @RequestBody classroom: Classroom): ResponseEntity<Classroom> {
        val savedClassroom = classroomService.saveClassroom(classroom)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClassroom)
    }

    @PutMapping("/{id}")
    fun updateClassroom(@PathVariable id: Long, @Valid @RequestBody classroom: Classroom): ResponseEntity<Classroom> {
        val updatedClassroom = classroomService.updateClassroom(id, classroom)
        return if (updatedClassroom != null) ResponseEntity.ok(updatedClassroom) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteClassroom(@PathVariable id: Long): ResponseEntity<Void> {
        classroomService.deleteClassroom(id)
        return ResponseEntity.noContent().build()
    }

}