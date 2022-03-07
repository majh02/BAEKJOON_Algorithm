//해시_3번_위장
import java.util.*;

public class 위장 {
    public static void main(String args[]){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] Clothes : clothes){
            if(map.containsKey(Clothes[1])){
                int value = map.get(Clothes[1]);
                map.put(Clothes[1],value+1);
            }
            else map.put(Clothes[1], 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            answer*=entry.getValue()+1;
        }
        answer--;
        return answer;
    }
}
