//정렬_1번_K번째수
import java.io.*;
import java.util.*;

public class K번째수 {
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            System.out.println(Arrays.toString(tmp));
            answer[i] = tmp[commands[i][2]-1];
            System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
    
}
