package model;

public class UserManagement {
	private User root;
	private int positions;
	public UserManagement() {
		root = null;
		positions = 0;
	}
	
	public void addUser(User u) {
		if(root ==null) {
			root = u;
		}
		else {
			addUser(root,u);
		}
	}
	
	private void addUser(User current, User u) {
	   if(current.getScore()> u.getScore()) {
		   if(current.getLeft() == null) {
			 current.setLeft(u);
			 u.setParent(current);
		   }
		   else {
			 addUser(current.getLeft(),u);  
		   }
	   }
	   else {
		   if(current.getRight() == null) {
				 current.setRight(u);
				 u.setParent(current);
			   }
			   else {
				 addUser(current.getRight(),u);
			   }
	   }
	}
	
	public void inOrder(User x) {
		if(x != null) {
			  inOrder(x.getLeft());
			  positions++;
			  System.out.println(positions + "." + x.getData());
			  inOrder(x.getRight());
		}
		
	}
	
	public User getRoot() {
		return root;
	}
	
	public void restartLongitud() {
		positions = 0;
	}
}
