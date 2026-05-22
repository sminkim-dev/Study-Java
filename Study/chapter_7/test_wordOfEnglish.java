package Java.Study.chapter_7;
import java.util.*;

class Word{
    private String english;
    private String korean;

    public Word(String english, String korean){
        this.english = english;
        this.korean = korean;
    }
    public String getEnglish(){return english;}
    public String getKorean(){return korean;}
}
public class test_wordOfEnglish {
    private Vector<Word> v = new Vector<>();
    private Scanner sc = new Scanner(System.in);

    public test_wordOfEnglish(){
        // 미리 단어 17개 정도 추가
        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("painting", "그림"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("society", "사회"));
        v.add(new Word("human", "사람"));
        v.add(new Word("picture", "그림"));
        v.add(new Word("disgusting", "역겹다"));
        v.add(new Word("rude", "무례한"));
        v.add(new Word("empty", "빈"));
        v.add(new Word("bird", "새"));
        v.add(new Word("tiger", "호랑이"));
        v.add(new Word("dog", "개"));
        // 원하는 만큼 추가
    }
    public void run(){
        System.out.println("영단어 테스를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 : " + v.size() + "개의 단어가 들어 있습니다.");

        while(true){
            // 1. 정답 랜덤 선택
            int answerIndex = (int)(Math.random() * v.size());
            Word answerWord = v.get(answerIndex);
            // 2. 보기 4개 만들기 (정답 1개 + 오답 3개)
            int [] choices = makeChoices(answerIndex);
            System.out.println(answerWord.getEnglish() + "?");
            for(int i = 0; i < 4; i++){
                System.out.print("(" + (i+1) + ")" + v.get(choices[i]).getKorean());
            }
            System.out.print(">");

            // 3. 입력 및 판별
            try {
                int userIn = sc.nextInt();
                if(userIn == -1) break;
                
                // choices[userIn - 1]이 실제 정답 인덱스(answerIndex)와 같은지 확인
                if(choices[userIn - 1] == answerIndex){
                    System.out.println("Excellent !!");
                }
                else{
                    System.out.println("No. . .");
                }
            } catch (InputMismatchException e) {
                sc.next(); // 잘못된 입력 청소
                System.out.println("숫자를 입력하세요 !");
            }
        }
        System.out.println("Prgram exit. . .");
    }
    private int [] makeChoices(int answerIndex){
        int [] c = new int[4];
        c[0] = answerIndex; // 일단 첫 번째 칸에 정답 넣기

        // 나머지 3칸에 중복되지 않는 오답 넣기
        for(int i = 1; i < 4; i++){
            while(true){
                int tmp = (int)(Math.random() * v.size());
                if(!isDuplicate(c,i,tmp)){
                    c[i] = tmp;
                    break;
                }
            }
        }
        for(int i = 0; i < c.length; i++){
            int r = (int)(Math.random() * 4);
            int temp = c[i];
            c[i] = c[r];
            c[r] = temp;
        }
        return c;
    }
    private boolean isDuplicate(int [] c, int n, int tmp){
        for(int i = 0; i < n; i++){
            if(c[i] == tmp) return true;
        }
        return false;
    }
    public static void main(String [] agrs){
        new test_wordOfEnglish().run();
    }
}
