package br.com.erudio.controller

import br.com.erudio.converters.NumberConverter.convertToDouble
import br.com.erudio.converters.NumberConverter.isNumeric
import br.com.erudio.model.Person
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/person")
class MathController {

    @Autowired
    private lateinit var service : PersonService

    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun sum(
        @PathVariable(value = "id")
        id: Long,

    ): Person {
        return service.findById(id)
    }

}






