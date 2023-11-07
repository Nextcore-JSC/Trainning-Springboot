package nextcore.employees_manager.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String, Object> resourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("code", HttpStatus.NOT_FOUND.value());
		errorMap.put("message", new ErrorMessage("ER015", ex.getMessage()));
		return errorMap;
	}
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, Object> globalExceptionHandler(Exception ex) {
      Map<String, Object> errorMap = new HashMap<>();
      errorMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
      errorMap.put("params", new ErrorMessage("ER500", ex.getMessage()));
      return errorMap;
  }
  
  
}