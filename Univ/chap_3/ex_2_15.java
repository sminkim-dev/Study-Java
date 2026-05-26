package Univ.chap_3;

import java.util.*;
public class ex_2_15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("곱하고 하는 정수 2개 입력 >> ");
            try {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                System.out.println(n + " X " + m + " = " + n*m);
                break;
            } catch (Exception e) {
                
                System.out.println("정수를 입력하세요!");
                scanner.nextLine(); // 잘못된 값이 버퍼 안에 저장되어 있어서 안지워주면 루프로 올라가자마자 바로 catch로 내려와서 무한반복됨.
                continue;
            }
        }
        scanner.close();
    }
}
