package exceptions;

public class CornerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CornerException() {
		super("YOU NEED PUT H OR V IF YOU WANT SHOOT FROM A CORNER");
	}
}
