package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 그리디알고리즘_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        int[] waiting_time = new int[N];
        waiting_time[0] = time[0];
        int total_waiting_time = waiting_time[0];
        for(int i=1;i<N;i++) {
            waiting_time[i] = waiting_time[i - 1] + time[i];
            total_waiting_time += waiting_time[i];
        }
        System.out.println(total_waiting_time);
    }
}
