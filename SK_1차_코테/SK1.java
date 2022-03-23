package SK_1차_코테;

import java.util.*;

public class SK1 {
    public static void main(String args[]){
        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};
        System.out.println(solution(money, costs));
    }

    public static int solution(int money, int[] costs) {
        ArrayList<int[]> coin = new ArrayList<>();
        for(int i=0;i<costs.length;i++){
            if(i%2==0){
                coin.add(new int[]{(int)Math.pow(10, i/2),costs[i]});
            }
            else{
                coin.add(new int[]{5*(int)Math.pow(10, i/2),costs[i]});
            }
        }

        Collections.sort(coin, (o1,o2) -> 10*o2[0]/o2[1] - 10*o1[0]/o1[1]);
        for(int i=0;i<coin.size();i++){
            System.out.println(coin.get(i)[0]+", "+coin.get(i)[1]);
        }
        
        int answer = 0;
        while(money>0){
            for(int i=0;i<coin.size();i++){
                int coin_value = coin.get(i)[0];
                int coin_cost = coin.get(i)[1];
                while(money >= coin_value){
                    money-=coin_value;
                    answer+=coin_cost;
                }
            }
        }
        return answer;
    }
    
}
