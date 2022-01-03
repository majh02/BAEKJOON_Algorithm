//10830번_행렬제곱
//https://st-lab.tistory.com/251 참고했음
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_10830 {
    public static int N;
    public static int[][] A;
    public static int P = 1000;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken())%P;
            }
        }

        int[][] result = pow(B);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] matrix_mul(int[][] matrix1, int[][] matrix2){
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int result = 0;
                for(int k=0;k<N;k++){
                   result+=matrix1[i][k]*matrix2[k][j];
                }
                matrix[i][j] = result%P;
            }
        }
        return matrix;
    }

    public static int[][] pow(long expo){
        if(expo==1){
            return A;
        }
        int[][] matrix = pow(expo/2);
        matrix = matrix_mul(matrix, matrix);
        if(expo%2==1){
            matrix = matrix_mul(matrix, A);
        }
        return matrix;
    }
    
}
