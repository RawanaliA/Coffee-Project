package com.example.week4database.ControllerAdvise;
import com.example.week4database.ApiExeption.ApiExeption;
import com.example.week4database.ApiResponce.ApiResponce;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = ApiExeption.class)
    public ResponseEntity<ApiResponce>ApiExeption(ApiExeption e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponce (message));
    }
//
 @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponce>DataIntegrityViolationException(DataIntegrityViolationException e) {
     String message = e.getMessage();
     return ResponseEntity.status(400).body(new ApiResponce(message));
 }


}
