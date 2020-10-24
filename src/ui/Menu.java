package ui;
import model.*;
import java.util.Random;
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
	ListManagement square = new ListManagement(1);
	ListManagement temporal = square;
	
	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(principalMenu);
		play();
	}
	
	private void play() throws IOException {
		System.out.println("INSERT NICKNAME|ROW|COLUMNS|NUMBER OF MIRROR");
		String[] data = br.readLine().split(" ");
		int iteration = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
		if(Integer.parseInt(data[2])<=26 && Integer.parseInt(data[3])<=iteration) {	
		createList(Integer.parseInt(data[1]),Integer.parseInt(data[2]),countRows);
		putMirrors(Integer.parseInt(data[3]));
		square.showContent(Integer.parseInt(data[1]),Integer.parseInt(data[2]),square.getFirstList());
		
		}
		
	}
	
	private void linkWithOtherList(List list , List otherList) {
			
		if(list != null && otherList != null) {
			list.setDownList(otherList);
			otherList.setUpList(list);
			linkWithOtherList(list.getNextList(),otherList.getNextList());
		}
		
	}
	
	private void createList(int row, int column,int countRows) {
		if(countRows == 1) {
			square.add(countRows, column);
			createList(row,column,countRows+1);
		}
		else if(countRows<= row && countRows > 1) {
			ListManagement temp = new ListManagement(countRows);
			temp.add(countRows,column);
			linkWithOtherList(temporal.getFirstList(),temp.getFirstList());
			temporal = temp;
			square.setLastList(temp.getFirstList());
			square.setEndLastList(temp.getEndFirstList());
			createList(row,column,countRows+1);
		}
	}
	
	private void putMirrors(int mirrors) {
			Random r = new Random();
			char rc = (char) (r.nextInt(square.getEndFirstList().getColumn()-('A'-1)) + 'A');
			int rr = 1 + r.nextInt(square.getLastList().getRow());
			int rs = 1 + r.nextInt(2);
			char slash = ' ';
			int countColumn = (rc - 'A' + 1);
			List searched = square.search(rr, countColumn,square.getFirstList());
			if (mirrors>=1 && searched.getMirror() == ' '){
				if(rs == 1) {
					slash = 47; 
				 }
				 else{
				    slash = 92;
				 }
				 searched.setMirror(slash);
				 putMirrors(mirrors-1);	
			}
			else if(searched.getMirror() != ' ' && mirrors>=1){
				putMirrors(mirrors);
			}
			}

}

