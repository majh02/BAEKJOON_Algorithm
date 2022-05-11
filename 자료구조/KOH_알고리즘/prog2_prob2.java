package 자료구조.KOH_알고리즘;

import java.io.*;
import java.util.*;

public class prog2_prob2 {
    public static void main(String args[]){
        long beforeTime = System.currentTimeMillis();
        ArrayList<String[]> list = new ArrayList<>();
        try{
            File fp = new File("C:\\Users\\hi\\Desktop\\Algorithm\\BOJ-Programmers_Algorithm\\자료구조\\KOH_알고리즘\\shuffled_dict.txt");
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line, " ");
                String word = st.nextToken();
                String word_class = st.nextToken();
                String explanation = "";
                while(st.hasMoreTokens()){
                    explanation+=(st.nextToken()+" ");
                }
                list.add(new String[]{word, word_class, explanation});
            }
            br.close();
        }catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }

        try{
            File fp2 = new File("C:\\Users\\hi\\Desktop\\Algorithm\\BOJ-Programmers_Algorithm\\자료구조\\KOH_알고리즘\\search_words.txt");
            FileReader fr = new FileReader(fp2);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!=null){
                for(int i=0;i<list.size();i++){
                    if(list.get(i)[0].equals(line)){
                        list.remove(i);
                        System.out.println(list.get(i)[0]+", "+line+", "+list.size());
                        break;
                    }
                }
            }
            br.close();
        }catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }

        long afterTime = System.currentTimeMillis();
        long diff = (afterTime-beforeTime);
        System.out.println(diff+"ms");
    }  
}
