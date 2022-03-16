package BOJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리디알고리즘_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<2||N>100000) return;

        long[] road_length = new long[N-1];
        long[] oil_price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long sum=0;
        for(int i=0;i<N-1;i++){
            road_length[i] = Integer.parseInt(st.nextToken());
            sum+=road_length[i];
            if(road_length[i]<1) return;
            if(sum>1000000000) return;
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            oil_price[i] = Integer.parseInt(st.nextToken());
            if(oil_price[i]<1||oil_price[i]>1000000000) return;
        }

        long price = Integer.MAX_VALUE;
        long total_price = 0;
        for(int i=0;i<N-1;i++){
            if(price==Integer.MAX_VALUE) price = oil_price[0];
            else if(price>oil_price[i]) price = oil_price[i];

            total_price += price*road_length[i];
        }
        System.out.println(total_price);
    }
}
