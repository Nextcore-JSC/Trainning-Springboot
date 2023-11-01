package nextcore.employees_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nextcore.employees_manager.DTO.EmployeeDto;
import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.exception.ResourceNotFoundException;
import nextcore.employees_manager.respository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	private PasswordEncoder passwordEncoder;

	@Override
	public Employee addEmployee(Employee employee) {
//		employee.setEmployeeLoginPassword(passwordEncoder.encode(employee.getEmployeeLoginPassword()));
		return eRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optionalEmployee = eRepository.findById(id);
		if (optionalEmployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee with Employee ID: " + id + " does not exist.");
		}
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public void deleteEmployee(Long id) {
		Optional<Employee> optionalEmployee = eRepository.findById(id);
		if (optionalEmployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee with Employee ID: " + id + " does not exist.");
		}
		eRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployeeById(@Valid Employee employee, Long id) {
		Optional<Employee> employeeId = eRepository.findById(id);
		if (!employeeId.isPresent()) {
			throw new ResourceNotFoundException("Employee with Employee ID: " + id + " does not exist.");
		}
		Employee employeeOptinal = employeeId.get();
		if (StringUtils.isNotEmpty(employee.getEmployeeName())) {
			employeeOptinal.setEmployeeName(employee.getEmployeeName());
		}
		if (StringUtils.isNotEmpty(employee.getEmployeeNameKana())) {
			employeeOptinal.setEmployeeNameKana(employee.getEmployeeNameKana());
		}

		return eRepository.save(employee);
	}

	@Override
	public Optional<Employee> findbyEmployeeLoginId(String employeeLoginId) {
		if (employeeLoginId == null) {
			throw new ResourceNotFoundException("Could not find user");
		}
		return eRepository.findByEmployeeLoginId(employeeLoginId);

	}

	@Override
	public List<Employee> getEmployees() {
		return eRepository.findAll();
	}

	@Override
	public List<EmployeesDTO> getListEmployee(String employeeName, Long departmentId) {
		if (employeeName == null && departmentId == null) {
			return eRepository.findAllEmployee();
		} else {
			return eRepository.listAllEmployee(employeeName, departmentId);
		}
	}
}

//	@Override
//	public Boolean exitsByUserName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Boolean exitsByUserEmail(String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
