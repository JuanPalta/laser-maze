package exceptions;

public class BorderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderException() {
		super("YOU ONLY CAN SHOOT FROM A BORDER AND IF YOU NEED SHOOT FROM A CORNER PUT THE CORNER AND H OR V EXAMPLE: 1AH");
	}
}
