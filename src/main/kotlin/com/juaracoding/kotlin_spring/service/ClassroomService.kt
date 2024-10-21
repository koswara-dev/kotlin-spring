package com.juaracoding.kotlin_spring.service;

import com.juaracoding.kotlin_spring.models.Classroom;
import com.juaracoding.kotlin_spring.repository.ClassroomRepository
import org.springframework.stereotype.Service;

@Service
class ClassroomService(private val classroomRepository: ClassroomRepository) {

    fun getAllClassrooms(): List<Classroom> = classroomRepository.findAll()

    fun getClassroomById(id: Long): Classroom? = classroomRepository.findById(id).orElse(null)

    fun saveClassroom(classroom: Classroom): Classroom = classroomRepository.save(classroom)

    fun updateClassroom(id: Long, updateClassroom: Classroom): Classroom? {
        return if(classroomRepository.existsById(id)){
            classroomRepository.save(updateClassroom.copy(id = id))
        } else {
            null
        }
    }

    fun deleteClassroom(id: Long) {
        if(classroomRepository.existsById(id)){
            classroomRepository.deleteById(id)
        }
    }

}
