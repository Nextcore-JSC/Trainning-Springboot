package nextcore.employees_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.Employee;

public interface DepartmentService {
	List<Department> getDepartments();
	Department getDepartmentbyByid(Long id);
}
