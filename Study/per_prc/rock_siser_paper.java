package Study.per_prc;

import java.util.*;
public class rock_siser_paper {
    public static class rand{
        // 가위 바위 보
        int result;
        String atk [] = {"가위", "바위", "보"};
        int attack_num [] = {0,1,2};
        int ai_atk;
        public rand(){}
        public int Ai_atk(){
            ai_atk = (int)(Math.random()*3);
            return ai_atk;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("가위 바위 보 게임");
        while(true){
            rand r = new rand();
            System.out.print("입력 >> ");
            String my_atk = scanner.next();
            if(my_atk.equals("stop")){
                break;
            }
            for(int i = 0; i < r.atk.length; i++){
                if(my_atk.equals(r.atk[i])){
                    r.result = (r.Ai_atk() - r.attack_num[i] + 3) % 3; // 순환 구조 만들어야 하고, 음수 나오면 결과가 꼬임. 그래서 +3으로 양수만 나오게 조절.
                }
            }
            if(r.result == 0){
                System.out.println("나 : " + my_atk + " AI : " + r.atk[r.ai_atk]);
                System.out.println("비겼습니다.");
            }
            else if(r.result == 1){
                System.out.println("나 : " + my_atk + " AI : " + r.atk[r.ai_atk]);
                System.out.println("졌습니다.");
            }
            else{
                System.out.println("나 : " + my_atk + " AI : " + r.atk[r.ai_atk]);
                System.out.println("이겼습니다.");
            }
        }
        scanner.close();
    }
}