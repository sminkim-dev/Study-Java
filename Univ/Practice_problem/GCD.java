package Univ.Practice_problem;
import java.util.*;

class cal_GCD{
    private int num1, num2;
    public cal_GCD(){this.num1 = 1; this.num2 = 1;}
    public void setNum(int num1,int num2){this.num1 = num1; this.num2 = num2;}
    public int gcd(){
        int limit = (num1 > num2) ? num2 : num1;
        for(int i = limit; i > 0; i--){
            if(num1 % i == 0 && num2 % i == 0){
                return i;
            }
        }
        return 0;
    }
}

public class GCD {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("find of Greatest Common Divisor >>> ");
            try {
                int num1 = scanner.nextInt();
                if(num1 == 0) break;
                int num2 = scanner.nextInt();
                if(num2 == 0) break;
                cal_GCD cG = new cal_GCD();
                cG.setNum(num1, num2);
                int value = cG.gcd();
                System.out.println("value of Greatest Common Divisor : " + value);
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하여주십시오.");
                scanner.next();
            }
        }
        System.out.println("Program exit");
        scanner.close();
    }
}
