package Univ.chap_2;
import java.util.*;

public class ex_1_7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("월을 입력하세요 >> ");
        int get_in_month = scanner.nextInt();

        if(get_in_month < 0 || get_in_month > 12){
            System.out.println("1 ~ 12 까지의 정수를 입력해주세요.");
            System.exit(0);
        }
        else{
            if(get_in_month == 12 || get_in_month == 1 || get_in_month == 2){
                System.out.print("눈 내리는 하얀 겨울\n");
            }
            else if(3 <= get_in_month && get_in_month <= 5){
                System.out.print("따뜻한 봄\n");
            }
            else if(6 <= get_in_month && get_in_month <= 8){
                System.out.println("바다가 즐거운 여름");
            }
            else{
                System.out.println("낙엽이 지는 아름다운 가을");
            }
        }
        scanner.close();
    }
}
