package model;

import exceptions.BorderException;
import exceptions.CornerException;

/**
 * 
 * @author JuanP
 * ListManagement Class
 *
 */
public class ListManagement {

	private List firstList;
	private List endFirstList;
	private List lastList;
	private List endLastList;
	private char charColumn;
	private int longitud;

	/**
	 * Constructor of ListManagement class
	 * pre:
	 * pos: build a ListManagement instance
	 * @param row the row number 1
	 */
	public ListManagement(int row) {
		List list = new List(row, 'A');
		firstList = list;
		endFirstList = list;
		lastList = list;
		endLastList = list;
		charColumn = 'B';
		longitud = 1;
	}

	/**
	 * get the firstList
	 * pre:
	 * pos: get the firstList
	 * @return List firstList
	 */
	public List getFirstList() {
		return firstList;
	}
	
	/**
	 * set the firstList
	 * pre:
	 * pos: set a firstList
	 * @param firstList the firstList of the List
	 */
	public void setFirstList(List firstList) {
		this.firstList = firstList;
	}
	
	/**
	 * get EndLastList
	 * pre:
	 * pos: get EndLastList
	 * @return List endLastList
	 */
	public List getEndLastList() {
		return endLastList;
	}
	
	/**
	 * get LastList
	 * pre:
	 * pos: get LastList
	 * @return List lastList
	 */
	public List getLastList() {
		return lastList;
	}
	
	/**
	 * get EndFirstList
	 * pre:
	 * pos: get end firstList
	 * @return List endFirstList
	 */
	public List getEndFirstList() {
		return endFirstList;
	}
	
	/**
	 * get longitud
	 * pre:
	 * pos: get longitud
	 * @return int longitud
	 */
	public int getLongitud() {
		return longitud;
	}
	
	/**
	 * set Longitud
	 * pre:
	 * pos: set longitud
	 * @param longitud the longitud of list
	 */
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	/**
	 * set LastList
	 * pre:
	 * pos: set the lastlist
	 * @param lastList the LastList of the list
	 */
	public void setLastList(List lastList) {
		this.lastList = lastList;
	}
	
	/**
	 * setEndlastList
	 * pre:
	 * pos: set EndLastList
	 * @param endLastList the EndLastList of the list
	 */
	public void setEndLastList(List endLastList) {
		this.endLastList = endLastList;
	}
	
	/**
	 * Add list
	 * pre:
	 * pos:Add a new list in the list
	 * @param row the rows to add
	 * @param column the columns to add
	 */
	public void add(int row, int column) {
		List l = new List(row, charColumn);
		if (column > 1) {
			endFirstList.setNextList(l);
			l.setPrevList(endFirstList);
			endFirstList = l;
			longitud++;
			charColumn++;
			add(row, (column - 1));
		}
	}
	
	/**
	 * Search list
	 * pre:
	 * pos: return the searched List
	 * @param row the row of the list to search
	 * @param column the column of the list to search
	 * @param temp the initial list
	 * @return List temp
	 */
	public List search(int row, int column, List temp) {

		if (row > 1) {
			temp = temp.getDownList();
			return search(row - 1, column, temp);
		} else if (column > 1) {
			temp = temp.getNextList();
			return search(row, column - 1, temp);
		}
		return temp;

	}
	
	/**
	 * goUp
	 * pre:
	 * pos:scrolls up the list
	 * @param temp the initial list
	 * @return List temp
	 */
	private List goUp(List temp) {
		if (temp.getMirror() == ' ' && temp.getUpList() != null) {
			temp = temp.getUpList();
			return goUp(temp);
		} else {
			if (temp.getMirror() == 47 && temp.getNextList() != null) {
				return goRight(temp.getNextList());
			} else if (temp.getMirror() == 92 & temp.getPrevList() != null) {
				return goLeft(temp.getPrevList());
			}
			return temp;
		}

	}
	
