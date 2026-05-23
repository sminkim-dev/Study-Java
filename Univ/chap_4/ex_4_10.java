/* package study_Java.chap_4;

import java.util.Scanner;

// [Super Class] 모든 기록의 기본형
class Entry {
    protected String text; // 자식 클래스에서 접근 가능하도록 protected

    public Entry() { this.text = "..."; } // 초기값
    public void setText(String text) { this.text = text; }
    public String getText() { return text; }
}

// [Sub Class] 다이어리 전용 기록 (Entry를 상속)
class DayEntry extends Entry {
    public DayEntry() {
        super(); // 부모 생성자 호출 (text를 "..."으로 초기화)
    }
    
    // 부모의 기능을 활용하면서 다이어리에 맞는 출력 형태 제공
    public void print() {
        System.out.print(text + "\t");
    }
}

// [Main Class] 다이어리 운영 로직
 class MonthDiary {
    private DayEntry[] days; // 객체 배열
    private Scanner sc;

    public MonthDiary(int totalDays) {
        sc = new Scanner(System.in);
        days = new DayEntry[totalDays];
        for (int i = 0; i < days.length; i++) {
            days[i] = new DayEntry(); // 객체 배열의 각 칸을 생성 (중요!)
        }
    }

    public void run() {
        System.out.println("***** 2024년 10월 다이어리 *****");
        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3>>");
            int menu = sc.nextInt();

            if (menu == 1) { // 기록
                System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
                int day = sc.nextInt();
                String text = sc.next();
                if (day < 1 || day > 30) System.out.println("날짜 오류!");
                else days[day - 1].setText(text);
            } 
            else if (menu == 2) { // 보기
                for (int i = 0; i < days.length; i++) {
                    days[i].print();
                    if ((i + 1) % 7 == 0) System.out.println(); // 7일마다 줄바꿈
                }
                System.out.println();
            } 
            else if (menu == 3) { // 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
public class ex_4_10 {
    public static void main(String[]args){
        MonthDiary diary = new MonthDiary(30);
        diary.run();
    }
}
 */