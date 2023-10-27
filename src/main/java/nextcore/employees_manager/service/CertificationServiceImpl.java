package nextcore.employees_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.respository.CertificationRepository;
import nextcore.employees_manager.respository.DepartmentRepository;
@Service
public class CertificationServiceImpl  implements CertificationService{
	@Autowired
	private CertificationRepository cRepository;

	@Override
	public List<Certification> getCertifications() {
		return cRepository.findAll();
	}

}
