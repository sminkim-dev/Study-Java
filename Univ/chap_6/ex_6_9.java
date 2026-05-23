package study_Java.chap_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ex_6_9 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("단어>>");
            String word = scanner.next();
            if (word.equals("그만")) break;

            if (word.length() > 5) {
                System.out.println("5글자 이하의 단어를 입력해주세요.");
                continue;
            }

            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) Arrays.fill(board[i], ' ');

            // 1. 단어 배치 (가로, 세로, 대각선 중 랜덤)
            int dir = random.nextInt(3); // 0:가로, 1:세로, 2:대각선
            int startRow, startCol;

            if (dir == 0) { // 가로
                startRow = random.nextInt(5);
                startCol = random.nextInt(5 - word.length() + 1);
                for (int i = 0; i < word.length(); i++) board[startRow][startCol + i] = word.charAt(i);
            } else if (dir == 1) { // 세로
                startRow = random.nextInt(5 - word.length() + 1);
                startCol = random.nextInt(5);
                for (int i = 0; i < word.length(); i++) board[startRow + i][startCol] = word.charAt(i);
            } else { // 대각선 (오른쪽 아래 방향)
                startRow = random.nextInt(5 - word.length() + 1);
                startCol = random.nextInt(5 - word.length() + 1);
                for (int i = 0; i < word.length(); i++) board[startRow + i][startCol + i] = word.charAt(i);
            }

            // 2. 빈칸 랜덤 문자로 채우기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = (char) (random.nextInt(26) + 'a');
                    }
                }
            }

            // 3. 결과 출력
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        scanner.close();
    }
}
