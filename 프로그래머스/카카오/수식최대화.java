package 프로그래머스.카카오;

import java.util.*;

public class 수식최대화{
    public static void main(String args[]){
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
    public static long solution(String expression) {
        long answer = 0;
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Character> sign = new ArrayList<>();
        String number = "";
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='-'||c=='+'||c=='*'){
                sign.add(c);
                num.add((long)Integer.parseInt(number));
                number = "";
            }
            else number+=c;
        }
        num.add((long)Integer.parseInt(number));
        
        char[] sign_arr = {'*','+', '-'};
        for(int i=0;i<3;i++){
            boolean[] visited = new boolean[3];
            if(sign.contains(sign_arr[i])){
                DFS(num, sign, visited, sign_arr);
            }
        }
        
        answer = max;
        return answer;
    }

    public static long max = 0;
    public static void DFS(ArrayList<Long> num, ArrayList<Character> sign, boolean[] visited, char[] sign_arr){
        if(num.size()==1){
            max = Math.max(max, Math.abs(num.get(0)));
            return;
        }
        
        long sum = 0;
        for(int i=0;i<3;i++){
            if(!visited[i] && sign.contains(sign_arr[i])){
                visited[i] = true;
                ArrayList<Long> num_copy = (ArrayList<Long>) num.clone();
                ArrayList<Character> sign_copy = (ArrayList<Character>) sign.clone();
                
                while(sign_copy.contains(sign_arr[i])){
                    for(int j=0;j<sign_copy.size();j++){
                        if(sign_copy.get(j)!=sign_arr[i]) continue;
                        long result = calc(num_copy.get(j), num_copy.get(j+1), sign_copy.get(j));
                        num_copy.remove(j);
                        num_copy.remove(j);
                        num_copy.add(j,result);
                        sign_copy.remove(j);
                        break;
                    }
                }
                DFS(num_copy, sign_copy, visited, sign_arr);
                visited[i] = false;
            }
        }
        return;
    }
    
    public static long calc(long n1, long n2, char c){
        if(c=='+') return n1+n2;
        else if(c=='-') return n1-n2;
        else if(c=='*') return n1*n2;
        return 0;
    }
}