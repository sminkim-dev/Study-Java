package Univ.chap_3;

// 2차원 배열 N을 선언하여 출력하는 코드. 행 (Row) * 열 (Column) ex) [3][4] >> 3행 4열
public class ex_2_4 {
    public static void main(String[] agrs){
        int n [][] = {{1,2,3}, {1,2}, {1}, {1,2,3}, {1,2,3,4}};
        for(int i = 0; i < n.length; i++){
            for(int j = 0; j < n[i].length; j++){
                System.out.print(n[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
