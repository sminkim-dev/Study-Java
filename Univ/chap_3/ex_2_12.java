package study_Java.chap_3;

import java.util.*;

public class ex_2_12 {
    public static class sex_name{
        String boyMiddleList [] = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
        String boyLastList [] = {"태","진", "광", "혁", "우", "철", "반", "준", "구", "호", "석"};
        String girlMiddleList [] = {"진", "영", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};
        String girlLastList [] = {"진","연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};

        void generate(String f_name, String[] MiddleList, String[] LastList){
            int index1 = (int)(Math.random()*MiddleList.length);
            int index2 = (int)(Math.random()*LastList.length);
            String middle = MiddleList[index1];
            String last = LastList[index2];
            System.out.println("추천 이름 : " + f_name + middle + last);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        sex_name a = new sex_name();
        System.out.println("***** 직명 프로그램이 실행됩니다. *****");
        while(true){
            System.out.print("남 / 여 선택 >> ");
            String sex = scanner.next();
            if(sex.equals("남")){
                System.out.print("성 입력 >> ");
                String first_name = scanner.next();
                a.generate(first_name, a.boyMiddleList, a.boyLastList);
                continue;
            }
            else if(sex.equals("여")){
                System.out.print("성 입력 >> ");
                String first_name = scanner.next();
                a.generate(first_name, a.girlMiddleList, a.girlLastList);
                continue;
            }
            else if(sex.equals("그만")){
                System.out.println("프로그램 종료합니다.");
                break;
            }
            else{
                System.out.println("남/여, 그만 중에서 입력하세요.");
            }
        }
        scanner.close();
    }
}
