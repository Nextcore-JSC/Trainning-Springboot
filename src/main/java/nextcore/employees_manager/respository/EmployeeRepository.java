package nextcore.employees_manager.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nextcore.employees_manager.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	long count();
	
	@Query("SELECT e FROM Employee e JOIN e.department d WHERE e.employeeName LIKE %:employeeName% OR d.departmentId = :departmentId")
	List<Employee> findEmployeeByEmployeeNameOrDepartmentId(@Param("employeeName") String employeeName,
			@Param("departmentId") Long departmentId);
//	
//	@Query("SELECT e FROM Employee e JOIN e.department d JOIN e.employeesCertifications ec JOIN ec.certification c WHERE e.employeeName = :employeeName OR d.departmentId = :departmentId")
//    List<Employee> findEmployeeByEmployeeNameOrDepartmentIds(@Param("employeeName") String employeeName, @Param("departmentId") Long departmentId);
	
//	@Query("SELECT e FROM Employee e JOIN e.department d JOIN e.employeesCertifications ec JOIN ec.certification c WHERE e.employeeId = :employeeId")
//    List<Employee> findEmployeeByEmployeeNameOrDepartmentIds(@Param("employeeName") String employeeName, @Param("departmentId") Long departmentId);
	
}
