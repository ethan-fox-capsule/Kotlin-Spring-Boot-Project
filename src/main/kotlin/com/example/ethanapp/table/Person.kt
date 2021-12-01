package com.example.ethanapp.table

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table
data class Person(

    @Id var id: UUID,

    var name: String?,
    var age: Number?,
    var gender: String?
)