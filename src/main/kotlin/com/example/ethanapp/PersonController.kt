package com.example.ethanapp

import org.springframework.stereotype.Controller
import org.springframework.ui.*
import org.springframework.web.bind.annotation.*
import java.util.HashMap

@RestController
@RequestMapping("person")
class PersonController {

    @GetMapping("/parker")
    fun getOtherPerson(): Person {
        val p = Person("parker")
        return p
    }

    @GetMapping("/ethan")
    fun getPerson(): Person {
        val p = Person("ethan")
        return p
    }
}