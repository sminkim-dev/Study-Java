package Univ.chap_4;

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
    public String getName(){
        return name;
    }
    public double getAverage(){
        double avg = 0;
        avg = (java + web + os) / 3;
        return avg;
    }
}
public class ex_3_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력 >> ");
        String name = scanner.next();
        int java = scanner.nextInt();
        int web = scanner.nextInt();
        int os = scanner.nextInt();
        Grade st = new Grade(name, java, web, os);
        System.out.println(st.getName() + "의 평균은 " + st.getAverage());
        scanner.close();
    }
}
