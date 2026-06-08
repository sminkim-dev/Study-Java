package Univ.Practice_problem;
import java.util.*;

class DataType implements Comparable<DataType>{
    int key;
    String data = "";

    public DataType(){
        key = (int)(Math.random() * 100000);
        for(int i = 0; i < 20; i++){
            data += (char)('a' + (int)(Math.random() * 26)); // data += ((char)(Math.random() * ('z' - 'a')) + 'a');
        }
    }
    @Override
    public int compareTo(DataType other){
        //return this.key - other.key;
        return data.compareTo(other.data); // a - z 순서로 출력 정렬.
    }
    public String toString(){
        return this.key + " : " + this.data;
    }
}
public class minheap {
    public static void main(String [] args){
        PriorityQueue<DataType> minheap = new PriorityQueue<>();
        int n = 100;
        DataType input [] = new DataType[n];

        for(int i = 0; i < n; i++){
            input[i] = new DataType();
            minheap.offer(input[i]);
        }
        for(int i = 0; i < n; i++){
            DataType t = minheap.poll();
            System.out.print(t + " ");
            System.out.println();
        }
        System.out.println();
    }
}
