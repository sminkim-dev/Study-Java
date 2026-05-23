package study_Java.chap_2;
import java.util.*;

public class ex_1_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int red_candle = 10;
        final int blue_candle = 5;
        //final int yellow_candle = 1;

        System.out.print("나이를 입력하세요 >> ");
        int age = scanner.nextInt();
        if(age < 0){
            System.out.print("나이는 양수를 입력하세요.\n");
            System.exit(0);
        }
        else{
            int r_candle_piece = age / red_candle;
            int b_candle_piece = (age % red_candle) / blue_candle;
            int y_candle_piece = (age % red_candle) % blue_candle;

            System.out.printf("빨간 초 %d개, 파란 초 %d개, 노란 초 %d개, 총 %d개가 필요합니다.\n",r_candle_piece,b_candle_piece,y_candle_piece,r_candle_piece+b_candle_piece+y_candle_piece);
            scanner.close();
        }
    }
}
