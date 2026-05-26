package Univ.chap_6;
// package study.chap_6;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ex_6_8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. 오늘 날짜 정보 가져오기
        Calendar today = Calendar.getInstance();
        int todayYear = today.get(Calendar.YEAR);
        int todayMonth = today.get(Calendar.MONTH) + 1;
        int todayDay = today.get(Calendar.DATE);
        
        System.out.println("오늘은 " + todayYear + "년 " + todayMonth + "월 " + todayDay + "일");

        while (true) {
            System.out.print("생일 입력(년 월 일)>>");
            String line = scanner.nextLine();
            if (line.equals("그만")) break;

            // 2. StringTokenizer로 입력받은 년, 월, 일 분리
            StringTokenizer st = new StringTokenizer(line, " ");
            if (st.countTokens() != 3) continue; // 입력이 부족하면 다시 입력

            int birthYear = Integer.parseInt(st.nextToken());
            int birthMonth = Integer.parseInt(st.nextToken());
            int birthDay = Integer.parseInt(st.nextToken());

            // 3. 생일 날짜 세팅
            Calendar birth = Calendar.getInstance();
            birth.set(birthYear, birthMonth - 1, birthDay);

            // 4. 날짜 비교 및 계산
            if (birth.after(today)) {
                // 미래의 날짜인 경우
                long diff = birth.getTimeInMillis() - today.getTimeInMillis();
                long days = diff / (24 * 60 * 60 * 1000);
                System.out.println(days + "일 더 살아야 생일이 됩니다.");
            } else {
                // 과거 혹은 오늘인 경우 (힌트 방식 적용)
                int totalDays = 0;

                if (birthYear == todayYear) {
                    // 같은 해인 경우
                    totalDays = today.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) + 1;
                } else {
                    // 생일인 해의 남은 날들 (그 해 전체 일수 - 생일까지의 일수 + 오늘)
                    totalDays = birth.getActualMaximum(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
                    
                    // 사이 연도들의 일수 더하기
                    for (int i = birthYear + 1; i < todayYear; i++) {
                        Calendar temp = Calendar.getInstance();
                        temp.set(Calendar.YEAR, i);
                        totalDays += temp.getActualMaximum(Calendar.DAY_OF_YEAR);
                    }
                    
                    // 올해의 경과일 더하기
                    totalDays += today.get(Calendar.DAY_OF_YEAR) + 1;
                }
                System.out.println("오늘까지 " + totalDays + "일 살아왔습니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
