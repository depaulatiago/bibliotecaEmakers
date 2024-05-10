package com.example.projetoEmakers.exceptions.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@ControllerAdvice
public class GeneralExceptionHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<RestErrorMessage> entityNotFoundException(EntityNotFoundException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<RestErrorMessage>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<RestErrorMessage> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(fiedError -> new RestErrorMessage(HttpStatus.BAD_REQUEST, fiedError.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
