package Univ.chap_3;

import java.util.*;
public class ex_2_10 {
    public static void main(){
        Scanner scanner = new Scanner(System.in);

        int [][]arr = new int[4][4];
        System.out.println("4 X 4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for(int i = 0; i < arr.length; i++){
            for(int b = 0; b < arr.length; b++){
                arr[i][b] = (int)(Math.random()*255);
                System.out.print(arr[i][b] + "\t");
            }
            System.out.println("");
        }
        System.out.print("임계값 입력 >> ");
        int limit_value = scanner.nextInt();

        for(int i = 0; i < arr.length; i ++){
            for(int b = 0; b < arr.length; b++){
                if(arr[i][b] > limit_value){
                    arr[i][b] = 255;
                }
                else{
                    arr[i][b] = 0;
                }
                System.out.print(arr[i][b] + "\t");
            }
            System.out.println("");
        }
        scanner.close();
    }
}
