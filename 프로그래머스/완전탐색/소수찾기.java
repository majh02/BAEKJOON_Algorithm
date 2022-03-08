//완전탐색_2번_소수 찾기
import java.util.*;

public class 소수찾기 {
    public static void main(String args[]){
        String numbers = "011";
        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        int answer = 0;
        String tmp = "";
        for(int i=0;i<numbers.length();i++){
            DFS(numbers,tmp,i+1);
        }
        for(int i=0;i<arr.size();i++){
            answer += isPrime(arr.get(i));
        }
        
        return answer;
    }

    public static boolean[] visited = new boolean[10];
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void DFS(String str, String tmp, int m){
        if(tmp.length()==m){
            int num = Integer.parseInt(tmp);
            if(!arr.contains(num)){
                arr.add(num);
            }
            return;
        }
        else{
            for(int i=0;i<str.length();i++){
                if(!visited[i]){
                    visited[i] = true;
                    tmp+=str.charAt(i);
                    DFS(str,tmp,m);
                    visited[i] = false;
                    tmp = tmp.substring(0, tmp.length()-1);
                }
            }
        }
    }

    public static int isPrime(int n){
        if(n==0 || n==1) return 0;
        for(int i=2;i<n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}
