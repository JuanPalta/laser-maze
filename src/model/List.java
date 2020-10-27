package model;

/**
 * 
 * @author JuanP
 * List Class
 *
 */
public class List {

	private char mirror;
	private char column;
	private int row;
	private String content;
	private boolean found;
	private List prevList;
	private List nextList;
	private List downList;
	private List upList;
	
	/**
	 * Create a List instance
	 * pre:
	 * pos:build a List instance
	 * @param row the row of the list
	 * @param charColumn the column of the list
	 */
	public List(int row, char charColumn) {
		this.column = charColumn;
		this.row = row;
		mirror = ' ';
		setContent("[ ]");
	}
	
	/**
	 * get column
	 * pre:
	 * pos: get the column of the list
	 * @return char Column
	 */
	public char getColumn() {
		return column;
	}
	
	/**
	 * set Column
	 * pre:
	 * pos: set the column of the list
	 * @param column the column to set
	 */
	public void setColumn(char column) {
		this.column = column;
	}
	
	/**
	 * get row
	 * pre:
	 * pos: get the row of the list
	 * @return int row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * set row
	 * pre:
	 * pos: set the row of the list
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * get prevList
	 * pre:
	 * pos: get the previous list
	 * @return List prevList
	 */
	public List getPrevList() {
		return prevList;
	}
	
	/**
	 * set prevList
	 * pre:
	 * pos: set the prevList
	 * @param prevList the previous list
	 */
	public void setPrevList(List prevList) {
		this.prevList = prevList;
	}
	
	/**
	 * get nextList
	 * pre:
	 * pos: get the next list of the list
	 * @return List nextList
	 */
	public List getNextList() {
		return nextList;
	}
	
	/**
	 * set nextList
	 * pre:
	 * pos: set the nextList
	 * @param nextList the nextList to set
	 */
	public void setNextList(List nextList) {
		this.nextList = nextList;
	}
	
	/**
	 * get downList
	 * pre:
	 * pos: get the downList
	 * @return List downList
	 */
	public List getDownList() {
		return downList;
	}
	
	/**
	 * set downList
	 * pre:
	 * pos: set the downList
	 * @param downList the downList to set
	 */
	public void setDownList(List downList) {
		this.downList = downList;
	}
	
	/**
	 * get upList
	 * pre:
	 * pos: get the upList
	 * @return List upList
	 */
	public List getUpList() {
		return upList;
	}
	
	/**
	 * set upList
	 * pre:
	 * pos: set the upList
	 * @param upList the upList to set
	 */
	public void setUpList(List upList) {
		this.upList = upList;
	}
	
	/**
	 * get mirror
	 * pre:
	 * pos: get the mirror of the list
	 * @return char mirror
	 */
	public char getMirror() {
		return mirror;
	}
	
	/**
	 * set mirror
	 * pre:
	 * pos: set the mirror of the list
	 * @param mirror the mirror to set
	 */
	public void setMirror(char mirror) {
		this.mirror = mirror;
	}
	
	/**
	 * get content
	 * pre:
	 * pos: get the content of the list
	 * @return String content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * set content
	 * pre:
	 * pos: set the content of the list
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * get found
	 * pre:
	 * pos: return a boolean that say if the mirror is found or not
	 * @return boolean found
	 */
	public boolean getFound() {
		return found;
	}
	
	/**
	 * set found
	 * pre:
	 * pos: set the found of the list
	 * @param found the found to set
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

}
