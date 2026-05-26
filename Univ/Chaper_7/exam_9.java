package Univ.Chaper_7;
import java.util.*;

abstract class Shape{
    private Shape next; // 다음 도형을 가리키는 포인터, 지금은 vector을 사용해서 생략해도 됨
    public Shape() {next = null;}
    public void setNext(Shape obj){next = obj;}
    public Shape getNext(){return next;}

    // 중요 , 도형마다 그리는 방식이 다르니, 직접 구현해라.
    public abstract void draw();
}
class Line extends Shape{
    @Override
    public void draw(){
        System.out.println("Line");
    }
}
class Rect extends Shape{
    @Override
    public void draw(){
        System.out.println("Rect");
    }
}
class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}
public class exam_9 {
    private Vector<Shape> v = new Vector<>();
    private Scanner sc = new Scanner(System.in);
    public void run(){
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while(true){
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            int sel = sc.nextInt();
            if(sel == 4) break;
            if(sel == 1){
                insert();
            }
            else if(sel == 2){
                remove();
            }
            else if(sel == 3){
                showAll();
            }
            else{
                System.out.println("다시 입력하십시오.");
                sc.next();
            }
        }
        System.out.println("Beauty Graphic Editor를 종료합니다.");
        sc.close();
    }
    public void insert(){
        System.out.print("Line(1), Rect(2), Circle(3) >> ");
        int sel = sc.nextInt();
        if(sel == 1){
            v.add(new Line());
        }
        else if(sel == 2){
            v.add(new Rect());
        }
        else if(sel == 3){
            v.add(new Circle());
        }
        else{
            System.out.println("다시 입력하십시오.");
            sc.next();
        }
    }
    public void remove(){
        System.out.println("삭제할 도형의 위치 >> ");
        int index = sc.nextInt();
        int target = index - 1;
        if(target < 0 || target >= v.size()){
            System.out.println("삭제할 수 없습니다.");
        }
        else{
            v.remove(target);
        }
    }
    public void showAll(){
        for(int i = 0; i < v.size(); i++){
            Shape s = v.get(i);
            s.draw();
        }
    }
    public static void main(String [] args){
        exam_9 e = new exam_9();
        e.run();
    }
}
