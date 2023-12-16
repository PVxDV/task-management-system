package com.pvxdv.taskmanagementsystem.advices;

import com.pvxdv.taskmanagementsystem.dto.ErrorResponseDTO;
import com.pvxdv.taskmanagementsystem.exception.AccessErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(AccessErrorException e) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(LocalDate.now(), 400, "BAD_REQUEST",
                stackTraceToString(e), e.getMessage());

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    private String stackTraceToString (Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
