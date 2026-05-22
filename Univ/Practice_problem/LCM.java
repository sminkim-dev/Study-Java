package Java.Univ.Practice_problem;
import java.util.*;
class cal_LCM{
    private int num1,num2;
    public cal_LCM(){this.num1 = 1; this.num2 = 1;}
    public void setNum(int num1, int num2){this.num1 = num1; this.num2 = num2;}
    public int Cal_lcM(){
        // Least common multiple
        int limit = (num1 > num2) ? num1 : num2;
        int GCD = 1;
        for(int i = limit; i > 0; i--){
            if(num1 % i == 0 && num2 % i == 0){
                GCD = i;
                break;
            }
        }
        // a x b = GCD x LCM
        int value_LCM = (num1 * num2) / GCD;
        return value_LCM;
    }
}

public class LCM {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Find of Least common muliple >>> ");
            try {
                int num1 = scanner.nextInt();
                if (num1 == 0) break;
                int num2 = scanner.nextInt();
                if (num2 == 0) break;
                cal_LCM cL = new cal_LCM();
                cL.setNum(num1, num2);
                int value = cL.Cal_lcM();
                System.out.println("value of Least Common Multiple : " + value);
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하여주십시오.");
                scanner.nextLine();
            }
        }
        System.out.println("Program exit");
        scanner.close();
    }
}
