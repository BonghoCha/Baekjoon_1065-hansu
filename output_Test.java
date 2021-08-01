package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class output_Test {

	public static void main(String[] arg) {
		// String 초기값 설정
		String str1 = "Test 1";
		String str2 = "Test 2";
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		// String 끼리 더하기 Add
		str1 = str1 + str2;
		System.out.println(str1.hashCode());
		System.out.println("---");
		
		StringBuilder sb1 = new StringBuilder();
		StringBuffer sb2 = new StringBuffer();
		
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		System.out.println("---");
		
		sb1.append("Test 3");
		sb2.append("Test 4");
		
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
	}
}
