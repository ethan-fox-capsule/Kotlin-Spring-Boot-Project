package com.example.ethanapp.repository

import com.example.ethanapp.table.Person
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PersonRepository : CrudRepository<Person, UUID>{
    @Query("select * from person where gender = :gender")
    fun filterByGender(gender: String) : List<Person>

    @Query("select * from person")
    fun getAll() : List<Person>
}