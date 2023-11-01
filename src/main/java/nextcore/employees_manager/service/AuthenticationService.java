package nextcore.employees_manager.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import nextcore.employees_manager.auth.AuthRequest;
import nextcore.employees_manager.auth.AuthResponse;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.respository.EmployeeRepository;

@Service
public class AuthenticationService {
	@Autowired
	private EmployeeRepository eRepository;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtService jwtService;

	public AuthResponse authenticate(AuthRequest authRequest) {
	    try {
	        Employee employee = eRepository.findByEmployeeLoginId(authRequest.getEmployeeLoginId())
	                .orElseThrow(() -> new RuntimeException("Notfound"));

	        if (employee.getEmployeeLoginPassword().equals(authRequest.getEmployeeLoginPassword())) {
	            String jwtToken = jwtService.generateToken(employee);
	            AuthResponse authResponse = new AuthResponse();
	            authResponse.setToken(jwtToken);
	            return authResponse;
	        } else {
	            throw new RuntimeException("Tài khoản hoặc mật khẩu không chính xác");
	        }
	    } catch (org.springframework.security.core.AuthenticationException e) {
	        throw new RuntimeException("Xác thực thất bại: " + e.getMessage());
	    }
	}
}
