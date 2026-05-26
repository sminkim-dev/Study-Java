package Univ.chap_3;

public class ex_2_9 {
    public static void main(String[] args){
        //int arr[][] = {{0,0,0,0,}, {0,0,0,0,}, {0,0,0,0}, {0,0,0,0}};
        int [][] arr = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int b = 0; b < 4; b++){
                arr[i][b] = (int)(Math.random()*255);
            }
        }
        System.out.println("4 X 4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for(int i = 0; i < 4; i++){
            for(int b = 0; b < 4; b++){
                System.out.print(arr[i][b] + "\t");
            }
            System.out.println("");
        }
    }
}
