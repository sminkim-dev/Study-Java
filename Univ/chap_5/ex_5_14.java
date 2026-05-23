package study_Java.chap_5;

import java.util.Scanner;

// 1. 추상 클래스 Shape (기차의 칸 역할)
abstract class Shape {
    private Shape next;
    public Shape() { next = null; }
    public void setNext(Shape obj) { next = obj; } // 다음 칸 연결
    public Shape getNext() { return next; }        // 다음 칸 가져오기
    public abstract void draw();                   // 도형 그리기(이름 출력)
}

// 2. 구체적인 도형 클래스들
class Line extends Shape {
    @Override
    public void draw() { System.out.println("Line"); }
}

class Rect extends Shape {
    @Override
    public void draw() { System.out.println("Rect"); }
}

class Circle extends Shape {
    @Override
    public void draw() { System.out.println("Circle"); }
}

// 3. 메인 실행 클래스 (파일 이름과 동일해야 함)
public class ex_5_14 {
    private Shape start = null; // 기차의 맨 앞
    private Shape last = null;  // 기차의 맨 뒤
    private Scanner sc = new Scanner(System.in);

    // [삽입] 새로운 도형을 맨 뒤에 붙이기
    public void insert(int type) {
        Shape obj = null;
        switch (type) {
            case 1: obj = new Line(); break;
            case 2: obj = new Rect(); break;
            case 3: obj = new Circle(); break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        if (start == null) { // 기차에 아무것도 없을 때
            start = obj;
            last = obj;
        } else { // 마지막 칸 뒤에 연결
            last.setNext(obj);
            last = obj;
        }
    }

    // [삭제] 특정 위치의 도형 제거
    public void delete(int index) {
        Shape curr = start;
        Shape prev = start;

        if (start == null) {
            System.out.println("삭제할 수 없습니다. (리스트가 비어있음)");
            return;
        }

        // 인덱스 위치까지 이동
        for (int i = 1; i < index; i++) {
            prev = curr;
            curr = curr.getNext();
            if (curr == null) {
                System.out.println("삭제할 수 없는 위치입니다.");
                return;
            }
        }

        if (curr == start) { // 첫 번째 칸을 지울 때
            start = start.getNext();
        } else { // 중간이나 마지막 칸을 지울 때
            prev.setNext(curr.getNext());
        }
        
        // 마지막 칸을 지웠다면 last 포인터 갱신
        if (curr == last) {
            last = prev;
        }
    }

    // [모두 보기] 기차의 처음부터 끝까지 출력
    public void printAll() {
        Shape curr = start;
        while (curr != null) {
            curr.draw();
            curr = curr.getNext();
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int menu = sc.nextInt();
            if (menu == 4) break;

            switch (menu) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>>");
                    delete(sc.nextInt());
                    break;
                case 3:
                    printAll();
                    break;
            }
        }
        System.out.println("Beauty Graphic Editor를 종료합니다.");
    }

    public static void main(String[] args) {
        // 객체 생성 후 실행
        ex_5_14 editor = new ex_5_14();
        editor.run();
    }
}