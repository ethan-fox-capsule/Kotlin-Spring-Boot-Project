package com.example.ethanapp.controller

import com.example.ethanapp.entity.*
import com.example.ethanapp.repository.PersonRepository
import com.example.ethanapp.model.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("person")
class PersonController(
    val personRepository: PersonRepository
) {

    @GetMapping("/")
    fun getPeople(): Iterable<Person> {
        return personRepository.findAll()
    }

    @GetMapping("/{personId}")
    fun getPersonById(@PathVariable personId: String) : Optional<Person> {
        return personRepository.findById(UUID.fromString(personId))
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun createPerson(@RequestBody createPersonRequest: CreatePersonRequest): CreatePersonResponse {

        val p = Person(
            name = createPersonRequest.name,
            age = createPersonRequest.age,
            gender = createPersonRequest.gender,
            doc = createPersonRequest.doc?.let {
                Doc(
                    createPersonRequest.doc.stuff,
                    NestedDoc(
                        createPersonRequest.doc.nestedDoc?.nestedStuff)) }
        )

        personRepository.save(p)
        return CreatePersonResponse(p)
    }
}