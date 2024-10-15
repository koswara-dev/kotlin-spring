package com.juaracoding.kotlin_spring.repository

import com.juaracoding.kotlin_spring.models.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    // add more method query
}