	/**
	 * goDown
	 * pre:
	 * pos: scrolls down the list
	 * @param temp the initial list
	 * @return List temp
	 */
	private List goDown(List temp) {
		if (temp.getMirror() == ' ' && temp.getDownList() != null) {
			temp = temp.getDownList();
			return goDown(temp);
		}

		else {
			if (temp.getMirror() == 47 && temp.getPrevList() != null) {
				return goLeft(temp.getPrevList());
			} else if (temp.getMirror() == 92 && temp.getNextList() != null) {
				return goRight(temp.getNextList());
			}
			return temp;
		}

	}
	
	/**
	 * goRight
	 * pre:
	 * pos: scrolls Right the list
	 * @param temp the initial list
	 * @return List temp
	 */
	private List goRight(List temp) {

		if (temp.getMirror() == ' ' && temp.getNextList() != null) {
			temp = temp.getNextList();
			return goRight(temp);
		} else {
			if (temp.getMirror() == 47 && temp.getUpList() != null) {

				return goUp(temp.getUpList());
			} else if (temp.getMirror() == 92 && temp.getDownList() != null) {
				return goDown(temp.getDownList());
			}
			return temp;
		}

	}
	
	/**
	 * goLeft
	 * pre:
	 * pos: scrolls left the list
	 * @param temp the initial list
	 * @return temp
	 */
	private List goLeft(List temp) {
		if (temp.getMirror() == ' ' && temp.getPrevList() != null) {
			temp = temp.getPrevList();
			return goLeft(temp);
		}

		else {
			if (temp.getMirror() == 47 && temp.getDownList() != null) {

				return goDown(temp.getDownList());
			} else if (temp.getMirror() == 92 && temp.getUpList() != null) {
				return goUp(temp.getUpList());
			}
			return temp;
		}

	}
	
	/**
	 * shootLaser
	 * pre:
	 * pos:the shoot scrolls through the list depending on the mirrors.
	 * @param start the list to start
	 * @return List start
	 * @throws BorderException you need shoot from a border
	 * @throws CornerException you need declarate the orientation
	 */
	public List shootLaser(List start) throws BorderException, CornerException {

		if (start != firstList && start != endFirstList && start != lastList && start != endLastList) {

			if (start.getColumn() == 'A') {
				start = goRight(start);
			} else if (start.getRow() == 1) {
				start = goDown(start);
			} else if (start.getRow() == endLastList.getRow()) {
				start = goUp(start);
			}

			else if (start.getColumn() == endFirstList.getColumn()) {
				start = goLeft(start);
			} else {
				throw new BorderException();
			}
		} else {
			throw new CornerException();
		}
		return start;
	}
	
	/**
	 * shootLaserCorner
	 * pre:
	 * pos: the shoot scrolls through the list depending on the mirrors.
	 * @param start the list to start
	 * @param direction the directon you want shoot
	 * @return List start
	 * @throws CornerException you need declarate a correct orientation
	 */
	public List shootLaserCorner(List start, char direction) throws CornerException {
		if (direction == 'H') {
			if (start == firstList || start == lastList) {
				start = goRight(start);
			} else if (start == endLastList || start == endFirstList) {
				start = goLeft(start);
			}
		} else if (direction == 'V') {
			if (start == firstList || start == endFirstList) {
				start = goDown(start);
			} else if (start == lastList || start == endLastList) {
				start = goUp(start);
			}
		} else {
			throw new CornerException();
		}
		return start;
	}
	
	/**
	 * showColumns
	 * pre:
	 * pos: show the columns of the list
	 * @param column the columns to show
	 * @param temp the list to show the columns
	 */
	private void showColumns(int column, List temp) {
		if (column >= 1) {
			System.out.print(temp.getContent());
			if (temp.getNextList() != null) {
				temp = temp.getNextList();
				showColumns(column--, temp);
			}
		}
	}
	
	/**
	 * showContent
	 * pre:
	 * pos: show the content of the list in console
	 * @param row the rows to show
	 * @param column the columns to show
	 * @param temp the list
	 */
	public void showContent(int row, int column, List temp) {
		if (row >= 1) {
			showColumns(column, temp);
			System.out.println();
			if (temp.getDownList() != null) {
				temp = temp.getDownList();
				showContent(row--, column, temp);
			}
		}
	}

}
