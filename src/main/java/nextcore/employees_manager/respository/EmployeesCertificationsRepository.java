package nextcore.employees_manager.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nextcore.employees_manager.entity.EmployeesCertifications;

@Repository
public interface EmployeesCertificationsRepository extends JpaRepository<EmployeesCertifications, Long> {

	@Query("SELECT ec FROM EmployeesCertifications ec WHERE ec.certification.id = :certificationId")
	List<EmployeesCertifications> findByCertificationId(@Param("certificationId") Long certificationId);
	@Modifying
    @Query("DELETE FROM EmployeesCertifications ec WHERE ec.employee.id = :employeeId")
    void deleteByEmployeeId(@Param("employeeId") Long employeeId);
	
	 @Query("DELETE FROM EmployeesCertifications ec WHERE ec.employee.id = :employeeId")
	    void deleteAllByEmployeeId(@Param("employeeId") Long employeeId);
	 
	 List<EmployeesCertifications> findByEmployeeId(Long employeeId);
}
