package nextcore.employees_manager.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;

	@ManyToOne
	@JoinColumn(name = "department_id")
//	@NotNull(message = "department_id should be null !")
	private Department department;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employees_certifications", joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "employee_id") }, inverseJoinColumns = {
					@JoinColumn(name = "certification_id"  , referencedColumnName = "certification_id") })
//	@JsonManagedReference
	private Set<Certification> certifications;
	
	@OneToMany
	@JoinColumn(name = "employee_id")
    private Set<EmployeesCertifications> employeescertifications;
	
	
	@Column(name = "employee_name")
	@NotNull(message = "employee_name should be null !")
	private String employeeName;

	@Column(name = "employee_name_kana")
	private String employeeNameKana;

	@Column(name = "employee_birth_day")
//	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate employeeBirthDate;

	@Column(name = "employee_email",unique = true)
	@Email(message = "Please enter the valid email password !")
	private String employeeEmail;

	@Column(name = "employee_telephone")
	private String employeeTelephone;

	@Column(name = "employee_login_id")
	private String employeeLoginId;

	@Column(name = "employee_login_password")
	@Size(min=6,max=10)
	@JsonIgnore
	private String employeeLoginPassword;

	public Long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public void setDepartmentId(Long departmentId) {
        if (department == null) {
            department = new Department();
        }
        department.setDepartmentId(departmentId);
    }
	
	public Department getDepartment() {
		return department;
	}
	public Set<EmployeesCertifications> getEmployeesCertifications() {
		return employeescertifications;
	}

	public void setDepartment(Long department) {
		this.department.setDepartmentId(department);
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

	public String getEmployeeLoginId() {
		return employeeLoginId;
	}

	public void setEmployeeLoginId(String employeeLoginId) {
		this.employeeLoginId = employeeLoginId;
	}

	public String getEmployeeLoginPassword() {
		return employeeLoginPassword;
	}

	public void setEmployeeLoginPassword(String employeeLoginPassword) {
		this.employeeLoginPassword = employeeLoginPassword;
	}
	public Employee getDetailEmADD(Employee e) {
		
		
		return e;
	}

}
