package Univ.chap_6;

import java.util.Random;
import java.util.Scanner;

public class ex_6_10 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        String[] words = {"happy", "morning", "package", "together", "java", "computer"};
        Random random = new Random();

        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            // 1. 단어 목록 중 하나 랜덤 선택
            int selectedIdx = random.nextInt(words.length);
            String answer = words[selectedIdx];
            
            // 2. 단어 섞기
            char[] scrambled = answer.toCharArray();
            for (int i = 0; i < scrambled.length * 2; i++) {
                int r1 = random.nextInt(scrambled.length);
                int r2 = random.nextInt(scrambled.length);
                char temp = scrambled[r1];
                scrambled[r1] = scrambled[r2];
                scrambled[r2] = temp;
            }

            // 3. 문제 출력 및 시작 시간 기록
            System.out.println(new String(scrambled));
            long startTime = System.currentTimeMillis(); 

            System.out.print(">>");
            String input = scanner.next();

            if (input.equals("그만")) break;

            // 4. 종료 시간 기록 및 경과 시간 계산
            long endTime = System.currentTimeMillis();
            double elapsedTime = (endTime - startTime) / 1000.0; // 초 단위 변환

            // 5. 판정
            if (input.equals(answer)) {
                if (elapsedTime <= 10.0) {
                    System.out.printf("성공!!! %.3f초 경과\n", elapsedTime);
                } else {
                    System.out.printf("실패!!! 10초 초과. %.3f초 경과\n", elapsedTime);
                }
            } else {
                System.out.println("실패!!! " + answer + " 입니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
