package 자료구조;

import java.util.*;

public class prob1 {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        int rank = Ranking2(N, num, K, 0, 1);
        System.out.println(rank);
    }

    public static int rank = 1;
    public static void Ranking(int N, int[] num, int K, int index){
        if(index==N) return;
        if(K>num[index]){
            rank++;
        }
        Ranking(N, num, K, index+1);
    }

    public static int Ranking2(int N, int[] num, int K, int index, int rank){
        if(index==N) return rank;
        if(K>num[index]) rank++;
        return Ranking2(N, num, K, index+1, rank);
    }
}
