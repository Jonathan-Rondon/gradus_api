package com.gradusapi.apirest.exception; // ou com.gradusapi.apirest.handler

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
    



@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

       
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", HttpStatus.CONFLICT.value()); // 409
        body.put("error", "Conflito de Recurso (Conflict)");
        body.put("message", ex.getMessage()); 
        
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", System.currentTimeMillis());
    body.put("status", HttpStatus.METHOD_NOT_ALLOWED.value()); // 405
    body.put("error", "Method Not Allowed");
    body.put("message", "O método HTTP '" + ex.getMethod() + "' não é suportado para esta rota.");
    body.put("path", request.getDescription(false).replace("uri=", ""));

    
    return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<Object> handleNoHandlerFoundException(Exception ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", System.currentTimeMillis());
    body.put("status", HttpStatus.NOT_FOUND.value());
    body.put("error", "Not Found");
    body.put("message", "A rota '" + request.getDescription(false).replace("uri=", "") + "' não existe.");
    body.put("path", request.getDescription(false).replace("uri=", ""));

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}