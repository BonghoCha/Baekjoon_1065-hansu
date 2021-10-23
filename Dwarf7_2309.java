package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dwarf7_2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		boolean[] visited = new boolean[9];
		
		
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for (int i=0; i<9; i++) {
			if (combination(arr, visited, 0, 9, i)) break;
		}
		
	
	}
	
	static boolean combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {	        
	        return print(arr, visited, n);
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        boolean checked = combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	        
	        if (checked) return true;
	    }
	    
	    return false;
	}
	
    // 배열 출력
    static boolean print(int[] arr, boolean[] visited, int n) {
    	int count = 0;
    	int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
                count++;
            }
        }
        
        if (sum == 100 && count == 7) {
        	for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.println(arr[i]);
                }
            }	
        	return true;
        }
        
        return false;
    }

}
