package nextcore.employees_manager.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.respository.EmployeeRepository;

public class CertificationDTO {

	private String certificationName;
	private BigDecimal score;
	private LocalDate endDate;

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public CertificationDTO(String certificationName, BigDecimal score, LocalDate endDate) {
		super();
		this.certificationName = certificationName;
		this.score = score;
		this.endDate = endDate;
	}

	public CertificationDTO() {
		super();
	}

	

}
