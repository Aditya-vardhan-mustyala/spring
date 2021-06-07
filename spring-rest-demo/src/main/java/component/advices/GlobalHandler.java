package component.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import component.entity.CustomErrorResponse;
import component.entity.CustomExceptionStudnotfound;

@ControllerAdvice
public class GlobalHandler 
{
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handler(CustomExceptionStudnotfound ex)
	{
		CustomErrorResponse res= new CustomErrorResponse();
		
		res.setMessage(ex.getMessage());
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<CustomErrorResponse> (res,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handlerall(Exception ex)
	{
		CustomErrorResponse res= new CustomErrorResponse();
		
		res.setMessage(ex.getMessage());
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		res.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<CustomErrorResponse> (res,HttpStatus.BAD_REQUEST);
		
	}


}
