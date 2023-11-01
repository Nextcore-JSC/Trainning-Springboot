package nextcore.employees_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Positive;
import nextcore.employees_manager.auth.AuthRequest;
import nextcore.employees_manager.auth.AuthResponse;
import nextcore.employees_manager.service.AuthenticationService;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		System.out.println(authRequest);
		return ResponseEntity.ok(authenticationService.authenticate(authRequest));
	}
}
