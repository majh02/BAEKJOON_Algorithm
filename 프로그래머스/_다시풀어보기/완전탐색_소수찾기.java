package 프로그래머스._다시풀어보기;

import java.util.*;

public class 완전탐색_소수찾기 {
    public static void main(String args[]){
        String numbers = "1111";
        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        char[] num = new char[len];
        for(int i=0;i<len;i++){
            num[i] = numbers.charAt(i);
        }
        
        ArrayList<Integer> created_nums = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(num[i]=='0') continue;
            
            boolean[] visited = new boolean[len];
            if(created_nums.contains(num[i]-'0')) continue;
            created_nums.add(num[i]-'0');
            visited[i] = true;
            DFS(num, created_nums, visited, len, ""+num[i]);
        }
        System.out.println(created_nums);
        for(int number : created_nums){
            if(isPrime(number)) answer++;
        }
        
        return answer;
    }
    public static void DFS(char[] num, ArrayList<Integer> created_nums, boolean[] visited, int len, String number){
        if(number.length()==len){
            return;
        }
        
        for(int i=0;i<len;i++){
            if(!visited[i]){
                String tmp = number+num[i];
                int tmp_num = Integer.parseInt(tmp);
                if(created_nums.contains(tmp_num)){
                    continue;
                }
                visited[i] = true;
                created_nums.add(tmp_num);
                DFS(num, created_nums, visited, len, tmp);
                visited[i] = false;
            }
        }
        
        return;
    }
    
    public static boolean isPrime(int number){
        if(number==0 || number==1) return false;
        
        for(int i=2;i<number;i++){
            if(number%i==0) return false;
        }
        return true;
    }
}