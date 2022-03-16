//1697번_숨바꼭질
package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_1697 {
    public static int N, K;
    public static int sec[] = new int[100001];
    public static int check[] = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N = Integer.parseInt(st.nextToken());
        // K = Integer.parseInt(st.nextToken());
        // if(N>K){
        //     int tmp = N;
        //     N = K;
        //     K = tmp;
        // }
        // else if(N==K){
        //     System.out.println(0);
        //     return;
        // }

        // queue.add(N);
        for(int i=0;i<=100000;i++){
            for(int j=0;j<=100000;j++){
                N=i; K=j;
                sec = new int[100001];
                check = new int[100001];
                queue = new LinkedList<>();
                queue.add(N);
                BFS();
                bfs(N, K);
                if(sec[K]!=check[K]) System.out.println("N: "+N+", K: "+K+"    "+sec[K]+", "+check[K]);
            }
        }
        // BFS();
        // System.out.println(sec[K]);
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current-1>=0 && sec[current-1]==0){
                sec[current-1] = sec[current]+1;
                queue.add(current-1);
            }
            if(current+1<sec.length && sec[current+1]==0){
                sec[current+1] = sec[current]+1;
                queue.add(current+1);
            }
            if(2*current<sec.length && sec[2*current]==0){
                sec[current*2] = sec[current]+1;
                queue.add(current*2);
            }
            if(sec[K]!=0) break;
        }
        return;
    }
    public static void bfs(int a,int k) { //BFS메소드, 수빈이의 위치와 동생의 위치를 전달
		Queue<Integer> Q = new LinkedList();
		
		check[a] = 0; // 수빈이의 위치를 0으로 초기화
		Q.offer(a); 
		
		while(!Q.isEmpty()) { //큐가 빌 때 까지 반복한다.
			int x = Q.poll();
			if(check[k]!=0) break; // 그러나 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어난다.
								   // 배열의 크기를 100,001로 해서 시간을 조금이라도 단축시키기 위함
			if((x-1>=0) && check[x-1]==0) { // 이 부분에서 많은 분들이 런타임 에러가 많이 발생하는 것 같다.
				Q.offer(x-1);  			// 조건부의 x범위를 먼저 확인해줘야 뒤에 배열 인덱스를 참조할 때 범위를 벗어나지 않는다.
				check[x-1] = check[x]+1; //이동할 수 있는 경우 x-1
			}
			if((x<check.length-1)&&check[x+1]==0) {
				Q.offer(x+1);
				check[x+1] = check[x]+1; //이동할 수 있는 경우 x+1
			}
			if((x*2<check.length)&&check[2*x]==0) {
				Q.offer(2*x);
				check[2*x] = check[x]+1; //이동할 수 있는 경우 순간이동 x*2
			}
			
		}	
	}
    
}

// import java.util.*;

// public class DFS와BFS_1697 {
	
// 	static int check[]; // 방문여부 배열
		
	// public static void bfs(int a,int k) { //BFS메소드, 수빈이의 위치와 동생의 위치를 전달
	// 	Queue<Integer> queue = new LinkedList();
		
	// 	check[a] = 0; // 수빈이의 위치를 0으로 초기화
	// 	queue.offer(a); 
		
	// 	while(!queue.isEmpty()) { //큐가 빌 때 까지 반복한다.
	// 		int x = queue.poll();
	// 		if(check[k]!=0) break; // 그러나 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어난다.
	// 							   // 배열의 크기를 100,001로 해서 시간을 조금이라도 단축시키기 위함
	// 		if((x-1>=0) && check[x-1]==0) { // 이 부분에서 많은 분들이 런타임 에러가 많이 발생하는 것 같다.
	// 			queue.offer(x-1);  			// 조건부의 x범위를 먼저 확인해줘야 뒤에 배열 인덱스를 참조할 때 범위를 벗어나지 않는다.
	// 			check[x-1] = check[x]+1; //이동할 수 있는 경우 x-1
	// 		}
	// 		if((x<check.length-1)&&check[x+1]==0) {
	// 			queue.offer(x+1);
	// 			check[x+1] = check[x]+1; //이동할 수 있는 경우 x+1
	// 		}
	// 		if((x*2<check.length)&&check[2*x]==0) {
	// 			queue.offer(2*x);
	// 			check[2*x] = check[x]+1; //이동할 수 있는 경우 순간이동 x*2
	// 		}
			
	// 	}	
	// }
	
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);	
		
// 		int n = sc.nextInt(); // 수빈이 위치
// 		int k = sc.nextInt(); // 동생 위치
// 		check = new int [100001]; // 수빈이와 동생이 위치할 수 있는 범위는 0 ~ 100,000이다.
		
		
// 		if(n==k) { // 만약 수빈이와 동생의 위치가 같다면 이동할 필요가 없다.
// 			System.out.println("0"); // 이 부분에서 오답처리를 받았다. 예외의 경우를 항상 생각하자.
// 			return;
// 		}
// 		bfs(n,k); // bfs로 수빈이와 동생의 위치를 전달한다.
		
// 		System.out.println(check[k]); // 수빈이 위치 인덱스 값을 출력한다.
		
		
		
		
		
// 	}
	
// }
