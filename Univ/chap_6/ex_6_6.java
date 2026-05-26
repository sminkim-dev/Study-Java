package Univ.chap_6;
import java.util.*;

class Shift{
    private String line;
    public Shift(String line){this.line = line;}
    public void shift(){
        String first_texture = line.substring(0,1);
        String others = line.substring(1);
        String buildText = others + first_texture;
        line = buildText;
        System.out.println(buildText);
    }
    public void run(){
        for(int i = 0; i < line.length(); i++){
            shift();
        }
    }
}
public class ex_6_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요 >> ");
        String line = scanner.nextLine();
        Shift s = new Shift(line);
        s.run();
        scanner.close();
    }
}
