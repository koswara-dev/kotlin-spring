package com.juaracoding.kotlin_spring.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/students")
class StudentController {

    @GetMapping()
    fun index() = "Starter Kotlin with Spring Boot 3"

    @GetMapping("/check")
    fun getVersion(@RequestParam("version") version: Int) = "Kotlin Spring Boot 3 version: $version"

}