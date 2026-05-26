package Study.per_prc;

import java.util.*;
class Star{
    int column;
    public Star(int column){
        this.column = column;
    }
    public void upToDown(){
        for(int i = 0; i < column; i++){
            for(int b = 0; b <= i; b++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void downToUp(){
        for(int i = column; i > 0; i--){
            for(int b = i; b > 0; b--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void piramid(){
        for(int i = 0; i < column; i++){
            //공백 넣기
            for(int b = column - 1; b > i; b--){
                System.out.print(" ");
            }
            //별 찍기 1 > 3 > 5 ... i = 0 기준 > ((i + 1) * 2) - 1 까지 반복.
            for(int s = 0; s < ((i + 1)*2)-1; s++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void reversePiramid(){
        for(int i = 0; i < column; i++){
            //공백
            for(int b = 0; b < i; b++){
                System.out.print(" ");
            }
            //별 찍기
            for(int s = 0; s < (column - i) * 2 - 1; s++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void diamond(){
        for(int i = 0; i < column; i++){
            for(int b = column - 1; b > i; b--){
                System.out.print(" ");
            }
            for(int s = 0; s < (i + 1) * 2 -1; s++){
                System.out.print("*");
            }
            System.out.println();
        }
        int c = column - 1;
        for(int i = 0; i < c; i++){
            for(int b = 0; b < i + 1; b++){
                System.out.print(" ");
            }
            for(int s = 0; s < (c - i) * 2 - 1; s++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void number_piramid(){
        String nullback = (column >= 10) ? "  " : " ";
        for(int i = 1; i <= column; i++){
            for(int b = column; b > i; b--){
                System.out.print(nullback);
            }
            for(int num = 1; num <= i; num++){
                if(column >= 10 && num < 10){
                    System.out.print(num + " ");
                }
                else{
                    System.out.print(num);
                }
            }
            for(int num = i - 1; num >= 1; num--){
                if(column >= 10 && num < 10){
                    System.out.print(num + " ");
                }
                else{
                    System.out.print(num);
                }
            }
            System.out.println();
        }
    }
}

public class build_star {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("종료를 원하시면 0번을 입력하십시오.");
            System.out.print("열 (Column)을 입력해주십시오 > ");
            int column = scanner.nextInt();
            if(column == 0) break;
            Star s = new Star(column);
            System.out.println("up To Down 별 찍기");
            s.upToDown();
            System.out.println("down To Up 별 찍기");
            s.downToUp();
            System.out.println("piramid 별 찍기");
            s.piramid();
            System.out.println("reverse piramid 별 찍기");
            s.reversePiramid();
            System.out.println("diamond 별 찍기");
            s.diamond();
            System.out.println("숫자로 피라미드 찍기");
            s.number_piramid();
            scanner.close();
        }
        
    }
}
