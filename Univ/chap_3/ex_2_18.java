package Univ.chap_3;

import java.util.*;
public class ex_2_18 {
    public static class Student{
        int id;
        int score;
        public Student(int id, int score){
            this.id = id;
            this.score = score;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /* ArrayList<Integer> student_ID_Number = new ArrayList<>();
        ArrayList<Integer> student_Test_Point = new ArrayList<>(); */
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("10명의 학생의 학번과 점수 입력");
        for(int i = 0; i < 10; i++){
            while(true){
                try {
                    System.out.print(i + 1 + " >> ");
                    list.add(new Student(scanner.nextInt(), scanner.nextInt()));
                    /* int st_num = scanner.nextInt();
                    int st_point = scanner.nextInt(); */
                    /* student_ID_Number.add(st_num);
                    student_Test_Point.add(st_point); */
                    break;
                } catch (InputMismatchException e) {
                    
                    System.out.println("양의 정수만 입력하여주십시오.");
                    scanner.nextLine();
                }
            }
        }
        while(true){
            try {
                System.out.print("학번으로 검색 : 1 , 점수로 검색 : 2 , 끝내려면 : 3 >> ");
                int select = scanner.nextInt();
                boolean ck = false;
                if(select == 1){
                    System.out.print("학번 >> ");
                    int select_Studen_ID_Number = scanner.nextInt();
                    
                    System.out.print(select_Studen_ID_Number + "의 학생은 ");
                    /* for(int i = 0; i < 10; i++){
                        if(select_Studen_ID_Number == student_ID_Number.get(i)){
                            System.out.print(student_Test_Point.get(i) + " ");
                            ck = true;
                        }
                    } */
                   for(Student s : list){
                    if(s.id == select_Studen_ID_Number){
                        System.out.print(s.score + " 점");
                        ck = true;
                    }
                   }
                    System.out.println(ck ? "입니다." : "없습니다.");
                    /* if(!ck){
                        System.out.println("없습니다.");
                    }
                    else{
                        System.out.println("입니다.");
                    } */
                }

                else if(select == 2){
                    System.out.print("점수 >> ");
                    int select_Student_Point = scanner.nextInt();
                    System.out.print("점수가 " + select_Student_Point + "점인 학생은 ");
                    /* for(int i = 0; i < 10; i++){
                        if(select_Student_Point == student_Test_Point.get(i)){
                            System.out.print(student_ID_Number.get(i) + " ");
                            ck = true;
                        }
                    } */
                   for(Student s : list){
                        if(select_Student_Point == s.score){
                            System.out.print(s.id + " ");
                            ck = true;
                        }
                   }
                    System.out.println(ck ? "입니다." : "없습니다.");
                    /* if(!ck){
                        System.out.print("없습니다.\n");
                    }
                    else{
                        System.out.println("입니다.");
                    } */
                }
                else if(select == 3){
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                }
            } catch (Exception e) {
                
                System.out.println("경고! 정수를 입력하세요.");
                scanner.nextLine();
            }
        }
    }
}
