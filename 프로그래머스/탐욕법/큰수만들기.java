//탐욕법_3번_큰 수 만들기

package 프로그래머스.탐욕법;

public class 큰수만들기 {
    public static void main(String args[]){
        String number = "4177252841";
        int k = 2;
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        String answer = "";
        int[] numbers = new int[number.length()];
        int max_num = 0, max_index = 0;
        for(int i=0;i<number.length();i++){
            numbers[i] = number.charAt(i)-'0';
            if(max_num<numbers[i] && i<=number.length()-k){
                max_num = numbers[i];
                max_index = i;
            }
        }

        k = number.length()-k-1;
        int result = max_num;
        int prev_max_index = max_index;
        while(k>0){
            max_index = find_max(numbers, k, prev_max_index);
            max_num = numbers[max_index];
            result*=10;
            result+=max_num;
            k--;
        }

        answer = Integer.toString(result);
        
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
