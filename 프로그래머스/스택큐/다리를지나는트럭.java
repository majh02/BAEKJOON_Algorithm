//스택큐_3번_다리를지나는트럭
package 프로그래머스.스택큐;

import java.io.*;
import java.util.*;

public class 다리를지나는트럭{
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck_weights[i]);
                    sum+=truck_weights[i];
                    answer++;
                    break;
                }
                else if(queue.size()==bridge_length){
                    sum-=queue.remove();
                }
                else{
                    if(sum+truck_weights[i] <= weight){
                        queue.add(truck_weights[i]);
                        sum+=truck_weights[i];
                        answer++;
                        break;
                    }
                    else{
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer+bridge_length;
    }

    //***** 시간초과 발생함 *****
    // public static int solution(int bridge_length, int weight, int[] truck_weights) {
    //     LinkedList<int[]> queue = new LinkedList<>();
    //     for(int i:truck_weights){
    //         queue.add(new int[]{i,0});
    //     }
    //     int answer = 0;
    //     int num_on_bridge = 0;
    //     int weight_on_bridge = 0;
    //     int num_of_crossed_truck = 0;
    //     int last_index = -1;

    //     while(num_of_crossed_truck<queue.size()){
    //         int size = queue.size();
    //         for(int i=0;i<size;i++){
    //             int truck[] = queue.get(i);
    //             if(truck[1]==bridge_length){
    //                 weight_on_bridge-=truck[0];
    //                 num_of_crossed_truck++;
    //                 num_on_bridge--;
    //                 truck[1]++;
    //                 continue;
    //             }
    //             else if(truck[1]>0 && truck[1]<bridge_length){
    //                 truck[1]++;
    //                 last_index=i;
    //             }
                
    //             if(truck[1]==0 && weight_on_bridge+truck[0]<=weight && i==last_index+1){
    //                 if(num_on_bridge<bridge_length){
    //                     weight_on_bridge+=truck[0];
    //                     truck[1]++;
    //                     num_on_bridge++;
    //                     break;
    //                 }
    //             }
    //         }

    //         answer++;
    //         // System.out.println("answer: "+answer+", num: "+num_on_bridge);
    //         // for(int[] i:queue){
    //         //     System.out.println(i[0]+", "+i[1]);
    //         // }
    //         // System.out.println("");
    //     }
    //     return answer;
    // }
}