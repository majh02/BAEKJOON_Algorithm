package 프로그래머스._다시풀어보기;

public class DFSBFS_네트워크 {
    public static void main(String args[]){
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] connected = new boolean[n];
        for(int i=0;i<computers.length;i++){
            if(!connected[i]){
                dfs(n, computers, connected, i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int n, int[][] computers, boolean[] connected, int index){
        connected[index] = true;

        for(int i=0;i<computers[index].length;i++){
            int com = computers[index][i];
            if(com==1 && !connected[i]){
                dfs(n, computers, connected, i);
            }
        }
        return;
    }
}
