package com.juaracoding.kotlin_spring.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "classrooms")
data class Classroom(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotBlank(message = "Classroom name is required")
    val name: String,

)