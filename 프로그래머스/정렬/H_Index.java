//정렬_3번_H-Index
//https://ju-nam2.tistory.com/74 참고했음
import java.io.*;
import java.util.*;

public class H_Index {
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int size = citations.length;
        for(int i=0;i<size;i++){
            int h = size-i;
            if(citations[i]>=h){
                answer=h;
                break;
            }
        }

        return answer;
    }
    
}
