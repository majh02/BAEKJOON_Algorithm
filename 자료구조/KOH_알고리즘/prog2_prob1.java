package 자료구조.KOH_알고리즘;

import java.io.*;
import java.util.*;

class Node{
    String word;
    String word_class;
    String explanation;
    Node leftChild;
    Node rightChild;

    public Node(String word, String word_class, String explanation){
        this.word = word;
        this.word_class = word_class;
        this.explanation = explanation;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree{
    Node rootNode = null;
    
    public void insertNode(String word, String word_class, String explanation){
        if(rootNode==null){
            rootNode = new Node(word, word_class, explanation);
        }
        else{
            Node head = rootNode;
            Node curr;

            while(true){
                curr = head;
                if(head.word.compareTo(word)<0){
                    head = head.leftChild;

                    if(head==null){
                        curr.leftChild = new Node(word, word_class, explanation);
                        break;
                    }
                }
                else{
                    head = head.rightChild;
                    if(head==null){
                        curr.rightChild = new Node(word, word_class, explanation);
                        break;
                    }
                }
            }
        }
    }

    public boolean remove_Node(String word){
        Node removeNode = rootNode;
        Node parent_of_removeNode = null;

        while(!removeNode.word.equals(word)){
            parent_of_removeNode = removeNode;

            if(removeNode.word.compareTo(word)<0){
                removeNode = removeNode.leftChild;
            }
            else{
                removeNode = removeNode.rightChild;
            }

            if(removeNode==null) return false;
        }

        if(removeNode.leftChild==null && removeNode.rightChild==null){
            if(removeNode==rootNode){
                rootNode = null;
            }
            else if(removeNode == parent_of_removeNode.rightChild){
                parent_of_removeNode.rightChild = null;
            }
            else{
                parent_of_removeNode.leftChild = null;
            }
        }
        else if(removeNode.leftChild==null){
            if(removeNode == rootNode){
                rootNode = removeNode.rightChild;
            }
            else if(removeNode == parent_of_removeNode.rightChild){
                parent_of_removeNode.rightChild = removeNode.rightChild;
            }
            else{
                parent_of_removeNode.leftChild = removeNode.rightChild;
            }
        }
        else if(removeNode.rightChild==null){
            if(removeNode == rootNode){
                rootNode = removeNode.leftChild;
            }
            else if(removeNode == parent_of_removeNode.rightChild){
                parent_of_removeNode.rightChild = removeNode.leftChild;
            }
            else{
                parent_of_removeNode.leftChild = removeNode.leftChild;
            }
        }
        else{
            Node parent_of_RepalceNode = removeNode;
            Node replaceNode = parent_of_RepalceNode.rightChild;
            while(replaceNode.leftChild!=null){
                parent_of_RepalceNode = replaceNode;
                replaceNode = replaceNode.leftChild;
            }

            if(replaceNode != removeNode.rightChild){
                parent_of_RepalceNode.leftChild = replaceNode.rightChild;
                replaceNode.rightChild = removeNode.rightChild;
            }
            if(removeNode == rootNode){
                rootNode = replaceNode;
            }
            else if(removeNode == parent_of_removeNode.rightChild){
                parent_of_removeNode.rightChild = replaceNode;
            }
            else{
                parent_of_removeNode.leftChild = replaceNode;
            }

            replaceNode.leftChild = removeNode.leftChild;
        }

        return true;
    }


    // public void preorderTree(Node root, int depth){
    //     if (root != null) {
    //         for (int i = 0; i < depth; i++) {
    //             System.out.print("ㄴ");
    //         }
    //         System.out.println(root.word+", "+root.word_class+", "+root.explanation);
    //         preorderTree(root.leftChild, depth + 1);
    //         preorderTree(root.rightChild, depth + 1);
    //     }
    // }
}

public class prog2_prob1 {
    public static void main(String args[]){
        long beforeTime = System.currentTimeMillis();
        BinaryTree tree = new BinaryTree();
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
                tree.insertNode(word, word_class, explanation);
            }
            br.close();
        }catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }

        // tree.preorderTree(tree.rootNode, 0);

        try{
            File fp2 = new File("C:\\Users\\hi\\Desktop\\Algorithm\\BOJ-Programmers_Algorithm\\자료구조\\KOH_알고리즘\\search_words.txt");
            FileReader fr = new FileReader(fp2);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!=null){
                tree.remove_Node(line);
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
