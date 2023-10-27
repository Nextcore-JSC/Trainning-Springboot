package nextcore.employees_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.exception.ResourceNotFoundException;
import nextcore.employees_manager.respository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository dRepository;
	@Override
	public List<Department> getDepartments() {
		return dRepository.findAll();
	}
	@Override
	public Department getDepartmentbyByid(Long id) {
		Optional<Department> OptionalDepartment = dRepository.findById(id);
		if (OptionalDepartment.isEmpty()) {
			throw new ResourceNotFoundException("Department with department ID: " + id + " does not exist.");
		}
		Department department = OptionalDepartment.get();
		return department;
	}
	
}
