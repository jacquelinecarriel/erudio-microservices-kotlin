package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one Person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Branquinho"
        person.lastName = "Costa"
        person.addressName = "Casita"
        person.gender = "gatito"
        return person
    }

}