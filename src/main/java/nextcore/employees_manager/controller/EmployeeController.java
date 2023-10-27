package nextcore.employees_manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.entity.EmployeesCertifications;
import nextcore.employees_manager.respository.CertificationRepository;
import nextcore.employees_manager.respository.EmployeeRepository;
import nextcore.employees_manager.respository.EmployeesCertificationsRepository;
import nextcore.employees_manager.service.DepartmentService;
import nextcore.employees_manager.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService eService;
	@Autowired
	private DepartmentService dService;
	@Autowired
	private EmployeeRepository eRepository;
	@Autowired
	private CertificationRepository cRepository;

	@GetMapping("/employees")
	public Map<String, Object> getListEmployee(String employeeName, Long departmentId) {
		List<Employee> employees = eService.getAllEployeeByNameOrDeparment(employeeName, departmentId);
		long totalRecord = eRepository.count();
		Map<String, Object> response = new HashMap<>();
		response.put("totalRecord", totalRecord);
		response.put("employees", employees);
		return response;
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployees(@PathVariable Long id) {
		return eService.getEmployeeById(id);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		eService.addEmployee(employee);
		return eService.getEmployeeById(employee.getEmployeeId()); 
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, Long id) {
		return eService.addEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		eService.deleteEmployee(id);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployees(String employeeName, Long departmentId) {
		return eService.getAllEployeeByNameOrDeparment(employeeName, departmentId);
	}

}
