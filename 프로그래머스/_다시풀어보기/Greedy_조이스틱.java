package 프로그래머스._다시풀어보기;

public class Greedy_조이스틱 {
    public static void main(String args[]){
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;

        int index = 0;
        while(true){
            if(index==0){
                int tmp1 = name.charAt(index)-'A';
                int tmp2 = 'Z'-name.charAt(index)+1;
                answer+=Math.min(tmp1, tmp2);
            }
            index++;

            while(index<name.length() && name.charAt(index)=='A'){
                index++;
            }
        }
        return answer;
    }
}
