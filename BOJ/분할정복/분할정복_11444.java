//11444번_피보나치수6
//{1 1}n = [Fn+1  Fn ]
//{1 0}  = [ Fn  Fn-1]
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분할정복_11444 {
    public static long n;
    public static long P = 1000000007;
    public static int N = 2;
    public static long[][] A = {{1,1},{1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long[][] result = pow(n);
        System.out.println(result[1][0]);
    }

    public static long[][] matrix_mul(long[][] matrix1, long[][] matrix2){
        long[][] matrix = new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                long result = 0;
                for(int k=0;k<N;k++){
                   result+=matrix1[i][k]*matrix2[k][j];
                }
                matrix[i][j] = result%P;
            }
        }
        return matrix;
    }

    public static long[][] pow(long expo){
        if(expo==1){
            return A;
        }
        long[][] matrix = pow(expo/2);
        matrix = matrix_mul(matrix, matrix);
        if(expo%2==1){
            matrix = matrix_mul(matrix, A);
        }
        return matrix;
    }
    
}
