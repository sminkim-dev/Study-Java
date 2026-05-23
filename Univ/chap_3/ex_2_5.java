package study_Java.chap_3;

import java.util.*;
public class ex_2_5 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        int n[] = {0,0,0,0,0,0,0,0,0,0};
        boolean check = false;

        System.out.print("양의 정수 10개를 입력 >> ");

        try {
            for(int i = 0; i < 10; i++){
            n[i] = scanner.nextInt();
        }
        System.out.print("3의 배수는 >> ");
        for(int i = 0; i < 10; i++){
            if(n[i] % 3 == 0){
                check = true;
                System.out.print(n[i] + " ");
            }
        }
        if(check == false){
                System.out.print("3의 배수가 없습니다.\n");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("양수를 입력하여 주십시오. > exit");
        }

        
        scanner.close();
    }
}
