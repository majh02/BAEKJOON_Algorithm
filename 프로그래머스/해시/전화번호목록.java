//해시_2번_전화번호 목록
//https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8-%EB%AA%A9%EB%A1%9D-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java 참고했음
package 프로그래머스.해시;

import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i], i);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
    
}
