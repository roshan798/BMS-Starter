package exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg) {
		super(msg);
		System.out.println("msg : " + msg);
	}
}
