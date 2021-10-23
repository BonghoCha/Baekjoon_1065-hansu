package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class nhn_pre_1 {
	public static int CheckTable(int[][] table, int x, int y) {
		table[y][x] = 0;
		
		int result = 1;
		
		for (int u=-1; u<=1; u++) {
			for (int v=-1; v<=1; v++) {
				if (x+u < 0 || x+u >= table.length) continue;
				if (y+v < 0 || y+v >= table.length) continue;				
				if (u == v) continue;
				
				
				if (table[y+v][x+u] == 0) continue;			
						
 				result += CheckTable(table, x+u, y+v); 				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] table = new int[N][N];		
		for (int i=0; i < N; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			
			table[i] = new int[N];
			int index = 0;
			while(st.hasMoreTokens()) {
				table[i][index++] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (table[i][j] == 1) {
					result.add(CheckTable(table, j, i));					
				}
			}
		}
				
		if (result.size() == 0) {
			System.out.println(0);
		} else {
			Collections.sort(result);			
			System.out.println(result.size());
			
			for (int i=0; i<result.size(); i++) {
				System.out.print(result.get(i));
				if (i < result.size()-1) System.out.print(" "); 
			}
		}
	}
}
