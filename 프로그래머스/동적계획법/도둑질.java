//동적계획법_4번_도둑질
//https://beenii.tistory.com/164 참고했음

package 프로그래머스.동적계획법;

public class 도둑질 {
    public static void main(String args[]){
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int answer = 0;
        int size = money.length;
        int[] getFirst = new int[size];
        int[] ignoreFirst = new int[size];

        getFirst[0] = money[0];
        getFirst[1] = Math.max(money[0], money[1]);

        ignoreFirst[0] = 0;
        ignoreFirst[1] = money[1];

        for(int i=2;i<size;i++){
            ignoreFirst[i] = Math.max(ignoreFirst[i-1], ignoreFirst[i-2]+money[i]);
            
            if(i==size-1) break;
            getFirst[i] = Math.max(getFirst[i-1], getFirst[i-2]+money[i]);
        }

        answer = Math.max(getFirst[size-2], ignoreFirst[size-1]);
        return answer;
    }
}
