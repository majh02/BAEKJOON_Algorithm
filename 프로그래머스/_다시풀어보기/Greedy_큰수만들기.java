package 프로그래머스._다시풀어보기;

public class Greedy_큰수만들기 {
    public static void main(String args[]){
        String number = "1924";
        int k = 2;
        System.out.println(solution(number, k));
    }
    public static String max = "0";
    public static String solution(String number, int k) {
        String answer = "";
 
        char[] num = new char[number.length()];
        for(int i=0;i<number.length();i++){
            num[i] = number.charAt(i);
        }
        
        for(int i=0;i<num.length;i++){
            boolean[] visited = new boolean[num.length];
            visited[i] = true;
            DFS(num, k, visited, i, 1, ""+num[i]);
        }
        
        answer = max;
        return answer;
    }
    
    public static void DFS(char[] num, int k, boolean[] visited, int index, int count, String sum){
        if(count==num.length-k){
            int result = Integer.parseInt(sum);
            int max_value = Integer.parseInt(max);
            // System.out.println("max: "+max_value+", result: "+result);
            if(max_value<result){
                max = sum;
            }
            return;
        }
        
        for(int i=index+1;i<num.length;i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(num, k, visited, i, count+1, sum+num[i]);
                visited[i] = false;
            }
        }
        
        return;
    }
}
