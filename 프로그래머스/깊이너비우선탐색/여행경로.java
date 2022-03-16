//DFS,BFS_4번_여행경로
//https://velog.io/@rari_1110/DFS-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%AC%ED%96%89%EA%B2%BD%EB%A1%9C-JAVA 참고했음
package 프로그래머스.깊이너비우선탐색;

import java.util.*;

public class 여행경로 {
    public static void main(String args[]){
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL","SFO"}, {"SFO", "ICN"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static ArrayList<String> airport = new ArrayList<>();
    public static boolean[] visited;
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];

        DFS(tickets, "ICN", "ICN", 0);

        Collections.sort(airport);
        answer = airport.get(0).split(" ");
        return answer;
    }

    public static void DFS(String[][] tickets, String airport_name, String route, int cnt){
        if(cnt == tickets.length){
            airport.add(route);
        }

        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(airport_name) && !visited[i]){
                visited[i] = true;
                DFS(tickets, tickets[i][1], route+" "+tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}


