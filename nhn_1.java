package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nhn_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Math.ceil(N/2);
		
		ArrayList<Integer> elevator = new ArrayList<Integer>();
		ArrayList<int[]> waiting = new ArrayList<int[]>();		
	
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int index = Integer.parseInt(st.nextToken())-1;
			int target = Integer.parseInt(st.nextToken())-1;
			
			int[] one = new int[2];
			one[0] = index;
			one[1] = target;
			
			waiting.add(one);
		}

		int time = 0;
		
		int floor = 0;
		int a = 1;
		while (true) {
			for (int i=0; i<elevator.size(); i++) {
				if (elevator.get(i) == floor) {
					elevator.remove(i);
					i--;
				}
			}
			
			for (int i=0; i<waiting.size(); i++) {
				if (elevator.size() == M) {
					break;
				}
				
				if (waiting.get(i)[0] == floor) {
					elevator.add(waiting.get(i)[1]);
					waiting.remove(i);
					i--;
				}						
			}
			
			if (elevator.size() == 0 && waiting.size() == 0) {
				System.out.println(time);
				break;
			}
			
			floor += a;
			if (floor == K-1 || floor == 0) a *= -1;
			
			time++;
		}
	}

}
