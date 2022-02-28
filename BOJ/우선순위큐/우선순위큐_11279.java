//11279번_최대 힙
package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 우선순위큐_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
            else{
                queue.offer(x);
            }
        }

        System.out.println(sb);
    }
}
        
//         int[] heap = new int[100000];
//         int size = 0, height = 0;
//         for(int i=0;i<N;i++){
//             int x = Integer.parseInt(br.readLine());
//             if(x==0){
//                 if(size==0){
//                     sb.append(0).append("\n");
//                     continue;
//                 }
//                 sb.append(heap[0]).append("\n");
//                 heap[0] = heap[size-1];
//                 heap[size-1] = 0;
//                 size--;

//                 int current = 0;
//                 while(heap[current]!=0){
//                     int index = define_max(heap, current);
//                     if(heap[current]<heap[index]){
//                         int tmp = heap[index];
//                         heap[index] = heap[current];
//                         heap[current] = tmp;
//                         current = index;
//                     }
//                     else break;
//                 }
//             }
//             else{
//                 if(size==0){
//                     heap[size] = x;
//                     size++;
//                     height = 1;
//                 }
//                 else{
//                     if(heap[(size-1)/2]>x){
//                         heap[size] = x;
//                     }
//                     else{
//                         int tmp = heap[(size-1)/2];
//                         heap[(size-1)/2] = x;
//                         heap[size] = tmp;
//                     }
//                     size++;
//                     if(size+1==Math.pow(2, height)){
//                         height++;
//                     }
//                 }
//             }
//             //System.out.println(Arrays.toString(heap));
//         }

//         System.out.println(sb);
//     }
    
//     public static int define_max(int[] heap, int current){
//         int index1 = current*2+1;
//         int index2 = current*2+2;
//         int value1 = heap[index1];
//         int value2 = heap[index2];

//         int index;
//         if(value1>value2){
//             index = index1;
//         }
//         else{
//             index = index2;
//         }
//         return index;
//     }
// }
