package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumWholeNumbers_11720 {
	public static int sumNumbers(String str){
		int result = 0;
		for (int i=0; i < str.length(); i++) {
			result += Character.getNumericValue(str.charAt(i));
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int result = sumNumbers(str);
	
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		
		System.out.print(sb);
	}
}
