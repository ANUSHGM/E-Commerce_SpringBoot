package ecommerceapp.ExceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ecommerceapp.CustomizedException.AlreadyExistsException;
import ecommerceapp.CustomizedException.ResourceNotFoundException;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({ResourceNotFoundException.class})
	   public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
	   
	   
	   @ExceptionHandler({AlreadyExistsException.class})
	   public ResponseEntity<Object> exception(AlreadyExistsException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.ALREADY_REPORTED);
	   }
}
