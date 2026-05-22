package Java.Univ.Chaper_7;
import java.util.*;
public class exam_1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        System.out.print("정수 입력(-1이면 입력 끝) >>> ");
        String [] line = scanner.nextLine().split(" ");
        
        int min = Integer.MAX_VALUE;
        for(String token : line){
            try {
                int num = Integer.parseInt(token);
                if(num == -1) break;
                v.add(num);

                if(min > num){
                    min = num;
                }
            } catch (NumberFormatException e) {
                // 숫자가 아닌 것은 무시
            }
        }
        if(v.isEmpty()){
            System.out.println("입력된 값이 없습니다.");
        }
        else{
            System.out.println("제일 작은 수는 " + min);
        }
        scanner.close();
    }
}
