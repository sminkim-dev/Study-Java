package study_Java.chap_2;
import java.util.Scanner;

public class ex_1_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("$1 = 1200원입니다. 달러를 입력하세요>>> ");
        int dollor = scanner.nextInt();
        int cal = dollor * 1200;

        System.out.print("$" + dollor + "는 " + cal + "원입니다.\n");
        scanner.close();
    }
}
