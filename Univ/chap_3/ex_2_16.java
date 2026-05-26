package Univ.chap_3;
import java.util.*;
public class ex_2_16 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //java 배열 클래스로 .add or ,remove로 사용하기 편함.
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<String> others = new ArrayList<>();

        System.out.print("양의 정수를 입력하세요 >> ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" "); // 문자열로 받아들인 뒤에 공백 기준으로 나누기.

        for(String s : tokens){ // for each 형태로 기존의 for 문 사용 가능/ for each문은 특정 인덱스만 뽑아 쓰는 것 불가능/ 역순 불가능
            try {
                int num = Integer.parseInt(s);

                if(num > 0){
                positives.add(num);
                }
                else{
                    others.add(s + " 음수 제외됨");
                }                
            } catch (NumberFormatException e) {
                
                others.add(s + " 문자열 제외됨");
            }
        }
        System.out.println("*************************");
        if(positives.size() > 0){
            int sum = 0;
            System.out.print("찾은 양수 : ");
            for(int p : positives){
                System.out.print(p + " ");
                sum += p;
            }
            double avg = sum / positives.size();
            System.out.println("평균은 : " + avg);
        }
        else{
            System.out.println("양수가 없습니다.");
        }
        System.out.println("******************************");
        System.out.println("제외된 항목들 : ");
        for(String p : others){
            System.out.print(p + "\n");
        }
        scanner.close();
    }
}