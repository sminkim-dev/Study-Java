package study_Java.chap_6;
import java.util.*;

class MyCalendar {
    private Calendar cal;

    public MyCalendar() {
        this.cal = Calendar.getInstance();
    }

    // 연도와 월을 받아서 달력을 출력하는 추가 기능(메소드)
    public void print(int year, int month) {
        cal.set(year, month, 1); // 해당 월 1일로 세팅
        
        int startDay = cal.get(Calendar.DAY_OF_WEEK); // 시작 요일
        int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 마지막 날

        System.out.println("\n" + year + "년 " + (month + 1) + "월");
        System.out.println("일 월 화 수 목 금 토");

        // 공백 및 날짜 출력 로직 (여기에 작성)
        for (int i = 1; i < startDay; i++) System.out.print("   ");
        for (int i = 1; i <= lastDate; i++) {
            System.out.printf("%2d ", i);
            if ((i + startDay - 1) % 7 == 0) System.out.println();
        }
        System.out.println();
    }
}

public class ex_6_7 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        MyCalendar myCal = new MyCalendar(); // 직접 만든 클래스 사용

        while (true) {
            System.out.print("년도 입력(-1이면 종료)>>");
            int year = scanner.nextInt();
            if (year == -1) break;

            for (int i = 0; i < 12; i++) {
                myCal.print(year, i);
            }
        }
        scanner.close();
    }
}
