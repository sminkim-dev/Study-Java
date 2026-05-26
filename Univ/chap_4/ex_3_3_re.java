/* package Univ.chap_4;

import java.util.*;
class Grade{
    String name;
    int java;
    int web;
    int os;
    public Grade(String name, int java, int web, int os){
        this.name = name;
        this.java = java;
        this.web = web;
        this.os = os;
    }
    public double getAverage(){
        return (java + web + os) / 3;
    }
    public String getName(){
        return name;
    }
}
public class ex_3_3_re {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String tokens[] = null;

        while(true){
            System.out.print("이름, 자바, 웹프, 운영체제 순으로 점수 입력 >> ");
            String input = scanner.nextLine();
            tokens = input.split(" ");
        
            if(tokens.length == 4){
                break;
            }
            else {
                System.out.println("정확히 4개의 항목(이름, 점수 3개)을 입력해야 합니다.");
                // 여기서 return 하거나 다시 입력받게 처리
            }
        }
        
        try {
            String name = tokens[0];
            int java = Integer.parseInt(tokens[1]);
            int web = Integer.parseInt(tokens[2]);
            int os = Integer.parseInt((tokens[3]));

            Grade st = new Grade(name, java, web, os);
            System.out.printf("%s의 평균은 %.0f\n", st.getName(), st.getAverage());
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("이름 점수 점수 점수 순으로 입력해주세요."); // 위에서 if 문으로 막아버려서 catch로 내려올 일 없음.
        }
        catch (NumberFormatException e){
            System.out.println("점수는 숫자로만 입력해주세요."); // split 후에 int로 변환할때 int가 아닐 경우 여기로 옴.
        }
        finally{
            scanner.close();
        }
        
    }
}
 */