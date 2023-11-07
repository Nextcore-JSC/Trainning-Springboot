package nextcore.employees_manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.service.CertificationService;



@RestController
public class CertificationController {
	@Autowired
	private CertificationService cService;
//	@GetMapping("/certifications")
//	public List<Certification> getListCerttification() {
//		return cService.getCertifications();
//	}
	
	@GetMapping("/certifications")
	public ResponseEntity<Object> getListEmployee(@RequestParam(name = "employeeName", required = false) String employeeName,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		try {
			List<Certification> listCertification = cService.getCertifications();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 200);
			map.put("certifications", listCertification);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorMap = new HashMap<String, Object>();
			errorMap.put("code", "er023");
			errorMap.put("params", new ArrayList<>());
			return new ResponseEntity<Object>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
