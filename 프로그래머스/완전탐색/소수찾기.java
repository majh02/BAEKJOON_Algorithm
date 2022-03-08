//완전탐색_2번_소수 찾기
import java.util.*;

public class 소수찾기 {
    public static void main(String args[]){
        String numbers = "17";
        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<>();
        for(int i=0;i<numbers.length();i++){
            String num = numbers.substring(i, i+1);
            number.add(Integer.parseInt(num));
        }

        for(int i=1;i<numbers.length();i++){
            
        }

        
        return answer;
    }
}
