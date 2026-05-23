package study_Java.chap_2;
import java.util.Scanner;
//import static java.lang.Math.*;

public class ex_1_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /* System.out.print("생일 입력하세요 >>> ");
        int birthDay = scanner.nextInt();
        // 20010316
        int year = birthDay / 10000;
        int month = (birthDay % 10000) / 100;
        int day = birthDay % 100; */
        System.out.print("생일을 입력하세요 >>> ");
        String data = scanner.next();
        String year = data.substring(0, 4);
        String month = data.substring(4,6);
        String day = data.substring(6, 8);
        

        System.out.println(year + "년" + month + "월" + day + "일");
        scanner.close();
    }
}
