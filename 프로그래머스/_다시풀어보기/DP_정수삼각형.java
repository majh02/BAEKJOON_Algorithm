package 프로그래머스._다시풀어보기;

public class DP_정수삼각형{
    public static void main(String[] args){
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));
    }

    public static int[][] dp;
    public static int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        
        dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<size;i++){
            int length = triangle[i].length;
            dp[i][0] = triangle[i][0]+dp[i-1][0];
            dp[i][length-1] = triangle[i][length-1]+dp[i-1][length-2];
            for(int j=1;j<length-1;j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        for(int i=0;i<triangle[size-1].length;i++){
            answer = Math.max(answer, dp[size-1][i]);
        }
        return answer;
    }
}