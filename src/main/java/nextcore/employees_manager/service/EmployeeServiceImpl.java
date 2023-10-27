package nextcore.employees_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.exception.ResourceNotFoundException;
import nextcore.employees_manager.respository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee e = eRepository.save(employee);
		return e;

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
	public List<Employee> getAllEployeeByNameOrDeparment(String employeeName, Long departmentId) {
	    if (employeeName == null && departmentId == null) {
	        return eRepository.findAll();
	    } else {
	        return eRepository.findEmployeeByEmployeeNameOrDepartmentId(employeeName, departmentId);
	    }
	}
}

//	@Override
//	public Optional<Employee> findByUserName() {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

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
