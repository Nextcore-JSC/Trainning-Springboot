package nextcore.employees_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import nextcore.employees_manager.DTO.EmployeeDto;
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

	Employee getEmployeeById(Long id);

	Employee updateEmployeeById(@Valid Employee Employee, Long id);

	void deleteEmployee(Long id);

	Optional<Employee> findbyEmployeeLoginId(String employeeLoginId);
	
	List<Employee> getEmployees();
	
	List<EmployeesDTO> getListEmployee(String employeeName, Long departmentId);
	
	

}
