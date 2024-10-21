package com.juaracoding.kotlin_spring.service

import com.juaracoding.kotlin_spring.models.Student
import com.juaracoding.kotlin_spring.repository.StudentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll().map { student ->  
            Student(student.id, student.firstName, student.lastName, student.email, student.classroom)
        }
    }

    fun getStudentById(id: Long): Student {
        val student = studentRepository.findById(id).orElseThrow{
            throw IllegalArgumentException("Student with id $id not found")
        }
        return Student(student.id, student.firstName, student.lastName, student.email, student.classroom)
    }

    fun saveStudent(student: Student): Student {
        val studentRes = studentRepository.save(student)
        return Student(studentRes.id, studentRes.firstName,
            studentRes.lastName, studentRes.email, studentRes.classroom)
    }

    fun deleteStudentById(id: Long) {
        if(!studentRepository.existsById(id)) {
            throw IllegalArgumentException("Student with id $id not found")
        }
        studentRepository.deleteById(id)
    }

}