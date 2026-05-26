package Univ.chap_2;

import java.util.*;
public class ex_1_12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차 상태 입력 >> ");
        int status = scanner.nextInt();
        int temperatureInCar = (status & 0b00111111);
        // 입력 값으로 이진수를 입력하고 싶을 경우에는 integer.parseInt(status,2); 로 convirt 하면 가능. 십진수 틀에 이진수를 집어넣으면 수식 오류남.
        //ex) 십진수로 0011 1111 을 넣으면 에어컨 온도는 64도가 아닌, 7도가 나옴. 이유 내가 쓴 이진수 표현을 십진수로 받아들여 이걸 이진수로 변환 후 마스크 해놓은 곳에서 걸러지기 때문.
        if((status & 0b10000000) != 0){
            System.out.print("자동차는 달리는 상태이고 ");
        }
        else{
            System.out.print("자동차는 정지 상태이고 ");
        }
        if((status & 0b01000000) != 0){
            System.out.print("에어컨이 켜진 상태이고 ");
        }
        else{
            System.out.print("에어컨이 꺼진 상태이고 ");
        }
        System.out.printf("온도는 %d도이다.\n",temperatureInCar);

        scanner.close();
    }
}
