package Java.Univ.Practice_problem;
import java.util.*;

public class baseball_game {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> h_list = new ArrayList<>();
    private ArrayList<Integer> r_list = new ArrayList<>();

    public void run() {
        System.out.println("---Baseball Game Start---");

        // 정답 숫자는 게임 시작 시 한 번만 생성합니다. 계속 생성하면, 정답 맞추기가 어려워 질 뿐더러 해당 게임의 취지에 맞지 않음.
        r_list.clear();
        while (r_list.size() < 3) {
            int num = random();
            if (!r_list.contains(num)) { // 중복 제거 로직
                r_list.add(num);
            }
        }

        while (true) {
            // 사용자 입력 리스트는 매번 비워줘야 합니다. 안 그러면 계속 쌓여서 정상적인 결과값 도출이 안됨.
            h_list.clear();

            System.out.print(">> ");
            String input = sc.nextLine();
            String[] line = input.split(" ");

            // 입력값이 부족할 경우 예외 처리
            if (line.length < 3) {
                System.out.println("숫자 3개를 띄어쓰기로 구분해서 입력해주세요.");
                continue;
            }

            for (String token : line) {
                h_list.add(Integer.parseInt(token));
            }

            int strike = 0;
            int ball = 0;

            // 판정 로직
            for (int i = 0; i < 3; i++) {
                // Integer 객체 비교이므로 .equals() 권장 , == 연산자 안 먹힌 것 같긴 한데, 찾아보기.
                if (r_list.get(i).equals(h_list.get(i))) {
                    strike++;
                } else if (r_list.contains(h_list.get(i))) {
                    ball++;
                }
            }

            // 결과 출력 부분 다듬기
            if (strike == 0 && ball == 0) {
                System.out.println("아웃");
            }
            if(strike != 0 && strike != 3){
                System.out.println("스트라이크 " + strike);
            }
            if(ball != 0 && strike != 0){
                System.out.println(" / 볼 " + ball);
            }
            else if(ball != 0 && strike == 0){
                System.out.println("볼 " + ball);
            }

            // 정답 확인 시 종료
            if (strike == 3) {
                System.out.println("---경기 종료---");
                break;
            }
            
            // 디버깅용 정답 확인 (실제 게임 시에는 주석 처리)
            // System.out.println("정답: " + r_list);
        }
    }

    public int random() {
        // 1~9 사이의 숫자를 반환
        return (int) (Math.random() * 9 + 1);
    }

    public static void main(String[] args) {
        new baseball_game().run();
    }
}