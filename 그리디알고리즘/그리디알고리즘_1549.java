package 그리디알고리즘;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리디알고리즘_1549 {
    public static void main(String[] args) throws IOException{
        int sum = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subtraction = br.readLine().split("-");
        for(int i=0;i<subtraction.length;i++){
            int tmp = 0;
            String[] addition = subtraction[i].split("\\+");

            for(int j=0;j<addition.length;j++){
                tmp+=Integer.parseInt(addtion[j]);
            }
        }
        
        if(sum==Integer.MAX_VALUE) sum = temp;
        else sum+=temp;
    }
    
    
}
