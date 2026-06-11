package Univ.Practice_problem;
import java.util.*;
public class BST {
    private TreeSet<Integer> treeSet = new TreeSet<>();
    public void run(){
        for(int i = 0; i < 20; i++){
            treeSet.add((int)(Math.random()*30));
        }
        for(Integer t : treeSet){
            System.out.print(t + " ");
        }
        System.out.println();
    }
    public static void main(String [] args){
        new BST().run();
    }
}
