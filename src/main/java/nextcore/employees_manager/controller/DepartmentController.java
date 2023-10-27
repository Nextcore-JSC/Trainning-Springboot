package nextcore.employees_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService dService;
	@GetMapping("/department")
	public List<Department> getListDepartment() {
		return dService.getDepartments();
	}
	
	@GetMapping("department/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return dService.getDepartmentbyByid(id);
	}
}