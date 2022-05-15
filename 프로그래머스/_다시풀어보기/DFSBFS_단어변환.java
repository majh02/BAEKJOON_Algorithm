package 프로그래머스._다시풀어보기;

import java.util.*;

public class DFSBFS_단어변환 {
    public static void main(String args[]){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean flag = false;
        for(String word : words){
            if(word.equals(target)) flag = true;
        }
        if(!flag) return 0;

        flag = BFS(begin, target, words);
        if(flag) answer = result;

        return answer;
    }

    public static int result = 0;
    public static boolean BFS(String begin, String target, String[] words){
        Queue<String[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new String[]{begin, "0"});

        while(!queue.isEmpty()){
            String[] tmp = queue.poll();
            String origin = tmp[0];
            result = Integer.parseInt(tmp[1]);
            if(origin.equals(target)){
                return true;
            }
            for(int i=0;i<words.length;i++){
                if(word_comparator(origin, words[i]) && !visited[i]){
                    visited[i] = true;
                    queue.add(new String[]{words[i], Integer.toString(result+1)});
                }
            }
        }

        return false;
    }

    public static boolean word_comparator(String origin, String compare){
        int count = 0;
        for(int i=0;i<origin.length();i++){
            if(origin.charAt(i)!=compare.charAt(i)) count++;
        }

        if(count==1) return true;
        return false;
    }
    
}
