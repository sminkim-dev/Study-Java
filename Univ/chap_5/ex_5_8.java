package study_Java.chap_5;
import java.util.*;

abstract class Box{
    protected int size;
    public Box(int size){
        this.size = size;
    }
    public boolean isEmpty(){return size == 0;}
    public abstract boolean consume();
    public abstract void print();
}
class IngredientBox extends Box{
    private String name;
    public IngredientBox(String name, int size){
        super(size);
        this.name = name;
    }
    @Override
    public boolean consume(){
        if(size > 0){
            size --;
            return true;
        }
        return false;
    }
    @Override
    public void print(){
        System.out.print(name + " ");
        for(int i = 0; i < size; i++){
            System.out.print("*");
        }
        System.out.print(" " + size);
        System.out.println();
    }
    public String getName(){return name;}
}
public class ex_5_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        IngredientBox [] p = new IngredientBox[3];
        p[0] = new IngredientBox("커피", 5);
        p[1] = new IngredientBox("프림", 5);
        p[2] = new IngredientBox("설탕", 5);

        System.out.println("*****청춘 커피 자판기입니다.*****");
        for(IngredientBox box : p){
                box.print();
            }
        while(true){
            System.out.print("다방커피:1, 설탕커피:2, 블랙커피:3, 종료:4 >> "); // 다방은 1:1:1 설탕은 0:1:1 블랙은 0:0:1
            int menu = sc.nextInt();

            if(menu == 4) break;
            boolean success = false;
            if(menu == 1){
                if(!p[0].isEmpty() && !p[1].isEmpty() && !p[2].isEmpty()){
                    p[0].consume();
                    p[1].consume();
                    p[2].consume();
                    for(int i = 0; i < 3; i++){
                        p[i].print();
                    }
                    success = true;
                }
            }
            else if(menu == 2){
                if(!p[1].isEmpty() && !p[2].isEmpty()){
                    p[1].consume();
                    p[2].consume();
                    for(int i = 0; i < 3; i++){
                        p[i].print();
                    }
                    success = true;
                }
            }
            else if(menu == 3){
                if(!p[2].isEmpty()){
                    p[2].consume();
                    for(int i = 0; i < 3; i++){
                        p[i].print();
                    }
                }
            }
            if(!success){
                System.out.println("원료가 부족합니다.");
            }
        }
        sc.close();
    }
}
