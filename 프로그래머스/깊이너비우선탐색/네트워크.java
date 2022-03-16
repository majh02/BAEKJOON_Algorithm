//DFS,BFS_2번_네트워크
package 프로그래머스.깊이너비우선탐색;

public class 네트워크 {
    public static void main(String args[]){
        int n=3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }

    public static int answer;
    public static int solution(int n, int[][] computers) {
        answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                DFS(n, computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    public static void DFS(int n, int[][] computers, boolean[] visited, int p){
        visited[p] = true;
        for(int i=0;i<computers.length;i++){
            if(computers[p][i]==1 && !visited[i]){
                DFS(n, computers, visited, i);
            }
        }
    }
}
