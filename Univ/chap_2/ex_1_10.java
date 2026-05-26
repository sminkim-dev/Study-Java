package Univ.chap_2;
import java.util.*;

public class ex_1_10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("(x1, y1), (x2, y2)의 좌표 입력 >> ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        //(10, 10), (200, 300) 사각형에 포함되야 함.
        if((x1 + x2 <= 210) && (y1 + y2 <= 310)){
            System.out.printf("(%d, %d) (%d, %d) 사각형은 (%d, %d) (%d, %d) 사각형에 포함된다.\n",x1,y1,x2,y2,10, 10, 200, 300);
        }
        else{
            System.out.printf("(%d, %d) (%d, %d) 사각형은 (%d, %d) (%d, %d) 사각형에 포함되지 않는다.\n",x1,y1,x2,y2,10, 10, 200, 300);
        }
        scanner.close();
    }
}
