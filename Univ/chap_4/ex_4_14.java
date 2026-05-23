package study_Java.chap_4;

class VArray{
    private int [] array;
    private int count;
    public VArray(int capacity){
        this.array = new int[capacity];
        count = 0;
    }
    public void expand(){
        int [] n_arr = new int [array.length * 2];
        for(int i = 0; i < array.length; i++){
            n_arr[i] = array[i];
        }
        this.array = n_arr;
    }
    public void add(int value){
        if(array.length == count){
            expand();
        }
        array[count] = value;
        count++;
    }
    public void printAll(){
        for(int i = 0; i < count; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void remove(int index){
        if(index >= count) return;
        for(int i = index; i < count - 1; i++){
            array[i] = array[i+1];
        }
        count--;
    }
    public void insert(int index, int value){
        if(index > count) return;
        if(index == count) expand();
        for(int i = count; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        count++;
    }
    public int capacity(){return array.length;}
    public int size(){return count;}
}

public class ex_4_14 {
    public static void main(String[]args){
        VArray v = new VArray(5);
        System.out.println("용량 : " + v.capacity() + " , 저장된 개수 : " + v.size());

        for(int i = 0; i < 7; i++){
            v.add(i);
        }
        System.out.println("용량 : " + v.capacity() + " , 저장된 개수 : " + v.size());
        v.printAll();

        v.insert(3, 100);
        v.insert(5, 200);
        System.out.println("용량 : " + v.capacity() + " , 저장된 개수 : " + v.size());
        v.printAll();

        v.remove(10);
        System.out.println("용량 : " + v.capacity() + " , 저장된 개수 : " + v.size());
        v.printAll();

        for(int i = 50; i < 55; i++){
            v.add(i);
        }
        System.out.println("용량 : " + v.capacity() + " , 저장된 개수 : " + v.size());
        v.printAll();
        System.out.println();
    }
}
