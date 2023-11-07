package nextcore.employees_manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

import nextcore.employees_manager.DTO.EmployeeDto;
import nextcore.employees_manager.DTO.EmployeesCertificationsDTO;
import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.exception.ErrorMessage;
import nextcore.employees_manager.exception.FieldFormatException;
import nextcore.employees_manager.exception.MessageErrorValidate;
import nextcore.employees_manager.exception.ResourceNotFoundException;
import nextcore.employees_manager.respository.CertificationRepository;
import nextcore.employees_manager.respository.EmployeeRepository;
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

//	@GetMapping("/employee/")
//	public ResponseEntity<Object> getListEmployeeId(@PathVariable(name = "id") Long id) {
//		EmployeesCertificationsDTO eDto = eService.loadEmployeeById(id);
//		if (eDto == null) {
//			throw new ResourceNotFoundException("Không tìm thấy nhân viên với id = " + id);
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", 200);
//		map.put("employees", eDto);
//		return new ResponseEntity<Object>(map, HttpStatus.OK);
//	}
	@GetMapping("/listemp")
	public ResponseEntity<Object> getListEmployee(
			@RequestParam(name = "employeeName", required = false) String employeeName,
			@RequestParam(name = "departmentId", required = false) Long departmentId,
			@RequestParam(name = "ordEmployeeName", required = false) String ordEmployeeName,
			@RequestParam(name = "ordCertificationName", required = false) String ordCertificationName,
			@RequestParam(name = "ordEndDate", required = false) String ordEndDate,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {
		return eService.getListEmployee(employeeName, departmentId, ordEmployeeName,
				ordCertificationName, ordEndDate, offset, limit);

	}

	private void validateOrderParameter(String ordEmployeeName, String ordCertificationName, String ordEndDate)
			throws FieldFormatException {
		if (ordEmployeeName != null && !ordEmployeeName.equalsIgnoreCase("ASC")
				&& !ordEmployeeName.equalsIgnoreCase("DESC")) {
			throw new FieldFormatException("ER021");
		}

		if (ordCertificationName != null && !ordCertificationName.equalsIgnoreCase("ASC")
				&& !ordCertificationName.equalsIgnoreCase("DESC")) {
			throw new FieldFormatException("ER021");
		}

		if (ordEndDate != null && !ordEndDate.equalsIgnoreCase("ASC") && !ordEndDate.equalsIgnoreCase("DESC")) {
			throw new FieldFormatException("ER021");
		}
	}

	public void validateOffsetParameter(int offset) throws FieldFormatException {
		if (offset <= 0) {
			throw new FieldFormatException( "ER018");
		}
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Object> getListEmployeeId(@PathVariable(name = "id") Long id) {
		EmployeesCertificationsDTO eDto = eService.loadEmployeeById(id);
		if (eDto == null) {
			throw new ResourceNotFoundException("Không tìm thấy nhân viên với id = " + id);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("employees", eDto);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return eService.addEmployee(employee);

	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, Long id) {
		return eService.addEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		eService.deleteEmployeeById(id);
	}

}
