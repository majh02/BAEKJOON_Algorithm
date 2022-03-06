//스택큐_3번_다리를지나는트럭
import java.io.*;
import java.util.*;

public class 다리를지나는트럭{
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i:truck_weights){
            queue.add(new int[]{i,0});
        }
        int answer = 0;
        int weight_on_bridge = 0;
        int num_of_crossed_truck = 0;

        while(num_of_crossed_truck<truck_weights.length){
            for(int[] truck:queue){
                if(truck[1]==bridge_length){
                    weight_on_bridge-=truck[0];
                    num_of_crossed_truck++;
                    truck[1]++;
                    continue;
                }
                else if(truck[1]>0 && truck[1]<bridge_length){
                    truck[1]++;
                }
                
                if(truck[1]==0 && weight_on_bridge+truck[0]<=weight){
                    weight_on_bridge+=truck[0];
                    truck[1]++;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}