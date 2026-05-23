package study_Java.chap_4;
// ex_4_10.java 안에 있는 클래스와 동일 이름의 클래스가 존재해서. 주석 처리해서 안 돌리면 jvm이 생성자를 못찾음. 왜냐면 4_10에서 해당 생성자가 존재하기 때문.
import java.util.Scanner;

// 1. 하루의 메모를 저장하는 클래스
class DayDiary {
    private String text;

    public DayDiary() { this.text = "..."; }
    public void setText(String text) { this.text = text; }
    public String getText() { return text; }
}

// 2. 한 달치 다이어리를 관리하는 클래스
class MonthDiary {
    private int year, month;
    private DayDiary[] days; // 30개의 DayDiary 객체를 가질 배열
    private Scanner scanner;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.scanner = new Scanner(System.in);
        this.days = new DayDiary[30]; // 배열 생성
        for (int i = 0; i < days.length; i++) {
            days[i] = new DayDiary(); // 각 날짜별 객체 생성
        }
    }

    // 메뉴를 입력받는 메소드
    private int getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        return scanner.nextInt();
    }

    // 날짜별 일정을 기록하는 메소드
    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int day = scanner.nextInt();
        String text = scanner.next();
        if (day < 1 || day > 30) {
            System.out.println("날짜가 범위를 벗어났습니다.");
        } else {
            days[day - 1].setText(text);
        }
    }

    // 전체 일정을 보여주는 메소드
    private void show() {
        for (int i = 0; i < days.length; i++) {
            System.out.print(days[i].getText() + "\t");
            if ((i + 1) % 7 == 0) System.out.println(); // 7일마다 줄바꿈
        }
        System.out.println();
    }

    // 게임(프로그램)을 실행하는 메인 루프
    public void run() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        while (true) {
            int menu = getMenu();
            if (menu == 1) write();
            else if (menu == 2) show();
            else if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}

public class ex_4_10_origin {
    public static void main(String[]args){
        MonthDiary monthDiary = new MonthDiary(2024, 10);
        monthDiary.run();
    }
}
