package com.example.ethanapp.model

import com.example.ethanapp.entity.*
import kotlinx.serialization.*

@Serializable
class CreatePersonRequest(
    val name: String? = null,
    val gender: String? = null,
    val age: Int? = null,
    val doc: CreatePersonRequestDoc? = null
)

@Serializable
class CreatePersonRequestDoc(
    val stuff: Int? = null,
    val nestedDoc: ReqNestedDoc? = null
)

@Serializable
class ReqNestedDoc(
    val nestedStuff: String? = null
)

@Serializable
class CreatePersonResponse(
    val created: Person
)