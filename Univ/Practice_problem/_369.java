package Univ.Practice_problem;
import java.util.*;
public class _369 {
    private Scanner sc = new Scanner(System.in);
    public void run(){
        System.out.print(">> ");
        int num = sc.nextInt();

        for(int i = 1; i <= num; i++){
            int cnt = 0;
            for(int j = 1; j <= num; j*=10){
                if((i/j) % 10 == 3 ||
                    (i/j) % 10 == 6 ||
                    (i/j) % 10 == 9){
                        cnt++;
                    }
            }
            if(cnt == 0){
                System.out.print(i + " ");
            }
            else{
                for(int j = 0; j < cnt; j++){
                    System.out.print("짝");
                }
                System.out.print("(" + i + ") ");
            }
            if(i%10 == 0) System.out.println();
        }
        System.out.println();
        sc.close();
    }
    public static void main(String [] args){
        new _369().run();
    }
}
