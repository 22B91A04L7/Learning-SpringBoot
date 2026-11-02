package com.venkat.crudSpringBoot.exception;

import com.venkat.crudSpringBoot.dto.ErrorRespDto;
import com.venkat.crudSpringBoot.dto.ValidationErrorRespDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorRespDto> handleResourceNotFoundException
            (ResourceNotFoundException e, HttpServletRequest request){

        ErrorRespDto errorResponse = new ErrorRespDto(request.getRequestURI(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorRespDto>
    handleDuplicateResourceException(DuplicateResourceException e,
                                     HttpServletRequest request){
        ErrorRespDto errorResponse = new ErrorRespDto(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorRespDto> handleValidationError(
            MethodArgumentNotValidException e, HttpServletRequest request){

        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                error -> fieldErrors.put(error.getField(), error.getDefaultMessage())
        );

        ValidationErrorRespDto errorResponse = new ValidationErrorRespDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_GATEWAY.getReasonPhrase(),
                "Validation Failed !",
                request.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorRespDto> handleHttpMessageNotReadableException
            (HttpMessageNotReadableException e, HttpServletRequest request){
        ErrorRespDto errorResponse = new ErrorRespDto(
                request.getRequestURI(),
                "Invalid request body. Please check your JSON \n" +
                        "format and data types.",
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorRespDto> handleArgumenmtMismatchException(
            MethodArgumentTypeMismatchException e, HttpServletRequest request){

        ErrorRespDto errorResponse = new ErrorRespDto(
                request.getRequestURI(),
                "Invalid value for parameter '" + e.getName() +
                        "'. Please check the required data type.",
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorRespDto> handleRunTimeException(RuntimeException e, HttpServletRequest request){

        ErrorRespDto errorResponse = new ErrorRespDto(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status
                        (HttpStatus.INTERNAL_SERVER_ERROR).
                body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRespDto> handleGenericException(Exception e, HttpServletRequest request){

        ErrorRespDto errorResponse = new ErrorRespDto(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
