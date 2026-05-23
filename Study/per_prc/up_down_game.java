package study_Java.per_prc;
import java.util.*;
class game{
    int rand;
    public game(){
        System.out.println("game start");
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        this.rand = (int)(Math.random()*100 + 1);

        while(true){
            
            System.out.print("input >> ");
            int ans = sc.nextInt();
            if(ans == rand){
                System.out.println("정답, 계속하시겠습니까? y / n >> ");
                String sel = sc.next();
                if(sel.equals("y")) continue;
                else{
                    sc.close();
                    break;
                } 
            }
            else if(ans < rand){
                System.out.println("UP");
            }
            else if(ans > rand){
                System.out.println("Down");
            }
        }
    }
};
public class up_down_game {
    public static void main(String[] args){
        game g = new game();
        g.run();
    }
}
