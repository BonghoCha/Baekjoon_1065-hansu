package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nhn_2 {
	   private static void bfs() {
	        // 현재노드
	        int curNode = 0;
	        
	        // 방문노드 저장
	        HashSet<Integer> visitedSet = new HashSet<Integer>();
	        
	        // BFS 탐색을 위해 Queue를 사용함.
	        Queue<Integer> queue = new LinkedList<Integer>();
	        
	        // 0을 시작노드로 설정
	        queue.add(curNode);
	        
	        while(!queue.isEmpty()) {
	            curNode = (int) queue.poll();
	            
	            // 방문한 노드이며 skip
	            if(visitedSet.contains(curNode) ) {
	                continue;
	            }
	            
	            // 현재 노드를 방문했다고 설정함.
	            visitedSet.add(curNode);
	            
	            // 방문한 노드를 출력
	            System.out.print(curNode + " ");
	            
	            // 현재노드와 인접한 노드를 Queue에 저장함.
	            for (int i = 0; i < mapSize; i++) {
	                if(map[curNode][i] == 1) {
	                    queue.add(i);
	                }
	            }
	        }
	    }
	   public static int[][] map = null;
	    public static int mapSize;
	   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		nhn_2 main= new nhn_2();
		//int len= 3;
		//int[] array=   {1, 2, 2,
//		             2, 10, 1,
//		             3, 2, 0}; //from example
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		mapSize = N ;
		
		map= new int[N][N];

		for (int i= 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
		   for (int j= 0; j < N; j++) {
		    map[i][j]= Integer.parseInt(st.nextToken());		    
		  }
		}
		
		for (int i= 0; i < N; i++) {
		   for (int j= 0; j < N; j++) {
		    System.out.print(map[i][j]);		    
		  }
		   System.out.println();
		}
		
        bfs();
        Queue<Integer[][]> q = new Queue<Integer[][]>();
		//= must be [D1, D1, D1, D2, R2, D1, R2, D2, R2, R1, R1], 11 jumps
	}

}
