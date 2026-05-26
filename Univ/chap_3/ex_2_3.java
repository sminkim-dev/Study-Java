package Univ.chap_3;
import java.util.*;

public class ex_2_3 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        
        int integral_number = 0;
        while(true){
            System.out.print("양의 정수 입력 >> ");
            try {
                integral_number = scanner.nextInt();
                if(integral_number < 0){
                    System.out.println("양수를 입력하여 주십시오.");
                    continue;
                }
                else{
                    break;
                }
            } catch (Exception e) {
                
                System.out.println("정수를 입력하여 주십시오.");
                scanner.next();
                continue;
            }
        }
        // 별찍기
        for(int i = 0; i < integral_number; i++){
            for(int b = integral_number; b > i; b--){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        scanner.close();
    }
}
