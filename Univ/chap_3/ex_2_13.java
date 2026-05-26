package Univ.chap_3;

import java.util.*;
public class ex_2_13 {
    public static class Subject {
        String course [] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade [] = {"A", "B+", "B", "A+", "D"};
        
        void checkingSub(String inputStr){
            for(int i = 0; i < course.length; i++){
                if(inputStr.equals(course[i])){
                    System.out.println(course[i] + " 학점은 " + grade[i]);
                    return;
                }
            }
            System.out.println(inputStr + "는 없는 과목입니다.");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Subject S = new Subject();
        
        while(true){
            System.out.print("과목 >> ");
            String inputSubject = scanner.next();
            if(inputSubject.equals("그만")){
                System.out.println("프로그램 종료합니다.");
                break;
            }
            S.checkingSub(inputSubject);
        }
        scanner.close();
    }
}
