//힙_2번_디스크 컨트롤러
//https://maetdori.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-JAVA 참고했음
package 프로그래머스.힙;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String args[]){
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0]==arr2[0])
                    return arr1[1]-arr2[1];
                return arr1[0]-arr2[0];
            }
            
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1]-arr2[1];
            }
        });

        queue.add(jobs[0]);
        int time = jobs[0][0];
        int index = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            time +=current[1];
            answer+=time-current[0];

            while(index<jobs.length && jobs[index][0]<=time){
                queue.add(jobs[index++]);
            }
            if(index<jobs.length && queue.isEmpty()){
                time = jobs[index][0];
                queue.add(jobs[index++]);
            }
        }

        return answer/jobs.length;
    }
    
}
