package 프로그래머스._다시풀어보기;

public class Greedy_조이스틱 {
    public static void main(String args[]){
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int index = 0;
        for(int i=0;i<name.length();i++){
            for(char str:name.toCharArray()){
                answer+=diff[str-'A'];
            }
            index++;

            while(index<name.length() && name.charAt(index)=='A'){
                index++;
            }

            // answer = Math.min(answer, )
        }
        return answer;
    }
}
