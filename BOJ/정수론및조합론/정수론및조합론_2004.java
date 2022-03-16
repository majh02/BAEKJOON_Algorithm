// //1671번_조합 0의 개수
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_2004 {
    public static long[] div = new long[100000000];
    public static int[] count = new int[100000000];
    public static long factorial(int n){
        if(n<=1) div[n] = 1;
        else if(div[n]!=0) return div[n];
        else div[n] = n*factorial(n-1);
        count[n] = count[n-1];

        while(true){
            if(div[n]%10==0){
                div[n]/=10;
                count[n]++;
            }
            else break;
        }
        return div[n]%1000;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        factorial(N);
        System.out.println(count[N]-(count[N-M]+count[M]));
    }
}


// public class 정수론및조합론_2004 {
//     public static long[][] div = new long[200][1000001];
//     public static int[][] count = new int[200][1000001];
//     public static int index = 1000001;
//     public static long factorial(int n){
//         if(n/index==0 && n<=1) div[0][n] = 1;
//         else if(div[n/index][n%index]!=0) return div[n/index][n%index];
//         else{
//             div[n/index][n%index] = n*factorial(n-1);
//             count[n/index][n%index] = count[(n-1)/index][(n-1)%index];
//         }

//         while(true){
//             if(div[n/index][n%index]%10==0){
//                 div[n/index][n%index]/=10;
//                 count[n/index][n%index]++;
//             }
//             else break;
//         }
//         return div[n/index][n%index]%1000;
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         factorial(N);
//         System.out.println(count[N/index][N%index]-(count[(N-M)/index][(N-M)%index]+count[M/index][M%index]));
//     }
// }
