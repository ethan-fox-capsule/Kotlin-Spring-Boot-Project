package com.example.ethanapp.entity

import com.fasterxml.jackson.annotation.*
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import org.hibernate.annotations.*
import java.util.UUID
import javax.persistence.*
import javax.persistence.Entity

@Entity
@Serializable
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
class Person(

    @Id
    @Serializable(with = UUIDSerializer::class)
    val id: UUID = UUID.randomUUID(),
    val name: String?,
    val age: Int?,
    val gender: String?,

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    val doc: Doc? = null
)

@Serializable
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
class Doc(
    val stuff: Int? = null,

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    val nestedDoc: NestedDoc? = null
)

@Serializable
class NestedDoc(
    val nestedStuff: String? = null
)

@ExperimentalSerializationApi
@Serializer(forClass = UUID::class)
object UUIDSerializer : KSerializer<UUID> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }
}
