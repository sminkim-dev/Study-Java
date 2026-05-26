package Univ.chap_3;

import java.util.*;
public class ex_2_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("양의 정수 10개 입력 >> ");

        boolean check = false;
        /*int[] num = new int[10];
        int[] sum = new int[10];*/

        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++){
            numbers[i] =scanner.nextInt();  
        }
        System.out.print("자리수의 합이 9인 것은 >> ");
        for(int i = 0; i < 10; i++){
            int currentSum = 0;
            int temp = 0;
            temp = numbers[i];
            while(temp > 0){
                currentSum += temp % 10;
                temp = temp / 10;

                if(currentSum == 9){
                    System.out.print(numbers[i] + " ");
                    check = true;
                }
            }
        }
        if(!check){
            System.out.print("No exists");
        }
        System.out.println("");
        scanner.close();
    }
}
