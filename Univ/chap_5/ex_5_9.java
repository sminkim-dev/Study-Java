package study_Java.chap_5;

import java.util.Scanner;

class BaseArray{
    protected int array [];
    protected int nextIndex = 0;
    public BaseArray(int size){
        array = new int[size];
    }
    public int length(){return array.length;}
    public void add(int n){
        if(nextIndex == array.length) return;
        array[nextIndex] = n;
        nextIndex++;
    }
    public void print(){
        for(int n : array) System.out.print(n + " ");
        System.out.println();
    }

}
class BinaryArray extends BaseArray{
    private int treshold;
    public BinaryArray(int size, int tresehold){
        super(size);
        this.treshold = tresehold;
    }
    @Override
    public void print(){
        for(int n : array){
            if(n > treshold){
                System.out.print(1 + " ");
            }
            else{
                System.out.print(0 + " ");
            }
        }
    }
}
public class ex_5_9 {
    public static void main(String[] args){
        int tresehold = 50; // 임계값 50
        BinaryArray bArray = new BinaryArray(10, tresehold);
        //bArray 객체는 treshold 보다 크면 1, 아니면 0의 값만 가지는 배열처럼 행동

        Scanner sc = new Scanner(System.in);
        System.out.print(">>");
        for(int i = 0; i < bArray.length(); i++){
            int n = sc.nextInt();
            bArray.add(n);
        }
        bArray.print();
        sc.close();
    }
}
