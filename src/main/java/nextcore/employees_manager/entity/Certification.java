package nextcore.employees_manager.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "certifications")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certification_id")
    @NotNull(message ="certification_id should be null")
    private Long certificationId;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }, mappedBy = "certifications")
    @JsonIgnore
    private Set<Employee> employees =new HashSet<>();
    
//	@OneToMany
//	@JoinColumn(name = "certification_id")
//	private Set<EmployeesCertifications> employeesCertifications;
	
    @Column(name = "certification_name")
    @NotNull(message ="certification_name should be null")
    private String certificationName;
    
    @Column(name = "certification_level")
    @NotNull(message ="certification_level should be null")
    private int certificationLevel;

	public Long getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}

	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

//	public Set<EmployeesCertifications> getEmployeesCertifications() {
//		return employeesCertifications;
//	}
//
//	public void setEmployeesCertifications(Set<EmployeesCertifications> employeesCertifications) {
//		this.employeesCertifications = employeesCertifications;
//	}

	public String getCertificationName() {
		return this.certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public int getCertificationLevel() {
		return certificationLevel;
	}

	public void setCertificationLevel(int certificationLevel) {
		this.certificationLevel = certificationLevel;
	}
    
    
}