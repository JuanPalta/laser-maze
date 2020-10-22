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
		
		public void add(int row, int column,int mirrors) {
			List l = new List(row,charColumn);
			if(column > 1) {
				endFirstList.setNextList(l);
				l.setPrevList(endLastList);
				endFirstList.setPrevList(l.getPrevList().getPrevList());
				endFirstList = l;
				longitud++;
				charColumn++;
				add(row,(column-1),mirrors);
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
