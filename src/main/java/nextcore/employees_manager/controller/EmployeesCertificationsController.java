package nextcore.employees_manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.entity.EmployeesCertifications;
import nextcore.employees_manager.respository.CertificationRepository;
import nextcore.employees_manager.respository.EmployeeRepository;
import nextcore.employees_manager.respository.EmployeesCertificationsRepository;
import nextcore.employees_manager.service.DepartmentService;
import nextcore.employees_manager.service.EmployeeService;
import nextcore.employees_manager.service.EmployeesCertificationsService;

@RestController
public class EmployeesCertificationsController {
	
	@Autowired
	private EmployeesCertificationsService ecService;
	@GetMapping("/employees_certifications")
	public List<EmployeesCertifications> getListDepartment() {
		return ecService.getAll();
	}
}
