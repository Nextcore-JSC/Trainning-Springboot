package nextcore.employees_manager.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nextcore.employees_manager.DTO.EmployeeDto;
import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	long count();

	Optional<Employee> findByEmployeeLoginId(String employeeLoginId);

	@Query("SELECT e.employeeId AS employeeId, e.employeeName AS employeeName, e.employeeNameKana AS employeeNameKana, e.employeeBirthDate AS employeeBirthDate,\r\n"
			+ "e.employeeEmail AS employeeEmail, e.employeeTelephone AS employeeTelephone, d.departmentName AS departmentName\r\n"
			+ "FROM Employee e\r\n" + "INNER JOIN e.department d")
	List<EmployeesDTO> findAllEmployee();

	@Query("SELECT e.employeeId AS employeeId, e.employeeName AS employeeName, e.employeeNameKana AS employeeNameKana, e.employeeBirthDate AS employeeBirthDate,\r\n"
			+ "e.employeeEmail AS employeeEmail, e.employeeTelephone AS employeeTelephone, d.departmentName AS departmentName\r\n"
			+ "FROM Employee e\r\n" + "INNER JOIN e.department d\r\n"
			+ "WHERE e.employeeName LIKE %:employeeName% OR e.department.departmentId = :departmentId")
	List<EmployeesDTO> listAllEmployee(@Param("employeeName") String employeeName,
			@Param("departmentId") Long departmentId);

	@Query("SELECT e.employeeId AS employeeId, e.employeeName AS employeeName, e.employeeNameKana AS employeeNameKana, e.employeeBirthDate AS employeeBirthDate, "
			+ "e.employeeEmail AS employeeEmail, e.employeeTelephone AS employeeTelephone, d.departmentName AS departmentName, c.certificationName AS certificationName "
			+ "FROM Employee e " + "INNER JOIN e.department d "
			+ "LEFT JOIN e.employeescertifications ec ON e.employeeId = ec.employeeId "
			+ "LEFT JOIN ec.certification c ON ec.certificationId = c.certificationId "
			+ "WHERE e.employeeName LIKE %:employeeName% OR d.departmentId = :departmentId")
	List<EmployeesDTO> Test(@Param("employeeName") String employeeName, @Param("departmentId") Long departmentId);

}
