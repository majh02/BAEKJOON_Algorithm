//정렬_2번_가장큰수
//https://ivory-room.tistory.com/43 참고했음
import java.io.*;
import java.util.*;

public class 가장큰수 {
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        String answer = "";

        String[] tmp = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            tmp[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        // System.out.println(Arrays.toString(tmp));

        if(tmp[0].equals("0")) return "0";
        for(String i : tmp){
            answer += i;
        }
        return answer;
    }
}
