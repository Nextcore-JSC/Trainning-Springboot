package nextcore.employees_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nextcore.employees_manager.entity.EmployeesCertifications;

public interface EmployeesCertificationsService {
	List<EmployeesCertifications> getAll();
}
