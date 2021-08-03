package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringRepeat_2675 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {			
			st = new StringTokenizer(br.readLine(), " ");
			
			int R = Integer.parseInt(st.nextToken());
			String P = st.nextToken();
			for (int j=0; j<P.length(); j++) {
				for (int k=0; k<R; k++) {
					sb.append(P.charAt(j));
				}				
			}
			
			if (i < N-1) sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
