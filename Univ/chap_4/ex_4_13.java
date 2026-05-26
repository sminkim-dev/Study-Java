package Univ.chap_4;

import java.util.*;
class Group{
    private String type;
    private String [] seats;
    public Group(String type){
        this.type = type;
        this.seats = new String [10];
        for(int i = 0; i < 10; i++){
            seats[i] = "---";
        }
    }

    public void add(String name, int index){
        if(index < 0 || index > 10){
            System.out.println("잘못된 좌석 번호입니다. 1 ~ 10번 까지입니다.");
            return;
        }
        else if(!seats[index - 1].equals("---")){
            System.out.println("이미 예약된 좌석입니다.");
            return;
        }
        seats[index - 1] = name;
    }
    public void cancel(String name){
        boolean found = false;
        for(int i = 0; i < 10; i++){
            if(name.equals(seats[i])){
                seats[i] = "---";
                found = true;
            }
        }
        if(!found) System.out.println("예약자를 찾을 수 없습니다.");
    }
    public void show(){
        System.out.print(type + " >> ");
        for(int i = 0; i < 10; i++){
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }
}

public class ex_4_13 {
    public static void main(String[] agrs){
         Scanner scanner =  new Scanner(System.in);

         Group [] group = new Group[3];
         group[0] = new Group("S");
         group[1] = new Group("A");
         group[2] = new Group("B");

         System.out.println("명품콘서트를 예약 시스템입니다.");

         while(true){
            System.out.print("예약 : 1 , 조회 : 2 , 취소 : 3 , 끝내기 : 4 >> ");
            int menu = scanner.nextInt();

            if(menu == 4) break;

            if(menu == 1){ // 예약
                System.out.print("좌석 구분 S(1), A(2), B(3) >> ");
                int line = scanner.nextInt();
                group[line - 1].show();
                System.out.print("이름 >> ");
                String name = scanner.next();
                System.out.print("번호 >> ");
                int seats = scanner.nextInt();
                group[line - 1].add(name, seats);
            }
            else if(menu == 2){ // 조회
                for(Group g : group) g.show();
                System.out.println("조회를 완료하였습니다.");
            }
            else if(menu == 3){ // 취소
                System.out.print("좌석 구분 S(1), A(2), B(3) >> ");
                int line = scanner.nextInt();
                group[line - 1].show();
                System.out.print("이름 >> ");
                String name = scanner.next();
                group[line - 1].cancel(name);
            }
         }
         scanner.close();
    }
}
