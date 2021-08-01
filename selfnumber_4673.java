package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class selfnumber_4673 {
	public static int Selfnumber(int n) {
		if (n == 0) return n;
		
		int result = 0;
		
		int a = (n%10);
		result += a + Selfnumber(n/10);
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int Max = 10000;
		for (int i=1; i<=Max; i++) {
			list.add(i);
		}
		
		for (int i=1; i<=Max; i++) {
			int element = (i + Selfnumber(i));
			int index = list.indexOf(element);
			if (index != -1) list.remove(index);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size()-1) sb.append("\n");
		}
		System.out.print(sb);
	}
}
