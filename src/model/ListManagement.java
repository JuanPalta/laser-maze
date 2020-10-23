package model;

public class ListManagement {

		private List firstList;
		private List endFirstList; 
		private List lastList;
		private List endLastList;
		private char charColumn;
		private int longitud;
		
		public ListManagement(int row) {
			List list = new List(row,'A');
			firstList = list;
			endFirstList = list;
			lastList = list;
			endLastList = list;
			charColumn = 'B';
			longitud = 1;
		}

		public List getFirstList() {
			return firstList;
		}

		public void setFirstList(List firstList) {
			this.firstList = firstList;
		}
		
		public void add(int row, int column) {
			List l = new List(row,charColumn);
			if(column > 1) {
				endFirstList.setNextList(l);
				l.setPrevList(endLastList);
				endFirstList.setPrevList(l.getPrevList().getPrevList());
				endFirstList = l;
				longitud++;
				charColumn++;
				add(row,(column-1));
			}	
		}
		
		public List search(int row,int column,List temp) {
			
			if(row>1) {
				temp = temp.getDownList();
				return search(row-1,column,temp);
				}
			else if(column >1){
				temp = temp.getNextList();
				return search(row,column-1,temp);
			}
			return temp;
			
		}
		
		private void showColumns(int column,List temp) {
			if(column >1){
				System.out.print(temp.getContent());
				if(temp.getNextList() != null) {
					temp = temp.getNextList();
					showColumns(column--,temp);
			}
			}
		}
		
		public void showContent(int row, int column, List temp) {
			
			if(row>=1) {
				
				showColumns(column,temp);
				System.out.println();
				if(temp.getDownList()  != null) {
				temp = temp.getDownList();
				showContent(row--,column,temp);
				}
			}
			
		}
			
		

		public List getEndLastList() {
			return endLastList;
		}

		public List getLastList() {
			return lastList;
		}

		public List getEndFirstList() {
			return endFirstList;
		}

		public int getLongitud() {
			return longitud;
		}

		public void setLongitud(int longitud) {
			this.longitud = longitud;
		}
		
		public void setLastList(List lastList) {
			this.lastList = lastList;
		}
		
		public void setEndLastList(List endLastList) {
			this.endLastList = endLastList;
		}
}
