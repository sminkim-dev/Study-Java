package Java.Study.chapter_7;
import java.util.*;
public class using_HashMap {
    public static void main(String [] args){
        HashMap<String, String> dic = new HashMap<>(); // create HashMap
        // or var dic = new HashMap<String, String>(); 도 가능

        // 3개의 (key, value) tuple을 dic에 저장
        dic.put("baby","아기");
        dic.put("love","사랑");
        dic.put("apple", "사과");

        // user 부터 영어 단어를 입력받고 한글 단어 검색. "exit" 입력받으면 종료
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("찾고 싶은 단어는 ? >>> ");
            String eng = scanner.next();
            if(eng.equals("exit")) break;

            // 해시맵에서 '키' eng의 '값' kor 검색
            String kor = dic.get(eng);
            if(kor == null){
                System.out.println(eng + "는 없는 단어입니다.");
            }
            else{
                System.out.println(kor);
            }
        }
        System.out.println("HasmMap의 요소 개수 : " + dic.size());
        System.out.println("Program exit...");
        scanner.close();
    }
}
