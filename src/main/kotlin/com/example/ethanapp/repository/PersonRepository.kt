package com.example.ethanapp.repository

import com.example.ethanapp.entity.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
// import org.springframework.data.jdbc.repository.query.Query
// import org.springframework.data.repository.CrudRepository
// import org.springframework.stereotype.Repository
import java.util.UUID

interface PersonRepository : CrudRepository<Person, UUID>{
    // @Query("select * from person where gender = :gender")
    // fun filterByGender(gender: String) : List<Person>

    @Query("SELECT * FROM person", nativeQuery = true)
    fun getAll() : List<Person>
}