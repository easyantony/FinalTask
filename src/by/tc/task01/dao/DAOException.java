package by.tc.task01.dao;

public class DAOException extends Exception{
	
	public DAOException() {
		super();
	}
	
	
	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
	
	
	public DAOException(Exception e) {
		super(e);
	}
}
