package model;

import java.io.Serializable;

/**
 * 
 * @author JuanP
 * User Class
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname;
	private int score;
	private int row;
	private int column;
	private int mirror;
	private User left;
	private User right;
	private User parent;
	
	/**
	 * constructor of User class
	 * pre:
	 * pos: create a User instance
	 * @param nickname the nickname of the user
	 * @param score the score of the user
	 * @param row the row played by the user
	 * @param column the column played by the user
	 * @param mirror the mirror played by the user
	 */
	public User(String nickname, int score, int row, int column, int mirror) {
		this.setNickname(nickname);
		this.score = score;
		this.row = row;
		this.column = column;
		this.mirror = mirror;
	}
	
	/**
	 * get nickName
	 * pre:
	 * pos: get the nickName of the user
	 * @return String nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * set nickName
	 * pre:
	 * pos: set the nickName of the user
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * get score
	 * pre:
	 * pos: get the score of the user
	 * @return int score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * set score
	 * pre:
	 * pos: set the score
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * get row
	 * pre:
	 * pos: get the row of the user
	 * @return int row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * set row
	 * pre:
	 * pos: set the row of the user
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * get column
	 * pre:
	 * pos: get the column of the user
	 * @return int column
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * set column
	 * pre:
	 * pos: set the column of the user
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	/**
	 * get mirror
	 * pre:
	 * pos: get the mirror
	 * @return int mirror
	 */
	public int getMirror() {
		return mirror;
	}
	
	/**
	 * set the mirror
	 * pre:
	 * pos: set the mirror of the user
	 * @param mirror the quantity of mirror to set
	 */
	public void setMirror(int mirror) {
		this.mirror = mirror;
	}
	
	/**
	 * get leftUser
	 * pre:
	 * pos: get leftUser
	 * @return User left
	 */
	public User getLeft() {
		return left;
	}
	
	/**
	 * set left
	 * pre:
	 * pos: set the leftUser of the list
	 * @param left the leftUser to set
	 */
	public void setLeft(User left) {
		this.left = left;
	}
	
	/**
	 * get right list
	 * pre:
	 * pos: get the right list
	 * @return User right
	 */
	public User getRight() {
		return right;
	}
	
	/**
	 * set right list
	 * pre:
	 * pos: set the right list
	 * @param right the right list
	 */
	public void setRight(User right) {
		this.right = right;
	}
	
	/**
	 * get Parent
	 * pre:
	 * pos: get the parent
	 * @return User parent
	 */
	public User getParent() {
		return parent;
	}
	
	/**
	 * set the parent
	 * pre:
	 * pos: set the parent
	 * @param parent the parent to set
	 */
	public void setParent(User parent) {
		this.parent = parent;
	}
	
	/**
	 * get Data
	 * pre:
	 * pos: return the information of the user
	 * @return String data
	 */
	public String getData() {
		String n = nickname + " " + row + " " + column + " " + mirror + " " + score;
		return n;
	}

}
