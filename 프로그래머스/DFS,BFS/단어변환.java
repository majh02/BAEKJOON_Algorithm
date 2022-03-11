//DFS,BFS_3번_단어 변환
import java.util.*;

public class 단어변환 {
    public static void main(String args[]){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int answer;
    public static int solution(String begin, String target, String[] words) {
        answer = 0;

        boolean exist = false;
        for(String word : words){
            if(word.equals(target)) exist = true;
        }
        if(!exist) return 0;

        boolean[] visited = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(words_comparator(begin, words[i])){
                answer = BFS(begin, target, words, i, visited);
                break;
            }
        }

        return answer;
    }
    public static int BFS(String begin, String target, String[] words, int p, boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{p,1});
        visited[p] = true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            String tmp_word = words[tmp[0]];
            int count = tmp[1];
            
            if(tmp_word.equals(target)){
                return count;
            }

            for(int i=0;i<words.length;i++){
                if(words_comparator(tmp_word, words[i]) && !visited[i]){
                    queue.add(new int[]{i,count+1});
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    public static boolean words_comparator(String word1, String word2){
        int count = 0;
        for(int i = 0;i<word1.length();i++){
            if(word1.substring(i, i+1).equals(word2.substring(i, i+1))){
                count++;
            }
        }

        if(word1.length()-count==1) return true;
        return false;
    }
    
}
