//2110번_공유기 설치
package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_2110 {
    public static int[] house;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        house = new int[N];
        for(int i=0;i<N;i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        System.out.println(install_router(N, C, house[N-1]-house[0]+1, 1));
    }

    public static int install_router(int N, int C, int Max, int Min){
        
        while(Max>Min){
            int mid = (Min+Max)/2;
            int count=1;
            int prev=0;
            for(int i=1;i<N;i++){
                if(house[i]-house[prev]>=mid){
                    count++;
                    prev = i;
                }
            }
            //System.out.println("count: "+count+", Max: "+Max+", Min: "+Min+", len:"+mid);
            if(count < C) Max = mid;
            else Min = mid+1;
        }
        return Min-1;
    }    
}
