package com.juaracoding.kotlin_spring.models

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "students")
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:NotBlank(message = "Firstname is required")
    val firstName: String,
    @field:NotBlank(message = "Lastname is required")
    val lastName: String,
    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Invalid email format")
    @Column(unique = true)
    val email: String,

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    val classroom: Classroom? = null

)