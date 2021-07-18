package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class test {
	public static void function(int N) {
		int result = 0;
		
		List<Integer> numbers = new ArrayList<>();
		for (int i=1; i<=N; i++) {
			boolean a;
			
			if (i < 100) {
				result++;
			} else {
				if (numbers.size() > 0) numbers.clear();
				
				int temp = i;
				while (temp > 0) {
					int n = temp % 10;
					numbers.add(n);
					
					temp /= 10;
				}
				
				boolean check = true;
				
				int d = numbers.get(1) - numbers.get(0);
				for (int j = 1; j<numbers.size()-1; j++) {
					int current = numbers.get(j+1) - numbers.get(j);
					if (current != d) {
						check = false;
						break;
					}
				}
				
				if (check) {
					result++;
				}
			}
		}
		
		sb.append(result);
	}
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		int N = Integer.parseInt(st.nextToken());
		
		function(N);
		System.out.print(sb);
	}
}
