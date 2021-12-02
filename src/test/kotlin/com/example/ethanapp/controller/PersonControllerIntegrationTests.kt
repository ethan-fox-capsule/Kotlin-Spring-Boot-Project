package com.example.ethanapp.controller

import com.example.ethanapp.repository.PersonRepository
import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.*
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

class PersonControllerIntegrationTests {

    @Autowired
    internal lateinit var personRepository: PersonRepository

    companion object {
        @Container
        private val postgresContainer = PostgreSQLContainer<Nothing>("postgres:9.6-alpine")

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgresContainer::getUsername)
            registry.add("spring.datasource.password", postgresContainer::getPassword)
        }
    }

    @AfterEach
    fun clearTables() {
        personRepository.deleteAll()
    }
}