//5086번 배수와 약수
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] a = new int[10000];
        int[] b = new int[10000];
        int i = 0;
        while(true){
            st  = new StringTokenizer(br.readLine()," ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            if(a[i]==0 && b[i]==0) break;
            i++;
        }

        for(int j=0;j<i;j++){
            if(a[j]!=0&&b[j]%a[j]==0) System.out.println("factor");
            else if(b[j]!=0&&a[j]%b[j]==0) System.out.println("multiple");
            else System.out.println("neither");
        }
    }
}
