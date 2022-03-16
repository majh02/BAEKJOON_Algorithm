//11050번_이항계수1
package BOJ.정수론및조합론;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_11051 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] ncr = new long[N+1][N+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=i;j++){
                if(i==j||j==0) ncr[i][j]=1;
                else ncr[i][j] = ncr[i-1][j-1]+ncr[i-1][j];
            }
        }
        System.out.println(ncr[N][K]%10007);
    }
}
