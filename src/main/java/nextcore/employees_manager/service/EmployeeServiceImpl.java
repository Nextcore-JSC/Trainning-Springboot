package nextcore.employees_manager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nextcore.employees_manager.DTO.CertificationDTO;
import nextcore.employees_manager.DTO.EmployeeDto;
import nextcore.employees_manager.DTO.EmployeesCertificationsDTO;
import nextcore.employees_manager.DTO.EmployeesDTO;
import nextcore.employees_manager.entity.Certification;
import nextcore.employees_manager.entity.Department;
import nextcore.employees_manager.entity.Employee;
import nextcore.employees_manager.entity.EmployeesCertifications;
import nextcore.employees_manager.exception.FieldEmptyException;
import nextcore.employees_manager.exception.FieldFormatException;
import nextcore.employees_manager.exception.FieldLengthExceededException;
import nextcore.employees_manager.exception.MessageErrorValidate;
import nextcore.employees_manager.exception.ResourceNotFoundException;
import nextcore.employees_manager.respository.CertificationRepository;
import nextcore.employees_manager.respository.EmployeeRepository;
import nextcore.employees_manager.respository.EmployeesCertificationsRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;
	@Autowired
	private MessageErrorValidate mError;
	@Autowired
	private CertificationRepository cRepository;
	@Autowired
	private EmployeesCertificationsRepository ecRepository;
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public Employee addEmployee(Employee employee) {
		String employeeLoginId = employee.getEmployeeLoginId();
		String employeeName = employee.getEmployeeName();
		String employeeNameKana = employee.getEmployeeNameKana();
		String employeeEmail = employee.getEmployeeEmail();
		String employeeTelephone = employee.getEmployeeTelephone();
		LocalDate employeeBirthdate = employee.getEmployeeBirthDate();
//		employee.setEmployeeLoginPassword(passwordEncoder.encode(employee.getEmployeeLoginPassword()));
		if (employeeLoginId == null || employeeLoginId.isEmpty()) {
			throw new FieldEmptyException("employeeLoginId");
		}
		if (employeeLoginId.length() > 50) {
			throw new FieldLengthExceededException("employeeLoginId");
		}

//        if (!employeeLoginId.matches("[a-zA-Z0-9_]+") || Character.isDigit(employeeLoginId.charAt(0))) {
//            throw new FieldFormatException("employeeLoginId");
//        }

		return eRepository.save(employee);
	}

	@Override
	public Optional<EmployeesDTO> getEmployeeById(Long id) {

		Optional<EmployeesDTO> employeeOptional = eRepository.getEmployeeById(id);
		if (!employeeOptional.isPresent()) {
			throw new ResourceNotFoundException("Nhân viên có ID: " + id + " không tồn tại.");
		}
		return employeeOptional;
	}

	 @Transactional
	    public ResponseEntity<Object> deleteEmployeeById(Long id) {
	        Optional<Employee> employeeOptional = eRepository.findById(id);
	        if (employeeOptional.isPresent()) {
	            Employee employee = employeeOptional.get();

	            List<EmployeesCertifications> employeesCertificationsList = ecRepository.findByEmployeeId(id);
	            
	            for (EmployeesCertifications employeesCertification : employeesCertificationsList) {
	                ecRepository.delete(employeesCertification);
	            }

	            eRepository.delete(employee);
	        } else {
	            throw new ResourceNotFoundException("Employee ID: " + id + " không tồn tại.");
	        }

	        Map<String, Object> map = new HashMap<>();
	        map.put("code", 200);
	        map.put("employeeId", id);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	@Override
	public Employee updateEmployeeById(@Valid Employee employee, Long id) {
		Optional<Employee> employeeId = eRepository.findById(id);
		if (!employeeId.isPresent()) {
			throw new ResourceNotFoundException("Employee with Employee ID: " + id + " does not exist.");
		}
		Employee employeeOptinal = employeeId.get();
		if (StringUtils.isNotEmpty(employee.getEmployeeName())) {
			employeeOptinal.setEmployeeName(employee.getEmployeeName());
		}
		if (StringUtils.isNotEmpty(employee.getEmployeeNameKana())) {
			employeeOptinal.setEmployeeNameKana(employee.getEmployeeNameKana());
		}

		return eRepository.save(employee);
	}

	@Override
	public Optional<Employee> findbyEmployeeLoginId(String employeeLoginId) {
		if (employeeLoginId == null) {
			throw new ResourceNotFoundException("Could not find user");
		}
		return eRepository.findByEmployeeLoginId(employeeLoginId);

	}

	@Override
	public List<Employee> getEmployees() {
		return eRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> getListEmployee(String employeeName, Long departmentId, String ordEmployeeName,
			String ordCertificationName, String ordEndDate, int offset, int limit) {
		if (ordEmployeeName != null) {
			if (!(ordEmployeeName.equalsIgnoreCase("ASC") || ordEmployeeName.equalsIgnoreCase("DESC"))) {
				return mError.messageErrorValidate("ER021", "Lỗi");
			}
		}
		if (ordCertificationName != null) {
			if (!(ordCertificationName.equalsIgnoreCase("ASC") || ordCertificationName.equalsIgnoreCase("DESC"))) {
				return mError.messageErrorValidate("ER021", "Lỗi");
			}
		}
		if (ordEndDate != null) {
			if (!(ordEndDate.equalsIgnoreCase("ASC") || ordEndDate.equalsIgnoreCase("DESC"))) {
				return mError.messageErrorValidate("ER021", "Lỗi");
			}
		}
		if (offset <= 0) {
			return mError.messageErrorValidate("ER018", "Lỗi");
		}
		if (limit < 0) {
			return mError.messageErrorValidate("ER018", "Lỗi");
		}

		List<EmployeesDTO> employee = eRepository.listAllEmployee(employeeName, departmentId, ordEmployeeName,
				ordCertificationName, ordEndDate, offset, limit);

		int count = employee.size();
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("employees", employee);
		map.put("total record", count);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Override
	public EmployeesCertificationsDTO loadEmployeeById(Long employeeId) {
		Employee employee = eRepository.findByEmployeeId(employeeId);
		if (employee == null) {
			throw new ResourceNotFoundException("Không tìm thấy nhân viên với id = " + employeeId);
		}
		Set<Certification> certificationList = employee.getCertifications();
		Set<EmployeesCertifications> employeesCertifications = employee.getEmployeesCertifications();
		List<Object> array = new ArrayList<>();
		for (Certification certification : certificationList) {
			Map<String, Object> list = new HashMap<String, Object>();
			list.put("certificationName", certification.getCertificationName());
			for (EmployeesCertifications employeesCertification : employeesCertifications) {
				list.put("startDate", employeesCertification.getStartDate());
				list.put("endDate", employeesCertification.getEndDate());
				list.put("score", employeesCertification.getScore());
			}
			array.add(list);
		}
		EmployeesCertificationsDTO employeeListDto = new EmployeesCertificationsDTO();
		employeeListDto.setEmployeeId(employeeId);
		employeeListDto.setEmployeeName(employee.getEmployeeName());
		employeeListDto.setEmployeeBirthDate(employee.getEmployeeBirthDate());
		employeeListDto.setDepartmentId(employee.getDepartment().getDepartmentId());
		employeeListDto.setDepartmentName(employee.getDepartment().getDepartmentName());
		employeeListDto.setEmployeeEmail(employee.getEmployeeEmail());
		employeeListDto.setEmployeeTelephone(employee.getEmployeeTelephone());
		employeeListDto.setEmployeeBirthDate(employee.getEmployeeBirthDate());
		employeeListDto.setCertifications(array);

		return employeeListDto;
	}

	@Override
	public ResponseEntity<Object> deleteCertificationById(Long id) {
		try {
			Optional<Certification> certificationOptional = cRepository.findById(id);
			if (!certificationOptional.isPresent()) {
				throw new ResourceNotFoundException("Chứng chỉ có ID: " + id + " không tồn tại.");
			}

			List<EmployeesCertifications> employeesCertificationsList = ecRepository.findByCertificationId(id);
			ecRepository.deleteAll(employeesCertificationsList);

			cRepository.delete(certificationOptional.get());

			Map<String, Object> map = new HashMap<>();
			map.put("code", 200);
			map.put("certificationId", id);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
