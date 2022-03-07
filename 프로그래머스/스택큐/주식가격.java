//스택큐_4번_주식가격
import java.io.*;
import java.util.*;

public class 주식가격{
    public static void main(String args[]) throws IOException{
        int[] prices = {2, 2, 1, 5, 10, 20, 3, 1};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            for(int[] stk : stack){
                answer[stk[1]]++;
            }
            if(!stack.isEmpty()){
                while(stack.peek()[0]>prices[i]){
                    stack.pop();
                    if(stack.isEmpty()) break;
                }
            }
            stack.push(new int[]{prices[i],i});
        }
        return answer;
    }
}
