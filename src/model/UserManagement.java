package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 
 * @author JuanP
 * UserManagement Class
 *
 */
public class UserManagement {
	private User root;
	private int positions;
	public static final String POSITIONS_PATH = "data/ranking.jmpc";
	
	/**
	 * the constructor of UserManagement Class
	 * pre:
	 * pos: create a BST of user
	 * @throws FileNotFoundException file not found
	 * @throws IOException an ioexception
	 * @throws ClassNotFoundException the classNotFound
	 */
	public UserManagement() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(POSITIONS_PATH);
		if (f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			root = (User) ois.readObject();
			positions = 0;
			ois.close();
		} else {
			root = null;
			positions = 0;
		}
	}
	
	/**
	 * add user
	 * pre:
	 * pos: add a user into the bst
	 * @param u the user to add
	 * @throws FileNotFoundException the file dont found
	 * @throws IOException an ioexception
	 */
	public void addUser(User u) throws FileNotFoundException, IOException {
		if (root == null) {
			root = u;
			saveRoot();
		} else {
			addUser(root, u);
		}
	}
	
	/**
	 * add user
	 * pre:
	 * pos: add user to the bst
	 * @param current the current bst user
	 * @param u the user to add
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void addUser(User current, User u) throws FileNotFoundException, IOException {
		if (current.getScore() >= u.getScore()) {
			if (current.getLeft() == null) {
				current.setLeft(u);
				u.setParent(current);
				saveRoot();
			} else {
				addUser(current.getLeft(), u);
			}
		} else {
			if (current.getRight() == null) {
				current.setRight(u);
				u.setParent(current);
				saveRoot();
			} else {
				addUser(current.getRight(), u);
			}
		}
	}
	
	/**
	 * walk bst in order
	 * pre:
	 * pos: walk bst in order and show the bst in console
	 * @param x the root of the bst
	 */
	public void inOrder(User x) {
		if (x != null) {
			inOrder(x.getRight());
			positions++;
			System.out.println(positions + "." + x.getData());
			inOrder(x.getLeft());
		}

	}
	
	/**
	 * get root
	 * pre:
	 * pos: get the root of the bst
	 * @return User root
	 */
	public User getRoot() {
		return root;
	}
	
	/**
	 * restartPositions
	 * pre:
	 * pos: put the positions in 0
	 */
	public void restartPositions() {
		positions = 0;
	}
	
	/**
	 * saveRoot
	 * pre:
	 * pos: save the bst
	 * @throws FileNotFoundException the file not found
	 * @throws IOException an ioexception
	 */
	private void saveRoot() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(POSITIONS_PATH));
		oos.writeObject(root);
		oos.close();
	}
}
