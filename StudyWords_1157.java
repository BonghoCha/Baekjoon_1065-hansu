package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudyWords_1157 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		
		int count = 0;
		
		int max = 0;
		char max_char = '?';
		
		ArrayList<Character> chars = new ArrayList<Character>();
		for (int i=0; i < str.length(); i++) {			
			if (str.indexOf(str.charAt(i)) == i) {
				chars.add(str.charAt(i));
			}
		}
		
		for (char ch : chars) {
			count = (int) str.chars().filter(c -> c == ch).count();
			if (count == max) max_char = '?';
			else if (count > max) {
				max = count;
				max_char = ch;
			}
		}
		
		System.out.print(max_char);
		
		/*
		 * replace를 이용한 방식 
		int max = 1;
		char max_char = '?';
		
		String temp = str;
		
		int count = 0;
		int old = 0;
		while (temp.length() > 0) {
			char target;
			target = temp.charAt(0);
			
			old = temp.length();
			temp = temp.replace(String.valueOf(target), "");
			
			count = old - temp.length();
			
			if (count == max) max_char = '?';
			else if (count > max) {
				max = count;
				max_char = target;
			}
		}
		
		System.out.print(max_char);
		*/
	}
}
