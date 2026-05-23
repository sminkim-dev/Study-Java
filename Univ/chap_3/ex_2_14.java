package study_Java.chap_3;

import java.util.*;
public class ex_2_14 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 겜블링 게임을 시작합니다. *****");

        while (true) {
            System.out.print("Enter key 입력 >> ");
            String nul = scanner.nextLine(); // 엔터 감지

            if (nul.equals("")) {
                int n1 = (int)(Math.random() * 3);
                int n2 = (int)(Math.random() * 3);
                int n3 = (int)(Math.random() * 3);
                System.out.println(n1 + " " + n2 + " " + n3);

                if (n1 == n2 && n2 == n3) {
                    System.out.println("성공! 대박났어요!");
                    
                    // 당첨 시 계속 여부를 묻는 별도의 루프
                    while (true) {
                        System.out.print("계속하시겠습니까? (Yes / No) >> ");
                        String ans = scanner.nextLine(); // 여기서도 nextLine() 사용

                        if (ans.equalsIgnoreCase("No")) {//대/소 문자 관계없이 찾아냄.
                            System.out.println("게임을 종료합니다.");
                            scanner.close(); // 스캐너 닫기
                            return; // 프로그램 아예 종료
                        } else if (ans.equalsIgnoreCase("Yes")) {
                            break; // 안쪽 while을 빠져나가서 다시 게임 시작
                        } else {
                            System.out.println("잘못된 입력입니다. Yes 또는 No로 입력해주세요.");
                            // break를 안 했으므로 다시 질문을 던짐
                        }
                    }
                }
            } else {
                System.out.println("Enter key만 입력하여 주십시오.");
            }
        }
    }
}
