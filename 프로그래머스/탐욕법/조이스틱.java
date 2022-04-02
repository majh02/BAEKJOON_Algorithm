//탐욕법_2번_조이스틱

package 프로그래머스.탐욕법;

public class 조이스틱 {
    public static void main(String args[]){
        String name = "JAMAAP";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int result1 = 0;
        int count = 0;
        for(int i=0;i<len;i++){
            char str = name.charAt(i);
            int num = Math.min(str-'A', 'Z'-str+1);
            result1+=num;
            System.out.println(num+", "+result1);

            if(num==0){
                count++;
            }
            else if(num!=0 && count!=0){
                count++;
                result1+=count;
                count=0;
            }
            else if(num!=0 && count==0 && i<len-1){
                result1++;
            }

            if(i==len-1) result1-=count;
        }

        System.out.println();
        int result2 = 0;
        count = 0;
        result2 = Math.min(name.charAt(0)-'A', 'Z'-name.charAt(0)+1)+1;
        System.out.println(result2);
        for(int i=len-1;i>0;i--){
            char str = name.charAt(i);
            int num = Math.min(str-'A', 'Z'-str+1);
            result2+=num;
            System.out.println(num+", "+result2);

            if(num==0) count++;
            else if(num!=0 && count!=0){
                count++;
                result2+=count;
                count=0;
            }
            else if(num!=0 && count==0 && i>1){
                result2++;
            }

            if(i==1) result2-=count;
        }

        answer = Math.min(result1, result2);
        return answer;
    }
    
}
