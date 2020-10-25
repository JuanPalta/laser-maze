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
	static int countMirrors;
	private User user;
	static final String principalMenu = "WELCOME TO THE LASER-MAZE GAME \n1:PLAY \n2:TABLE OF POSITIONS \n3:EXIT";
	ListManagement square = new ListManagement(1);
	ListManagement temporal = square;
	
	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(principalMenu);
		creationTable();
		playOption(countMirrors);
	}
	
	private void creationTable() throws IOException {
		System.out.println("INSERT NICKNAME|ROW|COLUMNS|NUMBER OF MIRROR");
		String[] data = br.readLine().split(" ");
		int iteration = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
		if(Integer.parseInt(data[2])<=26 && Integer.parseInt(data[3])<=iteration) {	
		createList(Integer.parseInt(data[1]),Integer.parseInt(data[2]),countRows);
		putMirrors(Integer.parseInt(data[3]));
		countMirrors = Integer.parseInt(data[3]);
		user = new User(data[0]);
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
	
	private void showStartAndEnd(List s,List e) throws IOException {
		System.out.println();
		s.setContent("[S]");
		e.setContent("[E]");
		System.out.println(user.getNickname() + ":" + " " + countMirrors + " mirrors remaining");
		square.showContent(square.getFirstList().getRow(), square.getEndLastList().getColumn() - 'A' + 1, square.getFirstList());
		if(s.getFound() == false) {
			s.setContent("[ ]");	
		}
		if(e.getFound() == false) {
			e.setContent("[ ]");
		}
		if(s.getFound() == true) {
			s.setContent("[" + s.getMirror() + "]");
		}
		if(e.getFound() == true) {
			e.setContent("[" + e.getMirror() + "]");
		}
		playOption(countMirrors);
	}
	
	private void locate(List s,char mirror) throws IOException {
		System.out.println();
		if(s.getMirror() == mirror && s.getFound() == false) {
			s.setFound(true);
			s.setContent("[" + mirror + "]");
			countMirrors = countMirrors-1;
			System.out.println(user.getNickname() + ":" + " " + countMirrors + " mirrors remaining");
			square.showContent(square.getFirstList().getRow(), square.getEndLastList().getColumn() - 'A' + 1, square.getFirstList());
			playOption(countMirrors);
		}else if(s.getFound() == false){
			s.setContent("[X]");
			square.showContent(square.getFirstList().getRow(), square.getEndLastList().getColumn() - 'A' + 1, square.getFirstList());
			s.setContent("[ ]");
			System.out.println();
			System.out.println(user.getNickname() + ":" + " " + countMirrors + " mirrors remaining");
			square.showContent(square.getFirstList().getRow(), square.getEndLastList().getColumn() - 'A' + 1, square.getFirstList());
			playOption(countMirrors);
		}
	}
	
	private void play(String command) throws IOException {
		int row;
		char column;
		List start;
		List end;
		if(command.length() == 2) {
			row = Character.getNumericValue(command.charAt(0));
			column = command.charAt(1);
			start = square.search(row, (column - 'A' + 1),square.getFirstList());
			end = square.shootLaser(start);
			showStartAndEnd(start,end);
		}
		else if(command.length() == 3 && command.charAt(2) == 'H' || command.charAt(2) == 'V') {
			row = Character.getNumericValue(command.charAt(0));
			column = command.charAt(1);
			char direction = command.charAt(2);
			start = square.search(row, column - 'A' + 1, square.getFirstList());
			end = square.shootLaserCorner(start,direction);
			showStartAndEnd(start,end);
		}
		else if(command.length() == 4 && command.charAt(0) == 'L'){
			row = Character.getNumericValue(command.charAt(1));
			column = command.charAt(2);
			start = square.search(row, (column - 'A' + 1),square.getFirstList());
			if(command.charAt(3) == 'R') {
			locate(start,(char)92);
			}
			else if(command.charAt(3) == 'L') {
			locate(start,'/');
			}
		}
	}
	
	private void playOption(int countMirrors) throws IOException {
		String location = br.readLine();
		if(location.equals("menu")) {
			showMenu();
		}
		else {
			if(countMirrors>0) {
				play(location);
			}
		}
	}
}

