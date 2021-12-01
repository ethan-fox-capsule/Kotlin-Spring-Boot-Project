package com.example.ethanapp.controller

import com.example.ethanapp.repository.PersonRepository
import com.example.ethanapp.entity.Person
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("person")
class PersonController(
    val personRepository: PersonRepository
) {

    @GetMapping("/")
    fun getPeople(): Iterable<Person> {
        System.out.print("HERERERE")
        val x = personRepository.findAll()
        x.forEach { System.out.println(it) }
        return x
    }

    // @GetMapping("/{id}")
    // fun getPersonById(@RequestParam(value="id") id String) : Person {
    //
    // }

    @GetMapping("/parker")
    fun getOtherPerson(): Person {
        val p = Person(
            id= UUID.randomUUID(),
            name="parker",
            age=15,
            gender = "male"
        )
        return p
    }

    @GetMapping("/ethan")
    fun getPerson(): Person {
        val p = Person(
            id= UUID.randomUUID(),
            name="ethan",
            age=18,
            gender = "male"
        )
        return p
    }

}