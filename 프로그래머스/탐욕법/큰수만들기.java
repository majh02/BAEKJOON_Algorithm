//탐욕법_3번_큰 수 만들기

package 프로그래머스.탐욕법;

import java.util.Arrays;

public class 큰수만들기 {
    public static void main(String args[]){
        String number = "9924";
        int k = 1;
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        String answer = "";
        // int[] numbers = new int[number.length()];
        // int max_num = 0, max_index = 0;
        // for(int i=0;i<number.length();i++){
        //     numbers[i] = number.charAt(i)-'0';
        //     if(i>=k) continue;
        //     else if(max_num<numbers[i]){
        //         max_num = numbers[i];
        //         max_index = i;
        //     }
        // }

        // int anti_k = number.length()-k-1;
        // int result = max_num;
        // while(anti_k>0){
        //     int prev_max_index = max_index;
        //     max_index = find_max(numbers, anti_k, prev_max_index);
        //     max_num = numbers[max_index];
        //     result*=10;
        //     result+=max_num;
        //     anti_k--;
        // }

        // answer = Integer.toString(result);

        for(int i=0;i<k;i++){
            String max = "";
            for(int j=0;j<number.length();j++){
                String tmp = number.substring(0, j)+number.substring(j+1, number.length());
                if(j==0) max = tmp;
                else if(Long.parseLong(max) < Long.parseLong(tmp)){
                    max = tmp;
                }
            }
            number = max;
            System.out.println(number);
        }

        answer = number;
        
        return answer;
    }

    public static int find_max(int[] numbers, int k, int index){
        int max_index = 0;
        int max_num = 0;

        for(int i=index+1;i<numbers.length;i++){
            if(i>numbers.length-k) break;
            if(max_num<numbers[i]){
                max_num = numbers[i];
                max_index = i;
            }
        }

        return max_index;
    }
    
}
