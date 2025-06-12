package com.mani.example.bookmyshowjun25.exceptionHandler;

import com.mani.example.bookmyshowjun25.exceptions.PasswordNotMatchException;
import com.mani.example.bookmyshowjun25.exceptions.ShowSeatNotFoundException;
import com.mani.example.bookmyshowjun25.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>("User not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ShowSeatNotFoundException.class)
    public ResponseEntity<String> showSeatNotFoundException(ShowSeatNotFoundException ex) {
        return new ResponseEntity<>("Show Seat Not Found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<String> handlePasswordNotMatchException(PasswordNotMatchException ex) {
        return new ResponseEntity<>("Password Not Match: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        return new ResponseEntity<>("Something went wrong: " +ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
