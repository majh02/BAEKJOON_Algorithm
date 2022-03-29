//그래프_2번_순위

package 프로그래머스.그래프;

public class 순위 {
    public static void main(String args[]){
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];

        for(int[] result : results){
            int A = result[0];
            int B = result[1];
            graph[A][B] = 1;
            graph[B][A] = -1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(graph[i][j]==1 && graph[j][k]==1){
                        graph[i][k] = 1;
                        graph[k][i] = -1;
                    }
                    if(graph[i][j]==-1 && graph[j][k]==-1){
                        graph[i][k] = -1;
                        graph[k][i] = 1;
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(i==j) count++;
                else if(graph[i][j]!=0) count++;
                else if(graph[i][j]==0) break;
            }
            if(count==n) answer++;
        }
        return answer;
    }
    
}
