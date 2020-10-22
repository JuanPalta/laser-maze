package ui;
import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	
	static BufferedReader br;
	static final int PLAY = 1;
	static final int SHOW_POSITIONS = 2;
	static final int EXIT = 3;
	static int countRows = 1;
	static final String principalMenu = "WELCOME TO THE LASER-MAZE GAME \n1:PLAY \n2:TABLE OF POSITIONS \n3:EXIT";
	ListManagement square = new ListManagement();
	ListManagement temporal = square;
	
	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(principalMenu);
		play();
		//System.out.println(square.getFirstList().getNextList().getNextList().getRow());
		
	}
	
	public void play() throws IOException {
		System.out.println("INSERT NICKNAME|ROW|COLUMNS|NUMBER OF MIRROR");
		String[] data = br.readLine().split(" ");
		int iteration = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
		if(Integer.parseInt(data[2])<26 && Integer.parseInt(data[3])<=iteration) {	
		createList(Integer.parseInt(data[1]),Integer.parseInt(data[2]), Integer.parseInt(data[3]),countRows);
		}
		
	}
	
	public void linkWithOtherList(List list , List otherList) {
			
		if(list != null && otherList != null) {
			list.setDownList(otherList);
			otherList.setUpList(list);
			linkWithOtherList(list.getNextList(),otherList.getNextList());
		}
		
	}
	
	public void createList(int row, int column, int mirrors,int countRows) {
		if(countRows == 1) {
			square.add(countRows, column, mirrors);
			createList(row,column,mirrors,countRows+1);
		}
		else if(countRows<= row && countRows > 1) {
			ListManagement temp = new ListManagement();
			temp.add(countRows,column,mirrors);
			linkWithOtherList(temporal.getFirstList(),temp.getFirstList());
			temporal = temp;
			createList(row,column,mirrors,countRows+1);
		}
	}

}
