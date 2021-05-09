package com.example.parkinglot.exception;

import com.example.parkinglot.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandlers
{
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleContactException(CustomException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception Occured", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ResponseDTO> handleException(IndexOutOfBoundsException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception Occured", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
