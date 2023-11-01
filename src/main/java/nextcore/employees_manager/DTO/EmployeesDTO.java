package nextcore.employees_manager.DTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeesDTO {
	Long getEmployeeId();
	
	String getEmployeeName();

	String getEmployeeNameKana();

	LocalDate getEmployeeBirthDate();

	String getEmployeeEmail();

	String getEmployeeTelephone();

	String getDepartmentName();
	
	List<String> getCertificationName();
}
