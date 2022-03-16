//1037번 약수
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수론및조합론_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] aliquot = new int[number];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<number;i++){
            aliquot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aliquot);

        System.out.println(aliquot[0]*aliquot[number-1]);
    }
}
