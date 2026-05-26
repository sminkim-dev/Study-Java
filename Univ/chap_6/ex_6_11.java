package Univ.chap_6;
import java.util.*;

class GameblingGame{
    private int player;
    private String [] name;
    public GameblingGame(int player){
        this.player = player;
        this.name = new String[player];
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < player; i++){
            System.out.print(i + 1 + "번째 선수 이름 >> ");
            this.name[i] = sc.next();
        }
        sc.nextLine(); // 버퍼 비우기
        while(true){
            for(int i = 0; i < player; i++){
                System.out.println("[" + this.name[i] + "]:<ENTER>");
                sc.nextLine();
                double [] r_nums = new double[3];
                for(int r = 0; r < 3; r++){
                    r_nums[r] = (int)(Math.random()*3 + 1);
                    System.out.print(" " + r_nums[r] + " ");
                }
                if(r_nums[0] == r_nums[1] && r_nums[1] == r_nums[2]){
                    System.out.print(this.name[i] + "님이 이겼습니다.");
                    sc.close();
                    return;
                }
                else{
                    System.out.print("아쉽군요.\n");
                }
            }
        }
    }
}

public class ex_6_11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("겜블링 게임에 참여할 선수 숫자 >> ");
        int player = scanner.nextInt();
        GameblingGame gbg = new GameblingGame(player);
        gbg.run();
        scanner.close();
    }
}
