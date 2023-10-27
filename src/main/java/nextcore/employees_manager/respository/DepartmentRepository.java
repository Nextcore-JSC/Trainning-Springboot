package nextcore.employees_manager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nextcore.employees_manager.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}