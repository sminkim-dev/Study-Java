package Univ.chap_2;
import java.util.*;

public class ex_1_9 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);

        System.out.print("점 (x , y)의 좌표 입력 >> ");
        int point_x = scanner.nextInt();
        int point_y = scanner.nextInt();

        if(10 < point_x && point_x < 200 && 10 < point_y && point_y < 300){
            System.out.printf("(%d,%d)는 사각형 안에 있습니다.\n",point_x,point_y);
        }
        else if((10 == point_x || point_x == 200) && (10 <= point_y && point_y <= 300) ){
            System.out.printf("(%d,%d)는 사각형 선 상에 있습니다.\n",point_x,point_y);
        }
        else if((10 == point_y || point_y == 300) && (10 <= point_x && point_x <= 200)){
            System.out.printf("(%d,%d)는 사각형 선 상에 있습니다.\n",point_x,point_y);
        }
        else{
            System.out.printf("(%d,%d)는 사각형 밖에 있습니다.\n",point_x,point_y);
        }
        scanner.close();
    }
}
