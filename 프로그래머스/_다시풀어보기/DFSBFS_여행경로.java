package 프로그래머스._다시풀어보기;

import java.util.*;

public class DFSBFS_여행경로 {
    public static void main(String args[]){
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}, {"SFO", "AAA"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static boolean[] visited;
    public static ArrayList<String> airport;
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets, (o1, o2)->{
            if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        visited = new boolean[tickets.length];
        airport = new ArrayList<>();
        
        DFS(tickets, "ICN", 0);
        answer = new String[airport.size()];
        for(int i=0;i<airport.size();i++){
            answer[i] = airport.get(i);
        }
        return answer;
    }

    public static boolean DFS(String[][] tickets, String current, int count){
        airport.add(current);
        if(count==tickets.length) return true;

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                boolean flag = DFS(tickets, tickets[i][1], count+1);
                if(!flag){
                    visited[i] = false;
                    airport.remove(count+1);
                }
                else return true;
            }

        }
        return false;
    }
}

// import java.util.*;

// class Solution {
//     public static ArrayList<String> airport = new ArrayList<>();
//     public static boolean[] visited;
//     public static String[] solution(String[][] tickets) {
//         String[] answer = {};
//         visited = new boolean[tickets.length];
//         // Arrays.sort(tickets, (o1,o2)->compareStrings(o1,o2));

//         DFS(tickets, "ICN", "ICN", 0);
//         Collections.sort(airport);
//         answer = airport.get(0).split(" ");
//         return answer;
//     }

//     public static void DFS(String[][] tickets, String airport_name, String route, int cnt){
//         if(cnt == tickets.length){
//             airport.add(route);
//         }

//         for(int i=0;i<tickets.length;i++){
//             if(tickets[i][0].equals(airport_name) && !visited[i]){
//                 visited[i] = true;
//                 DFS(tickets, tickets[i][1], route+" "+tickets[i][1], cnt+1);
//                 visited[i] = false;
//             }
//         }
//     }
// }