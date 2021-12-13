//9375번_패션왕 신해빈
package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        StringTokenizer st;
        String[][] Types_Of_Outfit = new String[T][31];
        int[][] Types = new int[T][31];
        for(int i=0;i<T;i++){
            int Type_count=0;
            n[i] = Integer.parseInt(br.readLine());
            for(int j=0;j<n[i];j++){
                st = new StringTokenizer(br.readLine()," ");
                String outfit = st.nextToken();
                String type = st.nextToken();
                for(int k=0;k<Type_count;k++){
                    if(type.equals(Types_Of_Outfit[i][k])) {
                        Types[i][k]++;
                        break;
                    }
                    else if(k==Type_count-1){
                        Types[i][Type_count]++;
                        Types_Of_Outfit[i][Type_count] = type;
                        Type_count++;
                        break;
                    }
                }
                if(Type_count==0){
                    Types[i][Type_count]++;
                    Types_Of_Outfit[i][Type_count] = type;
                    Type_count++;
                }
            }
        }

        for(int i=0;i<T;i++){
            long result = 1;
            for(int j=0;j<Types.length;j++){
                result*=(Types[i][j]+1);
            }
            System.out.println(result-1);
        }
    }
}
