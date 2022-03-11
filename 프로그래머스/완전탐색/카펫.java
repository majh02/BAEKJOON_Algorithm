//완전탐색_3번_카펫
import java.util.*;

public class 카펫 {
    public static void main(String args[]){
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int area = brown+yellow;
        
        int n = 3;
        int i = area/n;
        int j = area/i;
        while(i>=j){
            if((i+j-2)*2==brown && (i-2)*(j-2)==yellow){
                answer = new int[2];
                answer[0] = i;
                answer[1] = j;
                break;
            }
            n++;
            i = area/n;
            j = area/i;
        }

        return answer;
    }
    
}
