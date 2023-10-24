package org.mautig.trello.workspace.web.rest;

import org.mautig.trello.workspace.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<?> handleEntityNotFound(EntityNotFoundException ex) {
        return buildResponseEntity(new HttpException(HttpStatus.NOT_FOUND, ex));
    }

    private ResponseEntity<?> buildResponseEntity(HttpException httpException) {
        return new ResponseEntity<>(httpException, httpException.getStatus());
    }
}
