//12015번_가장 긴 증가하는 부분 수열2
package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이분탐색_12015 {
    public static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        A = new int[N+1];
        A[0] = 0;
        int length = 1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > A[length-1]){
                A[length] = num;
                length++;
                continue;
            }
            else if(num<A[1]){
                A[1] = num;
                continue;
            }
            find_sequence(num, 0, length);
        }
        System.out.println(length-1);
    }

    public static void find_sequence(int num, int start, int end){
        if(start>=end) return;
        int mid = (start+end)/2;
        if(A[mid-1]<num && num<A[mid]){
            A[mid] = num;
            return;
        }
        else if(num<A[mid-1]) find_sequence(num, start, mid);
        else if(num>A[mid]) find_sequence(num, mid+1, end);
        return;
    }  
}
