package com.example.ethanapp.repository

import com.example.ethanapp.entity.Person
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface PersonRepository : CrudRepository<Person, UUID> {

    fun findByGender(gender: String): Person
}