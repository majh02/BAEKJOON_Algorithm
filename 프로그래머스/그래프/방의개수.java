//그래프_3번_방의 개수
//https://pangtrue.tistory.com/350 참고했음

package 프로그래머스.그래프;

import java.util.*;

public class 방의개수 {
    public static void main(String args[]){
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.println(solution(arrows));
    }

    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            return this.x == ((Node)o).x && this.y == ((Node)o).y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    public static int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        Node curNode = new Node(0,0);
        
        HashMap<Node, ArrayList<Node>> visited = new HashMap<>();
        for(int arrow : arrows){
            for(int i=0;i<=1;i++){
                Node nextNode = new Node(curNode.x + dx[arrow], curNode.y+dy[arrow]);
                if(!visited.containsKey(nextNode)){
                    visited.put(nextNode, makeEdgeList(curNode));

                    if(visited.get(curNode) == null){
                        visited.put(curNode, makeEdgeList(nextNode));
                    }
                    else{
                        visited.get(curNode).add(nextNode);
                    }
                }
                else if(visited.containsKey(nextNode) && !(visited.get(nextNode).contains(curNode))){
                    visited.get(nextNode).add(curNode);
                    visited.get(curNode).add(nextNode);
                    answer++;
                }
                curNode = nextNode;
            }
        }
        return answer;
    }
    private static ArrayList<Node> makeEdgeList(Node node){
        ArrayList<Node> edge = new ArrayList<>();
        edge.add(node);
        return edge;
    }
    
}
