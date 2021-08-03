package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet_10809 {    
   
	public static void main(String[] args) throws IOException {	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
				
		for (char i='a'; i<='z'; i++) {
			int index = -1;
			for (int j=0; j<S.length(); j++) {
				if (S.charAt(j) == i) {
					index = j;
					break;
				}
			}
			sb.append(index);
			if (i <= 'z'-1) sb.append(" "); 
		}
		
		System.out.print(sb);
	}
}
