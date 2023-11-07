package nextcore.employees_manager.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmployeesCertificationsDTO {
	private Long employeeId;
	private String employeeName;
	private String employeeNameKana;
	private LocalDate employeeBirthDate;
	private String employeeEmail;
	private String employeeTelephone;
	private Long departmentId;
	private String departmentName;
	private List<Object> certifications;
	public Long getEmployeeId() {
		return employeeId;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Object> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<Object> certifications) {
		this.certifications = certifications;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public EmployeesCertificationsDTO(Long employeeId, String employeeName, String employeeNameKana, LocalDate employeeBirthDate,
			String employeeEmail, String employeeTelephone, Long departmentId, String departmentName,
			List<Object> certifications) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeNameKana = employeeNameKana;
		this.employeeBirthDate = employeeBirthDate;
		this.employeeEmail = employeeEmail;
		this.employeeTelephone = employeeTelephone;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.certifications = certifications;
	}
	public EmployeesCertificationsDTO() {
		super();
	}
    
}
