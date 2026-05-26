package Univ.chap_3;

import java.util.*;
public class ex_2_8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 몇 개를 저장하시겠습니까? >> ");
        int array_num = scanner.nextInt();
        int[] array = new int[array_num];
        int arr_sum = 0;
        double arr_avg = 0;

        System.out.print("랜덤한 정수들 >>> ");
        for(int i = 0; i < array_num; i++){
            array[i] = (int)(Math.random()*100);
            System.out.print(array[i] + " ");
            arr_sum += array[i];
        }
        arr_avg = arr_sum / array_num;
        System.out.println("\n평균은 " + arr_avg);

        scanner.close();
    }
}
