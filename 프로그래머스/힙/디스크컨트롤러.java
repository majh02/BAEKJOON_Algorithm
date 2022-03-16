//힙_2번_디스크 컨트롤러
package 프로그래머스.힙;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String args[]){
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            return o1[1] - o2[1];
        });
        for(int i=0;i<jobs.length;i++){
            queue.add(new int[]{jobs[i][0], jobs[i][1]});
        }

        int time = 0;
        while(!queue.isEmpty()){
            if(answer==0){
                int[] system = queue.poll();
                time+=system[0]+system[1];
                answer+=system[1];
            }
            else if(queue.size()<2){
                int[] system = queue.poll();
                answer+=time-system[0]+system[1];
                time+= system[1];
            }
            else{
                int[] system1 = queue.poll();
                int[] system2 = queue.poll();
                if(system1[0]>time){
                    time=system1[0];

                }
                if(system2[0]>time){
                    answer+=time-system1[0]+system1[1];
                    time+= system1[1];
                    queue.add(system2);
                    continue;
                }
                int sys1_time = time-system1[0]+system1[1];
                int sys2_time = time-system2[0]+system2[1];
                if(sys1_time<sys2_time){
                    queue.add(system2);
                    time+=system1[1];
                    answer+=sys1_time;
                }
                else{
                    queue.add(system1);
                    time+=system2[1];
                    answer+=sys2_time;
                }
            }
            System.out.println(answer);
            for(int[] i : queue){
                System.out.println(i[0]+", "+i[1]);
            }
        }

        return answer/jobs.length;
    }
    
}
