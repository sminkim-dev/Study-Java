package study_Java.chap_2;
import java.util.*;

public class ex_1_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final int perception = 3;
        final int absense  = 8;

        System.out.print("학생1 >> ");
        String name1 = scanner.next();
        int p1 = scanner.nextInt();
        int a1 = scanner.nextInt();
        
        System.out.print("학생2 >> ");
        String name2 = scanner.next();
        int p2 = scanner.nextInt();
        int a2 = scanner.nextInt();

        int total_student1 = ((p1 * perception) + (a1 * absense));
        int total_student2 = ((p2 * perception) + (a2 * absense));
        System.out.printf("%s의 감점은 %d, %s의 감점은 %d\n",name1,total_student1,name2,total_student2);
        if(total_student1 < total_student2){
            System.out.printf("%s의 출석 점수가 더 높음. %s 출석 점수는 %d\n",name1,name1, 100 - total_student1);
        }
        else{
            System.out.printf("%s의 출석 점수가 더 높음. %s 출석 점수는 %d\n",name2,name2, 100 - total_student2);
        }
        scanner.close();
    }
}
