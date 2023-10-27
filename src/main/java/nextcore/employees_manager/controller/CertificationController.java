package nextcore.employees_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.service.CertificationService;



@RestController
public class CertificationController {
	@Autowired
	private CertificationService cService;
	@GetMapping("/certifications")
	public List<Certification> getListCerttification() {
		return cService.getCertifications();
	}
}
