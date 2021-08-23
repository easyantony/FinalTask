package by.tc.task01.service;

public class ServiceException extends Exception {
	
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String messege) {
		super(messege);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String messege, Exception e) {
		super(messege, e);
	}

}
