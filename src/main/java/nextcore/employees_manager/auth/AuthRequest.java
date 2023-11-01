package nextcore.employees_manager.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	private String employeeLoginId;
	private String employeeLoginPassword;
	public String getEmployeeLoginId() {
		return employeeLoginId;
	}
	public void setEmployeeLoginId(String employeeLoginId) {
		this.employeeLoginId = employeeLoginId;
	}
	public String getEmployeeLoginPassword() {
		return employeeLoginPassword;
	}
	public void setEmployeeLoginPassword(String employeeLoginPassword) {
		this.employeeLoginPassword = employeeLoginPassword;
	}
	@Override
	public String toString() {
		return "AuthRequest [EmployeeLoginId=" + employeeLoginId + ", EmployeeLoginPassword=" + employeeLoginPassword
				+ "]";
	}
	public AuthRequest(String employeeLoginId, String employeeLoginPassword) {
		super();
		this.employeeLoginId = employeeLoginId;
		this.employeeLoginPassword = employeeLoginPassword;
	}
	
	
}
