package br.com.erudio.excepctions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.RestController
import br.com.erudio.excepctions.ExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

@ControllerAdvice
@RestController
class ExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)

    }    fun handleBadRequestExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

}