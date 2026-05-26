package Univ.chap_2;
import java.util.*;

public class ex_1_3 {
    public static void main(String[] srgs){
        Scanner scanner = new Scanner(System.in);
        System.out.println("****자바 분식입니다. 주문하면 금액을 알려드립니다.");
        System.out.print("떡볶이 몇 인분 >> ");
        int duck = scanner.nextInt();
        System.out.print("김말이 몇 인분 >> ");
        int kim = scanner.nextInt();
        System.out.print("쫄면 몇 인분 >> ");
        int noodle = scanner.nextInt();

        int sum = (duck*2000) + (1000*kim) + (3000*noodle);

        System.out.println("전체 금액은 " + sum + "원입니다.");
        scanner.close();
    }
}
