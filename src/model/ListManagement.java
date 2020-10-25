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
		
		public void add(int row, int column) {
			List l = new List(row,charColumn);
			if(column > 1) {
				endFirstList.setNextList(l);
				l.setPrevList(endFirstList);
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
		
		private List goUp(List temp) {
				if(temp.getMirror() == ' ' && temp.getUpList() != null) {
				   temp = temp.getUpList();
				   return goUp(temp);
				}
				else {
					if(temp.getMirror() == 47 && temp.getNextList() !=null) {
						return goRight(temp.getNextList());
					}
					else if(temp.getMirror() == 92 & temp.getPrevList() !=null) {
						return goLeft(temp.getPrevList());
					}
					return temp;
				}
					
		}
		
		private List goDown(List temp) {
			 	if(temp.getMirror() == ' ' && temp.getDownList() != null) {
				   temp = temp.getDownList();
				   return goDown(temp);
				}
			 	
			 	else {
			 		if(temp.getMirror() == 47 && temp.getPrevList() !=null) {
						return goLeft(temp.getPrevList());
					}
					else if(temp.getMirror() == 92 && temp.getNextList() !=null) {
						return goRight(temp.getNextList());
					}
			 		return temp;
			 	}
					
			
		}
		
		private List goRight(List temp) {
			
				if(temp.getMirror() == ' ' && temp.getNextList() != null) {
				    temp = temp.getNextList();
				    return goRight(temp);
				} 
				else{
					if(temp.getMirror() == 47 && temp.getUpList() !=null) {
				
						return goUp(temp.getUpList());
					}
					else if(temp.getMirror() == 92 && temp.getDownList() !=null) {
						return goDown(temp.getDownList());
					}
					return temp;
				}
						
		}
		
		private List goLeft(List temp) {
				if(temp.getMirror() == ' ' && temp.getPrevList() != null) {
				   temp = temp.getPrevList();
				   return goLeft(temp);
				}
				
				else {
					if(temp.getMirror() == 47 && temp.getDownList() !=null) {
				
					return goDown(temp.getDownList());
					}
				else if(temp.getMirror() == 92 && temp.getUpList() !=null) {
					return goUp(temp.getUpList());
				}
					return temp;
				}
				
				
				
		}
		
		public List shootLaser(List start) {
			
		    if(start != firstList && start != endFirstList && start!=lastList && start != endLastList) {
		    	
		    	if(start.getColumn()  == 'A') {
		    	    start =  goRight(start);
		    	}
		    	else if(start.getRow() == 1) {
		    		start = goDown(start);
		    	}
		    	else if(start.getRow() == endLastList.getRow()) {
		    		start = goUp(start);
		    	}
		    	
		    	else if(start.getColumn() == endFirstList.getColumn()) {
		    		start = goLeft(start);
		    	}
		    }
		    return start;
		}
		
		
		public List shootLaserCorner(List start,char direction) {
			if(direction == 'H') {
				if(start == firstList || start == lastList) {
					start = goRight(start);
				}
				else if(start == endLastList || start == endFirstList) {
					start = goLeft(start);
				}
			}
			else if(direction == 'V') {
				if(start == firstList || start == endFirstList) {
					start = goDown(start);
				}
				else if(start == lastList || start == endLastList) {
					start = goUp(start);
				}
			}
			return start;
		}
		
		private void showColumns(int column,List temp) {
			if(column >=1){
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
		
}
