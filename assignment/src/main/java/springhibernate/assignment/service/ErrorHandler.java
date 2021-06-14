package springhibernate.assignment.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springhibernate.assignment.entities.ErrorResponse;

@ControllerAdvice
public class ErrorHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> globalhandler(Exception ex)
    {
        ErrorResponse entity=new ErrorResponse();
        entity.setMessage(ex.getMessage());
        entity.setStatus(HttpStatus.BAD_REQUEST.value());
        entity.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(entity,HttpStatus.BAD_REQUEST);

    }
}
