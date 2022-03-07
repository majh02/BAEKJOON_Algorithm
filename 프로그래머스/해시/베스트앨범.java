//해시_4번_베스트앨범
//https://junghn.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94-%ED%95%B4%EC%8B%9C 참고했음
import java.util.*;

public class 베스트앨범 {
    public static void main(String args[]){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        ArrayList<Integer> answer_arr = new ArrayList<>();
        ArrayList<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (o1,o2)->(map.get(o2).compareTo(map.get(o1))));
        for(String Genre : genreList){
            HashMap<Integer, Integer> hsmap = new HashMap<>();
            for(int i=0;i<genres.length;i++){
                if(Genre.equals(genres[i])){
                    hsmap.put(i, plays[i]);
                }
            }
            ArrayList<Integer> music = new ArrayList<>(hsmap.keySet());
            Collections.sort(music, (o1,o2)->(hsmap.get(o2).compareTo(hsmap.get(o1))));
            int count = 0;
            for(int key : music){
                if(count==2) break;
                answer_arr.add(key);
                count++;
            }
        }

        answer = new int[answer_arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = answer_arr.get(i);
        }

        return answer;
    }
}
