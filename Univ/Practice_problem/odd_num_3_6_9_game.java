package Java.Univ.Practice_problem;
import java.util.*;

class Game{
    private int end_number;
    public Game(int num){this.end_number = num;}
    public void show(){
        for(int i = 1; i <= end_number; i++){
            String s = String.valueOf(i);
            if(s.contains("3") || s.contains("6") || s.contains("9")){
                int clapCount = 0;
                for (int b = 0; b < s.length(); b++){
                    char c = s.charAt(b);
                    if(c == '3' || c == '6' || c == '9'){
                        clapCount++;
                    }
                }
                System.out.print("짝".repeat(clapCount) + " ");
            }
            else{
                System.out.printf("%d ",i);
            }
            if(i % 10 == 0)System.out.println();
        }
    }
}

public class odd_num_3_6_9_game {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Game Start, Enter the number You want >>> ");
        int number = scanner.nextInt();
        Game g = new Game(number);
        g.show();
        scanner.close();
    }
}
