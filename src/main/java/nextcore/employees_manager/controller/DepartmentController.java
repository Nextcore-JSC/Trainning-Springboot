package nextcore.employees_manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService dService;
	@ExceptionHandler
	@GetMapping("/department")
	public ResponseEntity<Object> getListEmployee(@RequestParam(name = "employeeName", required = false) String employeeName,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		try {
			List<Department> listCertification = dService.getDepartments();
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
	
	@GetMapping("department/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return dService.getDepartmentbyByid(id);
	}
}