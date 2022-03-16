//4949번_균형잡힌 세상
package BOJ.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] result = new String[10000000]; //yes or no
        int count = 0; //result의 인덱스 개수
        int index=0; //.입력시 스택 연산을 중단하기 위함
        String str = br.readLine();
        while(true){
            Stack<Integer> stack = new Stack<>();
            count++;
            for(int i=index;i<str.length();i++){
                if(str.substring(i, i+1).equals(".")){
                    index = i+1;
                    break;
                }
                else if(str.substring(i, i+1).equals("(")){
                    stack.push(1);
                }
                else if(str.substring(i, i+1).equals(")")){
                    if(stack.size()==0 || stack.peek()!=1){
                        result[count] = "no";
                    }
                    else stack.pop();
                }
                else if(str.substring(i, i+1).equals("[")){
                    stack.push(2);
                }
                else if(str.substring(i, i+1).equals("]")){
                    if(stack.size()==0 || stack.peek()!=2){
                        result[count] = "no";
                    }
                    else stack.pop();
                }
            }
            if(result[count]==null&&stack.size()==0){
                result[count] = "yes";
            }
            else if(stack.size()!=0){
                result[count] = "no";
            }
            if(index==str.length()){
                str = br.readLine();
                if(str.equals(".")) break;
                index = 0;
            }
        }

        for(int i=1;i<=count;i++){
            System.out.println(result[i]);
        }
    }
}
