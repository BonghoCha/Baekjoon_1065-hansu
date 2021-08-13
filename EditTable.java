package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
class Table{
	ArrayList<Cell> cells;	
	Stack<Cell> gc;
	
	int currentIndex;
	
	Table(int n){
		cells = new ArrayList<Cell>();
		
		gc = new Stack<Cell>();
		
		for (int i=0; i<n; i++) {
			AddCell(""+i, i);
		}
		
		currentIndex = 0;
	}
	
	void AddCell(String name, int i) {
		cells.add(new Cell(i, name));
	}
		
	void AddCell(Cell cell) {
		for (int i=0; i<cells.size(); i++) {
			if (cells.get(i).index > cell.index) {
				cells.add(i, cell);
				if (i <= currentIndex) currentIndex++;
				return;
			}
		}
		
		cells.add(cell);
	}
	
	void DeleteCell(){
		if (cells.size() == 0) return;
		
		gc.add(cells.get(currentIndex));				

		cells.remove(currentIndex);
		SelectIndex(0);
	}
	
	void RecoverCell() {
		if (gc.size() == 0) return;	

		AddCell(gc.pop());
	}
	
	void SelectIndex(int num) {
        if (cells.size() == 0) return;
		
		currentIndex += num;
				
		if (currentIndex < 0) currentIndex = 0;
		else if (currentIndex >= cells.size()) currentIndex = cells.size()-1;
	}
	
	void Result() {
		Cell c;
		while (!gc.isEmpty()) {
			c = gc.pop();
			c.isRemoved = true;
			AddCell(c);
		}
	}
}

class Cell{
	int index;
	String name;	
	
	boolean isRemoved;
	String isSelected = "";
	
	Cell(int _index, String _name) {
		index = _index;
		name = _name;
		
		isRemoved = false;
	}
}
*/

public class EditTable {
	public static String Answer(int n, int k, String[] cmd){
        boolean[] table = new boolean[n];

        int currentIndex = k;
        int upIndex = k-1;
        int downIndex = k+1;

        if (upIndex < 0) upIndex = 0;
        if (downIndex >= table.length) downIndex = table.length-1;

        Stack<Integer> gc = new Stack<Integer>();

        String action = "";
        StringTokenizer split;
        int num = 0;
        int index = 0;

        String c;
        for (int i=0; i<cmd.length; i++) {      
            c = cmd[i];

            if (c.length() == 1) {
                action = c;
            } else {
                split = new StringTokenizer(c, " ");
                action = split.nextToken();

                num = Integer.parseInt(split.nextToken());
            }

            int count = 0;
            switch (action) {
                case "U": {
                    if (currentIndex == 0) continue;

                    index = 0;
                    for (int j=upIndex; j>=0; j--) {
                        if (table[j]) continue;

                        count++;
                        if(count == num) {
                            index = j;
                            break;
                        }
                        else if (count == num-1) {
                            downIndex = j;
                        }
                    }
                    if (count == 1) downIndex = currentIndex;

                    if(index == 0) upIndex = 0;
                    else if (index > 0) {
                        count = 0;
                        for (int j=index-1; j>=0; j--) {
                            if (table[j]) continue;

                            count++;
                            if (count == 1){
                                upIndex = j;
                                break;    
                            }                           
                        }
                        if (count == 0) upIndex = index;
                    }                   

                    currentIndex = index;

                    break;
                }
                case "D": {                 
                    if (currentIndex == table.length-1) continue;

                    index = table.length-1;
                    for (int j=downIndex; j<table.length; j++) {
                        if (table[j]) continue;

                        count++;
                        if(count ==  num) {
                            index = j;      
                            break;
                        } else if (count == num-1) {
                            upIndex = j;
                        }
                    }                   
                    if (count == 1) upIndex = currentIndex;

                    if (index == table.length-1) downIndex = table.length-1;
                    else if (index < table.length-1) {
                        count = 0;
                        for (int j=index+1; j<table.length; j++) {
                            if (table[j]) continue;

                            count++;
                            if (count == 1){
                                downIndex = j;
                                break;    
                            }
                        }
                        if (count == 0) downIndex = index;
                    }

                    currentIndex = index;

                    break;
                }
                case "C": {
                    if (gc.size() == table.length) continue;

                    table[currentIndex] = true;
                    gc.add(currentIndex);

                    index = -1;

                    count = 0;
                    for (int j=downIndex; j<table.length; j++) {
                        if (table[j]) continue;

                        count ++;
                        if (count == 1) {
                            index = j;                          
                        } else if (count == 2) {
                            downIndex = j;
                            break;
                        }                       
                    }

                    if (index == table.length-1) {
                        downIndex = table.length-1;
                    }

                    if (index == -1) {                      
                        count = 0;
                        for (int j=upIndex; j >= 0; j--) {
                            if (table[j]) continue;

                            count++;
                            if (count == 1) {
                                index = j;
                            } else if (count == 2) {
                                upIndex = j;
                                break;
                            }
                        }

                        if (index == 0) {
                            upIndex = 0;
                        }
                    }

                    currentIndex = index;

                    break;
                }
                case "Z" :{
                    if (gc.isEmpty()) continue;

                    index = gc.peek();
                    table[gc.pop()] = false;

                    if (currentIndex == -1){
                        currentIndex = index;
                    } else {
                        if (currentIndex > index) {
                            if (index > upIndex) upIndex = index;
                        } else if (currentIndex < index) {
                            if (index < downIndex) downIndex = index;
                        }
                    }

                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder(n);

        for (int i=0; i<table.length; i++) {    
            if (!table[i]) sb.append("O");
            else sb.append("X");
        }

        return sb.toString();
	}
	
	public static void main(String[] args) throws Exception, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = 8;
		int k = 2;
		
		String[] cmd = {
				"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"
		};
		
		System.out.print(Answer(n, k, cmd));
	}
}
