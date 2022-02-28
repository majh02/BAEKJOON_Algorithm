//스택큐_1번_기능개발
import java.io.*;
import java.util.*;

public class 기능개발 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int progresses[] = new int[6];
        int speeds[] = new int[6];
        for(int i=0;i<progresses.length;i++){
            progresses[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<speeds.length;i++){
            speeds[i] = Integer.parseInt(br.readLine());
        }

        int result[] = new int[3];
        result = solution(progresses,speeds);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] progresses, int[] speeds) { //큐 기능으로 구현
        int[] answer = {};
        int size = progresses.length;
        int[] tmp = new int[size];
        int n = 0;
        int num = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<size;i++){
            queue.add(new int[]{progresses[i],speeds[i]});
        }

        while(!queue.isEmpty()){
            int q_size = queue.size();
            for(int i=0;i<q_size;i++){
                int[] q = queue.poll();
                int prgs = q[0];
                int spds = q[1];
                int result = prgs+spds;
                
                if(result>=100 && i==num){
                    num++;
                }
                else queue.add(new int[]{result,spds});
            }

            if(num>0){
                tmp[n] = num;
                num = 0;
                n++;
            }
        }

        answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = tmp[i];
        }
        return answer;
    }
    // public int[] solution(int[] progresses, int[] speeds) { //배열큐로 구현
    //     int[] answer = {};
    //     int size = progresses.length;
    //     int[] tmp = new int[size];
    //     int n = 0;
    //     int num = 0, prev_num = 0;
         
    //     while(true){
    //         if(num==size) break;
    //         for(int i=num;i<size;i++){
    //             int prgs = progresses[i];
    //             int spd = speeds[i];
 
    //             if(prgs>=100){
    //                 if(num==i){
    //                     num++;
    //                 }
    //                 else progresses[i] += spd;
    //             }
    //             else progresses[i] += spd;
    //         }
    //         if(num>prev_num){
    //             tmp[n] = num-prev_num;
    //             prev_num = num;
    //             n++;
    //         }
    //     }
 
    //     // System.out.println("n: "+n);
 
    //     answer = new int[n];
    //     for(int i=0;i<n;i++){
    //         answer[i] = tmp[i];
    //     }
    //     //System.out.println(Arrays.toString(answer));
    //     return answer;
    // }
}
