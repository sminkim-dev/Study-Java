package study_Java.chap_2;
import java.util.*;

public class ex_1_8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산 입력 >> ");
        Double first_num = scanner.nextDouble();
        String operation = scanner.next();
        Double second_num = scanner.nextDouble();

        switch (operation) {
            case "더하기": System.out.printf("%.1f %s %.1f의 계산 결과는 %.1f\n",first_num,operation,second_num,first_num+second_num);
                break;
            case "빼기" : System.out.printf("%.1f %s %.1f의 계산 결과는 %.1f\n",first_num,operation,second_num,first_num-second_num);
                break;
            case "곱하기" : System.out.printf("%.1f %s %.1f의 계산 결과는 %.1f\n",first_num,operation,second_num,first_num*second_num);
                break;
            case "나누기" : System.out.printf("%.1f %s %.1f의 계산 결과는 %.1f\n",first_num,operation,second_num,first_num/second_num);
                break;
            default:
                System.out.println("Error, please choose one in four operator and it in textbox");
                System.exit(0);
                break;
        }
        scanner.close();
    }
}
