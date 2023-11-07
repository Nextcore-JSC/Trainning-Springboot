package nextcore.employees_manager.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface EmployeesDTO {
	Long getEmployeeId();
	
	String getEmployeeName();

	String getEmployeeNameKana();

	LocalDate getEmployeeBirthDate();

	String getEmployeeEmail();

	String getEmployeeTelephone();

	String getDepartmentName();
	
//	List<CertificationDTO> certifications;
	
	String getCertificationName();
	
	LocalDate getEndDate();
	
	BigDecimal getScore();
	
	
}
