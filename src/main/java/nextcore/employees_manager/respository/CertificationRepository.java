package nextcore.employees_manager.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import nextcore.employees_manager.entity.Certification;
@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
	
}
