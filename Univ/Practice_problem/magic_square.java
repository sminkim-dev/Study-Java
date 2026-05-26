package Java.Univ.Practice_problem;
import java.util.*;
public class magic_square {
    private int [][] matirix;
    private Scanner sc = new Scanner(System.in);
    public void setData(){
        System.out.print("number >> ");
        int n = sc.nextInt();
        matirix = new int[n][n];
    }
    public void cal(){
        int n = matirix.length;
        int row = 0;
        int col = n / 2;
        for(int i = 1; i <= n * n; i++){
            matirix[row][col] = i;
            if(i % n == 0){
                row++;
            } else {
                // 현재 규칙 오른쪽 위 대각선 순환 이미지. 순방향 구성.
                row--;
                col++;
                if(row < 0) row = n - 1; // 행이 음수가 되면 마지막 행으로 이동 // 순환되는 구조를 생각할 것. 튜브 형태로 생각. 아니면, 
                // //random game 만들 때의 mod 연산처럼 생각할 것. 1 2 3 -> 1 2 3 -> 1 2 3 -> 1 2 3
                if(col > n - 1) col = 0; // 열이 n보다 커지면 0으로 이동 즉, 오른쪽으로 계속가다가 끝을 넘어가면 해당 matrix의 첫번째 줄로 이동한단 의미.
            }
        }
    }
    // start example
    // 0 0 0
    // 0 0 0
    // 0 0 0

    // result example
    // 8 1 6
    // 3 5 7
    // 4 9 2
    public void show(){
        for(int i = 0; i < matirix.length; i++){
            for(int j = 0; j < matirix[i].length; j++){
                System.out.print(matirix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void run(){
        setData();
        cal();
        show();
    }
    public static void main(String[] args){
        magic_square ms = new magic_square();
        ms.run();
    }
}
