package inventorySystem.exception;

public class StockOutOfBoundException extends Exception{
String message;

	private static final long serialVersionUID = 1L;

	public StockOutOfBoundException(String message) {
		super(message);
		 
	}
	
	

}
