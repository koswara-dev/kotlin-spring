package com.juaracoding.kotlin_spring.repository

import com.juaracoding.kotlin_spring.models.Classroom
import org.springframework.data.jpa.repository.JpaRepository

interface ClassroomRepository : JpaRepository<Classroom, Long> {
    // add more method query
}