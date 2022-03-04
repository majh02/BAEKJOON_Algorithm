//스택큐_3번_다리를지나는트럭
import java.io.*;
import java.util.*;

public class 다리를지나는트럭{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int brige_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());
        int[] truck_weights = {7,4,5,6};


    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // Queue<Integer> queue = new LinkedList<>();
        // for(int i=0;i<truck_weights.length;i++){
        //     queue.add(e)
        // }
        int answer = 0;
        int sum_of_truck_weight = 0;
        int num_of_truck = 0;
        for(int i=0;i<truck_weights.length;i++){
            if(sum_of_truck_weight+truck_weights[i]<=weight && num_of_truck+1 <= bridge_length){
                sum_of_truck_weight+=truck_weights[i];
                num_of_truck++;
            }
            else{
                sum_of_truck_weight=0;
                answer+=
            }
        }
        return answer;
    }
}