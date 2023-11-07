package nextcore.employees_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import nextcore.employees_manager.DTO.EmployeeDto;
import nextcore.employees_manager.DTO.EmployeesCertificationsDTO;
import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.respository.EmployeeRepository;

public interface EmployeeService {

//	Optional<Employee> findByUserName();
//	
//	Boolean exitsByUserName(String name);
//	
//	Boolean exitsByUserEmail(String email);

	Employee addEmployee(Employee employee);

	Optional<EmployeesDTO> getEmployeeById(Long id);

	Employee updateEmployeeById(@Valid Employee Employee, Long id);

	ResponseEntity<Object> deleteEmployeeById(Long id);

	ResponseEntity<Object> deleteCertificationById(Long id);

	Optional<Employee> findbyEmployeeLoginId(String employeeLoginId);

	List<Employee> getEmployees();

	ResponseEntity<Object> getListEmployee(String employeeName, Long departmentId, String ordEmployeeName,
			String ordCertificationName, String ordEndDate, int offset, int limit);

	EmployeesCertificationsDTO loadEmployeeById(Long employeeId);

}