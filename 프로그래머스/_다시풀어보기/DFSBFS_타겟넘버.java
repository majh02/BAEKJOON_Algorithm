package 프로그래머스._다시풀어보기;

import java.util.*;

public class DFSBFS_타겟넘버 {
    public static void main(String args[]){
        int[] numbers = {1, 1, 1, 1, 2};
        int target = 4;

        System.out.println(solution(numbers, target));
    }

    public static boolean[] visited;
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = Arrays.stream(numbers).sum();
        for(int i=0;i<numbers.length;i++){
            visited = new boolean[numbers.length];
            dfs(numbers, target, i, sum);
        }
        answer = count;
        return answer;
    }

    public static int count = 0;
    public static void dfs(int[] numbers, int target, int index, int sum){
        if(index>=numbers.length||visited[index]) return;

        visited[index] = true;
        sum -= numbers[index]*2;
        if(sum==target){
            count++;
            return;
        }
        else if(sum<target){
            return;
        }

        for(int i=index+1;i<numbers.length;i++){
            dfs(numbers, target, i, sum);
            visited[i] = false;
        }

        return;
    }
    
}
