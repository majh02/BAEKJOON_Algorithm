//정렬_2번_가장큰수
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

        for(int i=0;i<tmp.length;i++){
            for(int j=i+1;j<tmp.length;j++){
                if(tmp[i].substring(0,1).equals(tmp[j].substring(0,1))){
                    if(tmp[i].substring(tmp[i].length()-1).compareTo(tmp[j].substring(tmp[j].length()-1))>0){
                        String temp = tmp[i];
                        tmp[i] = tmp[j];
                        tmp[j] = temp;
                    }
                }
                else if(tmp[i].compareTo(tmp[j])>0){
                    String temp = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(tmp));

        for(int i=tmp.length-1;i>=0;i--){
            answer = answer.concat(tmp[i]);
        }
        return answer;
    }
}
