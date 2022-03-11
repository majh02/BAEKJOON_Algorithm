//DFS,BFS_1번_타겟넘버
//https://fbtmdwhd33.tistory.com/237 참고했음

public class 타겟넘버 {
    public static void main(String args[]){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        DFS(numbers, target, 0, 0);
        return answer;
    }

    public static void DFS(int[] numbers, int target, int i, int sum){
        if(i==numbers.length){
            if(sum==target) {
                answer++;
            }
            return;
        }

        DFS(numbers, target, i+1, sum+numbers[i]);
        DFS(numbers, target, i+1, sum-numbers[i]);
    }
}
