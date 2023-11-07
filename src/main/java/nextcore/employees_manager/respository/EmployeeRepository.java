package nextcore.employees_manager.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	long count();

	Optional<Employee> findByEmployeeLoginId(String employeeLoginId);

	@Query("SELECT e.employeeId AS employeeId, e.employeeName AS employeeName, e.employeeNameKana AS employeeNameKana, e.employeeBirthDate AS employeeBirthDate, "
			+ "e.employeeEmail AS employeeEmail, e.employeeTelephone AS employeeTelephone, d.departmentName AS departmentName, c.certificationName AS certificationName, "
			+ "ec.endDate AS endDate, ec.score AS score " + "FROM Employee e " + "INNER JOIN e.department d "
			+ "LEFT JOIN e.employeescertifications ec ON e.employeeId = ec.employee.employeeId "
			+ "LEFT JOIN ec.certification c ON ec.certification.certificationId = c.certificationId "
			+ "WHERE e.employeeId = :id")
	Optional<EmployeesDTO> getEmployeeById(@Param("id") Long id);

	@Query("SELECT e.employeeId AS employeeId, e.employeeName AS employeeName, e.employeeNameKana AS employeeNameKana, e.employeeBirthDate AS employeeBirthDate, "
	        + "e.employeeEmail AS employeeEmail, e.employeeTelephone AS employeeTelephone, d.departmentName AS departmentName, c.certificationName AS certificationName, "
	        + "ec.endDate AS endDate, ec.score AS score "
	        + "FROM Employee e "
	        + "INNER JOIN e.department d "
	        + "LEFT JOIN e.employeescertifications ec ON e.employeeId = ec.employee.employeeId "
	        + "LEFT JOIN ec.certification c ON ec.certification.certificationId = c.certificationId "
	        + "WHERE (:employeeName is null or e.employeeName like %:employeeName%) "+
	        "AND (:departmentId is null or e.department.departmentId = :departmentId) "
	        + "ORDER BY " 
	        + "    CASE " 
	        + "    WHEN :ordEmployeeName = 'ASC' THEN e.employeeName " 
	        + "    ELSE null " 
	        + "    END ASC, " 
	        + "    CASE " 
	        + "    WHEN :ordEmployeeName = 'DESC' THEN e.employeeName " 
	        + "    ELSE null " 
	        + "    END DESC,"
	        + "CASE "
	        + "    WHEN :ordCertificationName = 'ASC' THEN c.certificationName"
	        + "    ELSE null"
	        + "    END ASC,"
	        + "    CASE"
	        + "    WHEN :ordCertificationName = 'DESC' THEN c.certificationName"
	        + "    ELSE null"
	        + "    END DESC,"
	        + "CASE "
	        + "    WHEN :ordEndDate = 'ASC' THEN ec.endDate"
	        + "    ELSE null"
	        + "    END ASC,"
	        + "    CASE"
	        + "    WHEN :ordEndDate = 'DESC' THEN ec.endDate"
	        + "    ELSE null"
	        + "    END DESC"
	        +" LIMIT :limit OFFSET :offset"
			)
	List<EmployeesDTO> listAllEmployee(@Param("employeeName") String employeeName,
	        @Param("departmentId") Long departmentId, 
	        @RequestParam(name = "ordEmployeeName", required = false) String ordEmployeeName,
	        @RequestParam(name = "ordCertificationName", required = false) String ordCertificationName,
	        @RequestParam(name = "ordEndDate", required = false) String ordEndDate,
	        @RequestParam(name = "offset") int offset,
	        @RequestParam(name = "limit") int limit
	        );
	@Query("SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
	Employee findByEmployeeId(@Param("employeeId") Long employeeId);

//
	List<Employee> findAllByEmployeeNameContaining(String employeeName);
}
