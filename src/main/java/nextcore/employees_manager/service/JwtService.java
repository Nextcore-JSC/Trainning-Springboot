package nextcore.employees_manager.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import nextcore.employees_manager.entity.Employee;
@Service
public class JwtService {
	private static final String SCRET_KEY= "nextcore";
	
	public String generateToken(Employee employee) {
		Algorithm algorithm = Algorithm.HMAC256(SCRET_KEY.getBytes());
		return JWT.create()
				.withSubject(employee.getEmployeeEmail())
				.withExpiresAt(new Date(System.currentTimeMillis() + 50 * 60 * 1000))
				.sign(algorithm);
	}
}
