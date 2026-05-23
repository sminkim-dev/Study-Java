package study_Java.chap_3;

import java.util.*;
public class ex_2_17 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] Coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int price [] = {3000, 3500, 4000, 4500};
        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
        while(true){
            try {
                System.out.print("주문 >> ");
                String coffee = scanner.next();
                if(coffee.equals("그만")){
                    System.out.println("프로그램 종료");
                    scanner.close();
                    System.exit(0);
                }
                int number = scanner.nextInt();
                boolean check = false;
                for(int i = 0; i < Coffee.length; i++){
                    if(coffee.equals(Coffee[i])){
                        System.out.println("가격은 " + price[i] * number + "원입니다.");
                        check = true;
                    }
                }
                if(!check){
                        System.out.println(coffee + "는(은) 없는 메뉴입니다.");
                    }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                scanner.nextLine();
            }
        }
    }
}
