//동적계획법_2번_정수삼각형
//https://velog.io/@devsh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95-with-Java 참고했음

package 프로그래머스.동적계획법;

import java.util.*;

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
