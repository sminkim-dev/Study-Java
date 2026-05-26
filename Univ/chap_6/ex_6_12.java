package Univ.chap_6;
import java.util.*;

class NumberExpectationGame{
    private ArrayList<Player> players = new ArrayList<>(); // 패자들만 추리기 위해 List 사용
    private Scanner sc = new Scanner(System.in);

    public NumberExpectationGame(String names) {
        String[] nameArray = names.split(" ");
        for (String n : nameArray) players.add(new Player(n));
    }

    public void run() {
        while (players.size() > 1) { // 패자가 1명이 될 때까지 반복
            // 1. 각 선수 숫자 선택
            for (Player p : players) {
                System.out.print("[" + p.getName() + "] 정수 선택(1~10)>>");
                p.setSelectedNum(Integer.parseInt(sc.nextLine()));
            }

            System.out.print("Enter키 입력>>");
            sc.nextLine();

            // 2. 15개의 랜덤 난수 생성 및 출력
            int[] nums = new int[15];
            for (int i = 0; i < 15; i++) {
                nums[i] = (int)(Math.random() * 10 + 1);
                System.out.print(nums[i] + " ");
            }
            System.out.println();

            // 3. 맞춘 개수 계산
            int minMatch = 16; // 최소 맞춘 개수를 찾기 위한 초기값
            for (Player p : players) {
                int count = 0;
                for (int n : nums) {
                    if (p.getSelectedNum() == n) count++;
                }
                p.setMatchCount(count);
                System.out.println("[" + p.getName() + "] 맞춘 개수: " + count);
                if (count < minMatch) minMatch = count;
            }

            // 4. 패자(최소 득점자)들만 다음 라운드 진출
            ArrayList<Player> losers = new ArrayList<>();
            System.out.print("현재 패자들 : ");
            for (Player p : players) {
                if (p.getMatchCount() == minMatch) {
                    losers.add(p);
                    System.out.print(p.getName() + " ");
                }
            }
            System.out.println();
            
            players = losers; // 패자 목록 업데이트
            if(players.size() > 1) System.out.println("패자가 여러명이므로 다시 대결합니다.");
        }
        System.out.println("\n최종 패자는 " + players.get(0).getName() + "입니다.");
    }
}
class Player{
    private String name;
    private int selectedNum; // 선수가 선택한 번호
    private int matchCount;  // 난수와 일치한 개수

    public Player(String name) { this.name = name; }
    public String getName() { return name; }
    public void setSelectedNum(int num) { this.selectedNum = num; }
    public int getSelectedNum() { return selectedNum; }
    public void setMatchCount(int count) { this.matchCount = count; }
    public int getMatchCount() { return matchCount; }
}
public class ex_6_12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임에 참여할 선수들 이름>>");
        String names = scanner.nextLine();
        
        NumberExpectationGame game = new NumberExpectationGame(names);
        game.run();
        scanner.close();
    }
}
