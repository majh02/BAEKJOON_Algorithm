package 프로그래머스.카카오;

import java.util.*;

public class 신규아이디추천 {
    public static void main(String args[]){
        String new_id = "=.=";
        System.out.println(solution(new_id));
    }
    public static String solution(String new_id) {
        String answer = "";
        ArrayList<Character> id = new ArrayList<>();
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            id.add(c);
        }
        
        int stage = 1;
        int length = new_id.length();
        for(stage = 1;stage<8;stage++){
            int count = 0;
            
            if(stage==5){
                if(id.size()==0){
                    for(int i=0;i<length;i++){
                        id.add('a');
                    }
                }
                continue;
            }
            else if(stage==6){
                while(id.size()>=16){
                    id.remove(id.size()-1);
                }
                if(id.get(id.size()-1)=='.'){
                    id.remove(id.size()-1);
                } 
                continue;
            }
            else if(stage==7 && id.size()<=2){
                char c = id.get(id.size()-1);
                while(id.size()<=2){
                    id.add(c);
                }
            }
            for(int i=0;i<id.size();i++){
                char c = id.get(i);
                System.out.println("stage : "+stage +", i: "+i+" "+ id);
                if(stage==1 && c>='A' && c<='Z'){ //대문자->소문자
                    c = (char)(c-'A'+'a');
                    id.add(i,c);
                    id.remove(i+1);
                }
                else if(stage==2){ //특수문자 빼기
                    if((c>='a'&& c<='z') || (c>='0'&&c<='9') || (c=='.' || c=='-' || c=='_')){
                        count = 0;
                        continue;
                    }
                    else {
                        id.remove(i);
                        i-=1;
                    }
                }
                else if(stage==3 || stage==4){
                    if(id.get(id.size()-1)=='.'){
                        id.remove(id.size()-1);
                    }
                    if(id.size()==0) break;
                    if(c=='.'){
                        if(i==0 || i==id.size()-1){
                            id.remove(i);
                            i-=1;
                        }
                        else if(count==0) count++;
                        else if(count>=1){
                            id.remove(i);
                            i=-1;
                            count=0;
                        }
                    }
                    else count=0;
                }
            }
        }
        
        for(int i=0;i<id.size();i++){
            answer+=id.get(i);
        }
        
        return answer;
    }
}
