//탐욕법_2번_조이스틱 (★★★★☆)
//https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1 참고했음

package 프로그래머스.탐욕법;

public class 조이스틱 {
    public static void main(String args[]){
        String name = "BBBBAAAAAAAB";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index;
        int move = length-1;
        for(int i=0;i<length;i++){
            answer+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            index = i+1;
            while(index<length && name.charAt(index)=='A'){
                index++;
            }

            move = Math.min(move, i*2+length-index);
            move = Math.min(move, (length-index)*2+i);
        }
        return answer+move;
    }
    
}
