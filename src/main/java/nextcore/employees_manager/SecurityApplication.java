package nextcore.employees_manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.service.EmployeeService;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class SecurityApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SecurityApplication.class, args);
	}

//	@Bean
//	BCryptPasswordEncoder brCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	CommandLineRunner run (EmployeeService eService) {
//		return args ->{
////			eService.addEmployee(new Employee(null,));
////			eService.addEmployee(new Employee());
//		}
//	}

}
