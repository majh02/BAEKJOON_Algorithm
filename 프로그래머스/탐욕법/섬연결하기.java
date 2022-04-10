//탐욕법_5번_섬 연결하기
//https://tosuccess.tistory.com/22 참고했음

package 프로그래머스.탐욕법;

import java.util.*;

public class 섬연결하기 {
    public static void main(String args[]){
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }

    public static int[] findParent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1,o2)->o1[2]-o2[2]);

        findParent = new int[n];
        for(int i=0;i<n;i++){
            findParent[i] = i;
        }

        for(int i=0;i<costs.length;i++){
            int firstIsland = find(costs[i][0]);
            int secondIsland = find(costs[i][1]);
            if(firstIsland != secondIsland){
                findParent[secondIsland] = firstIsland;
                answer+=costs[i][2];
            }
        }
        return answer;
    }
    public static int find(int child){
        if(findParent[child]==child) return child;
        return findParent[child] = find(findParent[child]);
    }
}
