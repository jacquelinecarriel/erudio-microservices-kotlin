package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

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

    fun create(person: Person) = person
    fun update(person: Person) = person
    fun delete(id: Long) = id

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last Name $i"
        person.addressName = "Some address $i"
        person.gender = "gatito"
        return person
    }

}