package com.example.ethanapp.repository

import com.example.ethanapp.entity.Person
// import org.springframework.data.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
internal interface IPersonRepository : CrudRepository<Person, UUID>{
    // @Query("select * from person where gender = :gender")
    // fun filterByGender(gender: String) : List<Person>
}