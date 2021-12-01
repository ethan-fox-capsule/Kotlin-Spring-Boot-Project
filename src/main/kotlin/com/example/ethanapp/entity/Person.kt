package com.example.ethanapp.entity

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import java.util.UUID
import javax.persistence.Id
import javax.persistence.Entity

@Entity
@Serializable
class Person(
    @Id
    @Serializable(with = UUIDSerializer::class)
    var id: UUID,
    var name: String?,
    var age: Int?,
    var gender: String?,
    var doc: String? = null
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
