package 프로그래머스.카카오;

public class level2_124나라의숫자 {
    public static void main(String args[]){
        int n = 500000000;
        System.out.println(solution(n));
    }
    public static String solution(int n) {
        String answer = "";
    
        String[] dp = new String[n+1];
        answer += DP(dp, n);
        
        return answer;
    }
    
    public static String DP(String[] dp, int n){
        if(n==0) return "4";
        else if(n==1) return "1";
        else if(n==2) return "2";
        else if(n==3) return "4";
        if(dp[n]!=null) return dp[n];

        if(n/3<=0){
            if(n%3==0) dp[n] = DP(dp,(n-1)/3) + DP(dp, 0);
            else dp[n] = DP(dp, n%3);
        }
        else if(n%3==0) dp[n] = DP(dp,(n-1)/3) + DP(dp, 0);
        else dp[n] = DP(dp, n/3) + DP(dp, n%3);
        return dp[n];
    }
    
}
