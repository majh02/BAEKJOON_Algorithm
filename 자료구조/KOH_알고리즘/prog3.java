package 자료구조.KOH_알고리즘;

import java.io.*;
import java.util.*;

public class prog3 {
    public static ArrayList<String[]> dict = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String args[]){
        reading_file(); //파일 읽고 dict에 단어와 뜻 저장
        Collections.sort(dict, (o1, o2)-> o1[0].compareTo(o2[0])); //dict 알파벳순 정렬
        
        int size = dict.size();
        for(int i=0;i<size;i++){ //graph: 단어 간 연관성 그래프
            graph.add(new ArrayList<>());
        }
        create_graph(size); //graph에 단어 간 연관성 저장
        
        Answer1(size);
        Answer2(size);
        Answer3(size);
        Answer4(size);

        return;
    }

    public static void reading_file(){ //파일 읽고 dict에 단어와 뜻 저장
        try{
            File fp = new File("C:\\Users\\hi\\Desktop\\Algorithm\\BOJ-Programmers_Algorithm\\자료구조\\KOH_알고리즘\\dict_simplified.txt");
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line, "\t");
                String word = st.nextToken();
                String explanation = st.nextToken();
                dict.add(new String[]{word, explanation});
            }
            br.close();
        }catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void create_graph(int size){ //graph에 단어 간 연관성 저장
        for(int i=0;i<size;i++){
            String explanation = dict.get(i)[1];
            StringTokenizer st = new StringTokenizer(explanation, " ");
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                for(int j=0;j<size;j++){
                    if(token.equals(dict.get(j)[0])){
                        if(i==j) break;
                        if(!graph.get(i).contains(j))
                            graph.get(i).add(j);
                        if(!graph.get(j).contains(i))
                            graph.get(j).add(i);
                        break;
                    }
                    else if(dict.get(j)[0].compareTo(token)>0) //token
                        break;
                }
            }
        }
    }

    public static int count = 0;
    public static void DFS(int size, boolean[][] visited, int index, int depth){ //Answer1
        for(int i : graph.get(index)){
            if(!visited[index][i] && !visited[i][index]){
                visited[index][i] = true;
                visited[i][index] = true;
                count++;
                DFS(size, visited, i, graph.get(i).size());
            }
        }

        return;
    }

    public static int BFS(int size, boolean[] visited, int index){ //Answer3
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            count++;

            for(int i : graph.get(tmp)){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return count;
    }

    public static void BFS2(int size, boolean[] visited, int index, int k){ //Answer4
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{index,0});
        visited[index] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int num = tmp[0];
            int depth = tmp[1];
            if(depth>k) break;
            
            System.out.println(dict.get(num)[0]);
            for(int i : graph.get(num)){
                if(!visited[i]){
                    queue.add(new int[]{i, depth+1});
                    visited[i] = true;
                }
            }
        }
        return;
    }

    public static void Answer1(int size){
        boolean[][] visited = new boolean[size][size];
        int sum = 0;
        for(int i=0;i<size;i++){
            count = 0;
            DFS(size, visited, i, graph.get(i).size());
            sum+=count;
        }

        System.out.println("Answer1: "+size+", "+sum);
    }

    public static void Answer2(int size){
        int max = 0;
        int max_index = 0;
        for(int i=0;i<size;i++){
            if(max<graph.get(i).size()){
                max = graph.get(i).size(); //max: 최대 차수
                max_index = i; //max_index: 최대 차수를 갖는 정점의 인덱스값
            }
        }

        String max_word = dict.get(max_index)[0]; //max_word: dict에서 max_index번째 단어
        System.out.println("Answer2: "+max_word+" "+max);
    }

    public static void Answer3(int size){
        boolean[] visited = new boolean[size];
        int max = 0; //가장 큰 연결요소
        for(int i=0;i<size;i++){
            if(!visited[i]){
                //BFS로 순회한 후 찾은 연결요소 크기값과 max값 비교 후, max에 둘 중 더 큰값을 넣기
                max = Math.max(max, BFS(size, visited, i));
            }
        }

        System.out.println("Answer3: "+max);
    }

    public static void Answer4(int size){
        System.out.print("Answer4: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next(); //찾을 단어 입력
        int k = sc.nextInt(); //탐색 깊이 입력
        sc.close();

        int index = -1;
        for(int i=0;i<size;i++){ //dict에서 입력받은 단어 찾기
            if(dict.get(i)[0].equals(word)){
                index = i;
                break;
            }
        }
        if(index==-1){ //해당 단어가 존재하지 않을 경우
            System.out.println("The word does not exist");
            return;
        }

        boolean[] visited = new boolean[size];
        BFS2(size, visited, index, k); //BFS로 순회하며 연관 단어 출력
    }
    
}
