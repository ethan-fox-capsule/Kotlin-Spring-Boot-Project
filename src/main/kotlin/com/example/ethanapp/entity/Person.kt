package com.example.ethanapp.entity

import com.example.ethanapp.serializer.InstantSerializer
import com.example.ethanapp.serializer.UUIDSerializer
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import kotlinx.serialization.*
import org.hibernate.annotations.*
import java.time.Instant
import java.util.UUID
import javax.persistence.*
import javax.persistence.Entity

@Entity
@Serializable
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
data class Person (

    @Id
    @Serializable(with = UUIDSerializer::class)
    val id: UUID = UUID.randomUUID(),
    val name: String?,
    val age: Int?,
    val gender: String?,

    @Serializable(with = InstantSerializer::class)
    @Column(name = "created_at")
    val createdAt: Instant = Instant.now(),

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    val doc: Doc? = null
)

@Serializable
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
data class Doc(
    val stuff: Int? = null,

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    val nestedDoc: NestedDoc? = null
)

@Serializable
data class NestedDoc(
    val nestedStuff: String? = null
)
