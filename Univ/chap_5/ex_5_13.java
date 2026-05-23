package study_Java.chap_5;

import java.util.Scanner;

// 1. 추상 클래스 Calc 정의
abstract class Calc {
    protected int a, b;
    protected String errorMsg = null; // 오류 메시지 저장

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // 각 연산 클래스에서 목적에 맞게 구현할 추상 메소드
    public abstract int calculate();
}

// 2. 각 연산 클래스 구현
class Add extends Calc {
    @Override
    public int calculate() { return a + b; }
}

class Sub extends Calc {
    @Override
    public int calculate() { return a - b; }
}

class Mul extends Calc {
    @Override
    public int calculate() { return a * b; }
}

class Div extends Calc {
    @Override
    public int calculate() {
        if (b == 0) {
            errorMsg = "0으로 나눌 수 없음. 프로그램 종료";
            return 0;
        }
        return a / b;
    }
}

// 3. 실행 클래스 (Calculator)
public class ex_5_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("두 정수와 연산자를 입력하시오>>");
            int a = sc.nextInt();
            int b = sc.nextInt();
            char op = sc.next().charAt(0);

            Calc exp = null; // 부모 타입의 변수 준비

            // 연산자에 맞는 객체 생성 (다형성)
            switch (op) {
                case '+': exp = new Add(); break;
                case '-': exp = new Sub(); break;
                case '*': exp = new Mul(); break;
                case '/': exp = new Div(); break;
            }

            if (exp == null) {
                System.out.println("잘못된 연산자입니다.");
                break;
            }

            exp.setValue(a, b);
            int result = exp.calculate();

            // 오류 발생 시 메시지 출력 후 종료
            if (exp.errorMsg != null) {
                System.out.println(exp.errorMsg);
                break;
            }

            System.out.println("계산 결과 " + result);
        }
        sc.close();
    }
}