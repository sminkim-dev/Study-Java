package Java.Univ.Practice_problem;
import java.util.*;
public class _19x19 {
    private Scanner sc = new Scanner(System.in);
    private int [][] board = new int[19][19];
    private int [][] line = new int[19][19];
    // 입력된 X좌표들과 Y좌표들을 각각 모아둘 동적 리스트
    private ArrayList<Integer> xList = new ArrayList<>();
    private ArrayList<Integer> yList = new ArrayList<>();

    public void run(){
        System.out.println("19 x 19 바둑. 십자가 뒤집기...");
        start();
        System.out.print("좌표 개수 >> ");
        int point_nums = sc.nextInt();
        for(int i = 0; i < point_nums; i++){
            System.out.print(i + "번쩨 행과 열 >> ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            save(x, y);
            xList.add(x - 1);
            yList.add(y - 1);
        }
        System.out.println("두 좌표 라인 출력...");
        show2();
        //show();
        saveIntersections();
        System.out.println("교집합 출력...");
        show();
        System.out.println("program exit");
        sc.close();
    }
    public void start(){
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                board[i][j] = 0;
                line[i][j] = 0;
            }
        }
    }
    // ★ 핵심: 입력된 모든 X와 모든 Y의 교차점만 콕 집어서 1로 바꿈
    public void saveIntersections(){
        // 입력된 모든 x값과 모든 y값의 쌍을 서로 교차시킵니다.
        for(int x : xList) {
            // xList > x행의 배열 값이 들어감. ex) 10 , 12
            for(int y : yList) {
                // yList > y행의 배열 값이 들어감. ex) 10 , 12
                board[x][y] = 1; // 교차하는 지점만 1로
                // -> 그럼 4개의 좌표값이 나옴. (10,10)(10,12)(12,10)(12,12) >> 2 x 2 = 4
                // 각 좌표의 교집합만 찾는 것이 아닌, 두 개의 좌표값 모두의 교집합을 찾는 것이기에 값은 4가 됨.
            }
        }
    }
    public void save(int x, int y) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 내가 입력한 좌표의 행(x)이거나 열(y)인 경우에만 "뒤집기"를 수행합니다.
                if (i == x || j == y) {
                    line[i][j] = 1;
                }    
            }
        }
    }
    public void show(){
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void show2(){
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                System.out.print(line[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        new _19x19().run();
    }
}
