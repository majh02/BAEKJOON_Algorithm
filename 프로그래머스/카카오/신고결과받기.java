package 프로그래머스.카카오;

import java.util.*;

public class 신고결과받기 {
    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] reported = new int[id_list.length][id_list.length];
        int[] report_sum = new int[id_list.length];
        
        for(String Report : report){
            StringTokenizer st = new StringTokenizer(Report, " ");
            int user1 = find_id_index(id_list, st.nextToken());
            int user2 = find_id_index(id_list, st.nextToken());

            if(reported[user1][user2]==0){
                reported[user1][user2] = 1;
                report_sum[user2]++;
            }
        }

        for(int user2=0;user2<id_list.length;user2++){
            if(report_sum[user2]<k) continue;
            for(int user1=0; user1<id_list.length;user1++){
                if(reported[user1][user2]==1){
                    answer[user1]++;
                }
            }    
        }
        
        return answer;
    }

    public static int find_id_index(String[] id_list, String id){
        for(int i=0;i<id_list.length;i++){
            if(id_list[i].equals(id)) return i;
        }
        return -1;
    }
    
}
