package exceptions;

public class NoRequerimentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoRequerimentsException() {
		super("YOU ENTER A INVALID QUANTITY OF MIRRORS OF COLUMNS");
	}

}
