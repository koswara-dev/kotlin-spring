package com.juaracoding.kotlin_spring.service

import com.juaracoding.kotlin_spring.models.Student
import com.juaracoding.kotlin_spring.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {

    /*fun getAllStudents(): List<Student> {
        return studentRepository.findAll().map { student ->  
            Student(student.id, student.firstName, student.lastName, student.email, student.student)
        }
    }*/

    fun getAllStudents(): List<Student> = studentRepository.findAll()

    fun getStudentById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    fun saveStudent(student: Student): Student = studentRepository.save(student)

    fun updateStudent(id: Long, updateStudent: Student): Student? {
        return if(studentRepository.existsById(id)){
            studentRepository.save(updateStudent.copy(id = id))
        } else {
            null
        }
    }

    fun deleteStudent(id: Long) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id)
        }
    }

}