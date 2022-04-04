//탐욕법_3번_큰 수 만들기

package 프로그래머스.탐욕법;

import java.util.Arrays;

public class 큰수만들기 {
    public static void main(String args[]){
        String number = "11111911";
        int k = 6;
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        String answer = "";
        int anti_k = number.length()-k;
        
        if(number.charAt(0)=='0') return "0";
        while(k>0){
            char max = '0';
            int max_index = -1;
            for(int j=0;j<=k;j++){
                char str = number.charAt(j);
                if(max<str){
                    max = str;
                    max_index = j;
                }
            }
            number = number.substring(max_index+1);
            answer+=max;
            k-=max_index;
            if(k>=number.length()) k = number.length()-1;
        }
        
        if(answer.length()!=anti_k)
            answer+=number;
        
        return answer;
    }
    
}
