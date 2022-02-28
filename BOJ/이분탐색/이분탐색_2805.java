//2805번_나무 자르기
package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이분탐색_2805 {
    public static long[] tree;
    public static long Max = 0, Min = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        tree = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            Max = Math.max(Max, tree[i]);
        }
        System.out.println(find_length(N, M));
    }

    public static long find_length(int N, int M){
        long mid=0;
        long count=0;
        long tmp_mid = 0, tmp_count = 0;
        while(Min<Max){
            mid = (Max+Min)/2;
            count = 0;

            for(int i=0;i<N;i++){
                if(tree[i]<=mid) continue;
                count+=(tree[i]-mid);
            }

            if(count==M) break;
            else if(tmp_count<count&&tmp_count!=0) {
                mid = tmp_mid;
                break;
            }
            else if(count < M) {
                Max = mid;
            }
            else{
                if(tmp_mid==mid&&tmp_count==count) break;
                tmp_mid = mid;
                tmp_count = count;
                Min = mid+1;
            }
            if(Max<=Min) return tmp_mid;
        }
        return mid;
    }
}
