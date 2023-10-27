package nextcore.employees_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextcore.employees_manager.entity.EmployeesCertifications;
import nextcore.employees_manager.respository.EmployeeRepository;
import nextcore.employees_manager.respository.EmployeesCertificationsRepository;
@Service
public class EmployeesCertificationsServiceImpl implements EmployeesCertificationsService {

	@Autowired
	private EmployeesCertificationsRepository ecRepository;
	
	@Override
	public List<EmployeesCertifications> getAll() {
		return ecRepository.findAll();
	}

}
