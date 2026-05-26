package Univ.chap_3;

import java.util.*;
public class ex_2_11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");
        int count = 0;
        while(true){
            if(count == 3){
                break;
            }
            int first = (int)(Math.random()*9 + 1);
            int second = (int)(Math.random()*9 + 1);
            int powValue = first * second;
            System.out.print(first + " * " + second + " = ");
            int input_powValue = scanner.nextInt();
            if(input_powValue == powValue){
                System.out.println("정답입니다. 잘했습니다.");
            }
            else{
                count ++;
                if(count != 3){
                    System.out.println(count + "번 틀렸습니다. 분발하세요.");
                }
                else{
                    System.out.println(count + "번 틀렸습니다. 퀴즈 종료합니다.");
                }
                
            }
        }
        scanner.close();
    }
}
