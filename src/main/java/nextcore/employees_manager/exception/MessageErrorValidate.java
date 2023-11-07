package nextcore.employees_manager.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class MessageErrorValidate {
	public ResponseEntity<Object> messageErrorValidate(String code) {

	    Map<String, Object> response = new HashMap<String, Object>();
	    List<String> params = new ArrayList<>();
	    response.put("code", 500);

	    Map<String, Object> message = new HashMap<String, Object>();
	    message.put("code", code);
	    message.put("params",  params);

	    response.put("message", message);
	    return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Object> messageErrorValidate(String code , String param) {

	    Map<String, Object> response = new HashMap<String, Object>();
	    List<String> params = new ArrayList<>();
	    params.add(param);
	    response.put("code", 500);

	    Map<String, Object> message = new HashMap<String, Object>();
	    message.put("code", code);
	    message.put("params",  params);

	    response.put("message", message);
	    return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);

	}
}
