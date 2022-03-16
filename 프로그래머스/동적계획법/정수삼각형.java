//동적계획법_2번_정수삼각형

package 프로그래머스.동적계획법;

import java.util.Arrays;
import java.util.Collections;

public class 정수삼각형 {
    public static void main(String args[]){
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int[][] dp;
    public static int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            dp[i][0] = triangle[i][0]+dp[i-1][0];
            for(int j=1;j<i+1;j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int[] arr = dp[triangle.length-1];
        Arrays.sort(arr);
        answer = arr[arr.length-1];
        return answer;
    }
    
}
