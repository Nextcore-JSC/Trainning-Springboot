package nextcore.employees_manager.DTO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.EmployeesCertifications;

public class EmployeeDto {
	private Long employeeId;
	private String employeeName;
	private String employeeNameKana;
	private LocalDate employeeBirthDate;
	private String employeeEmail;
	private String employeeTelephone;
	private String departmentName;
	private List<String> cetificationtName;
	@JsonIgnore
	private Department department;
	@JsonIgnore
	private Set<Certification> certifications;
	private Set<EmployeesCertifications> employeescertifications;
	
	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNameKana() {
		return employeeNameKana;
	}

	public void setEmployeeNameKana(String employeeNameKana) {
		this.employeeNameKana = employeeNameKana;
	}

	public LocalDate getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(LocalDate employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String dep) {
		this.departmentName=dep;
	}
	public Set<Certification> getCertifications() {
		return certifications;
	}
	public List<String> getCertificationName() {
		return cetificationtName;
	}
	public void setCertificationName(List<String> cetificationtName) {
		this.cetificationtName=cetificationtName;
	}

//	public void setCertifications(Set<Certification> certifications) {
//		this.certifications = certifications;
//	}


	public EmployeeDto() {
		super();
	}

	public Set<EmployeesCertifications> getEmployeescertifications() {
		return employeescertifications;
	}

	public void setEmployeescertifications(Set<EmployeesCertifications> employeescertifications) {
		this.employeescertifications = employeescertifications;
	}

	public EmployeeDto(Long employeeId, String employeeName, String employeeNameKana, LocalDate employeeBirthDate,
			String employeeEmail, String employeeTelephone, String departmentName, List<String> cetificationtName,
			Department department, Set<Certification> certifications,
			Set<EmployeesCertifications> employeescertifications) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeNameKana = employeeNameKana;
		this.employeeBirthDate = employeeBirthDate;
		this.employeeEmail = employeeEmail;
		this.employeeTelephone = employeeTelephone;
		this.departmentName = departmentName;
		this.cetificationtName = cetificationtName;
		this.department = department;
		this.certifications = certifications;
		this.employeescertifications = employeescertifications;
	}
}
