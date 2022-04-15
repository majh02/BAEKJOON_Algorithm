package 자료구조.KOH_알고리즘;

public class fun4 {

    public static void main(String args[]){
        int n=5;
        fun(n);
    }

    public static void fun(int n){
        int i=0;
        if(n>1) fun(n-1);
        for(i=0;i<n;i++){
            System.out.print(" * ");
        }
    }
    
}
