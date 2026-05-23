package study_Java.chap_6;
import java.util.*;

public class ex_6_5{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int [] point = {100, 90, 80, 70, 0};
        String [] grade = {"A", "B", "C", "D", "F"};
        
        while(true){
            double sum = 0;
            boolean errorOcuur = false;
            String errorText = "";

            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력 >> ");
            String line = scanner.nextLine();
            if(line.equals("그만")) break;
            
            String [] text = line.split(" ");
            
            for(int i = 0; i < text.length; i++){
                String inputGrade = text[i].toUpperCase();
                boolean found = false;

                for(int b = 0; b < grade.length; b++){
                    if(inputGrade.equals(grade[b])){
                        sum += point[b];
                        found = true;
                        break;
                    }
                }
                if(found == false){
                    errorOcuur = true;
                    errorText = text[i];
                    break;
                }
            }
            if(errorOcuur){
                System.out.println("입력 오류 : " + errorText);
            }
            else System.out.println("평균은 " + sum / text.length);
        }
        scanner.close();;
    }
}