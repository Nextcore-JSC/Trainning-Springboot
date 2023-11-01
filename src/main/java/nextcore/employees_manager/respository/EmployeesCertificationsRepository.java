package nextcore.employees_manager.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nextcore.employees_manager.entity.EmployeesCertifications;
@Repository
public interface EmployeesCertificationsRepository extends JpaRepository<EmployeesCertifications, Long >{
	
	
//	 @Query(value = "SELECT * FROM employees_certifications WHERE employee_id = :employeeId", nativeQuery = true)
//	    List<EmployeesCertifications> findByEmployeeId(@Param("employeeId") Long employeeId);
}
