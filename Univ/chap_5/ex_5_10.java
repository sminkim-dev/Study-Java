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
class StoredArray extends BaseArray{
    public StoredArray(int size){
        super(size);
    }
    @Override
    public void print(){
        for(int i = 0; i < array.length; i++){
            for(int b = i; b < array.length - 1; b++){
                if(array[b] > array[b + 1]){
                    int temp = array[b];
                    array[b] = array[b+1];
                    array[b+1] = temp;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
public class ex_5_10 {
    public static void main(String[]args){
        StoredArray sArray = new StoredArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for(int i = 0; i <sArray.length(); i++){
            int n = scanner.nextInt();
            sArray.add(n);
        }
        sArray.print();
        scanner.close();
    }
}
