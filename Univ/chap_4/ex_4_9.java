package Univ.chap_4;

import java.util.*;
class Person{
    int score;
    String name;
    public Person(String name){
        this.name = name;
    }
    public String getName(){return name;}
    public int getScore(){return score;}
    public void addscore(){score++;}
}

public class ex_4_9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("예측 게임을 시작합니다.");
        System.out.print(("게임에 참여할 선수 >> "));
        int player = scanner.nextInt(); // 동적으로 할당 받기 위한 크기 입력받기

        Person [] person = new Person[player]; // 입력 받은 크기를 토대로 동적으로 객체 배열 할당하기.
        for(int i = 0; i < player; i++){
            System.out.print("선수 이름 >> ");
            String name = scanner.next();
            person[i] = new Person(name); // 동적으로 할당한 객체 배열, 객체 생성하기
        }
        while(true){
            int hiddenNumber = (int)(Math.random()*100 + 1); // 1~ 100 랜덤수. >> 0~ 99 (100개) + 1 >> 1 ~ 100
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞춰보세요.");
            
            int guess [] = new int [player]; // 입력한 정수를 받을 int형 동적 할당 배열.
            for(int i = 0; i < player; i ++){
                System.out.print(person[i].getName() + " >> "); // 각 객체의 이름을 가져옴.
                guess[i] = scanner.nextInt(); // 할당 받은 배열 안에 순서대로 입력 값 저장.
            }

            int winIdx = 0; // 초기 값 0
            int minDiff = Math.abs(hiddenNumber - guess[0]); // 일단 아무나 세운 뒤에 반복문으로 하나하나 검사해서 변경해 나갈 것임.

            for(int i = 0; i < player; i++){
                int diff = Math.abs(hiddenNumber - guess[i]); // 찾는 과정.
                if(diff < minDiff){
                    minDiff = diff;
                    winIdx = i;
                }
            }

            person[winIdx].addscore();
            System.out.println("정답은 " + hiddenNumber + ". " + person[winIdx].getName() + "이 이겼습니다. 승점 1점 확보!");

            System.out.print("계속하려면 yes 입력 >> ");
            String ans = scanner.next();
            if (ans.equals("yes")) continue;
            else if(ans.equals("no")){
                int high = 0;
                for(int i = 0; i < player; i++){
                    System.out.print(person[i].getName() + " : " + person[i].getScore() + " ");
                }
                System.out.println();
                for(int i = 0; i < player; i ++){
                    if(person[i].getScore() > high){
                        high = person[i].getScore();
                    }
                }
                String winner = "";
                for(int i = 0; i < player; i ++){
                    if(high == person[i].getScore()){
                        if(!winner.equals("")) winner += ", ";
                        winner += person[i].getName();
                    }
                }
                System.out.println(winner + "이 최종 승리하였습니다.");
                scanner.close();
                System.exit(0);
            }
            else{
                while(true){
                    System.out.println("yes / no 둘 중에 하나만 입력해주십시오.");
                    System.out.print("입력 >> ");

                    ans = scanner.next();
                    if(ans.equals("yes")){
                        break;
                    }
                    else if(ans.equals("no")){
                        int high = 0;
                        for(int i = 0; i < player; i++){
                            System.out.print(person[i].getName() + " : " + person[i].getScore() + " ");
                        }
                        System.out.println();
                        for(int i = 0; i < player; i ++){
                            if(person[i].getScore() > high){
                                high = person[i].getScore();
                            }
                    }
                    String winner = "";
                    for(int i = 0; i < player; i ++){
                        if(high == person[i].getScore()){
                            if(!winner.equals("")) winner += ", ";
                            winner += person[i].getName();
                        }
                    }
                    System.out.println(winner + "이 최종 승리하였습니다.");
                    scanner.close();
                    System.exit(0);
                    }
                }
            }
        }
    }
}