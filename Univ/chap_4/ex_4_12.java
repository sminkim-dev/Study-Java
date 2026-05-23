package study_Java.chap_4;
import java.util.*;
class Dictionary{
    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String [] eng = {"love", "baby", "money", "future", "hope"};
    public static String kor2eng(String word){
        String ans = "";
        ans += word;
        for(int i = 0; i < kor.length; i++){
            if(word.equals(kor[i])){
                if(i == 0 || i == 2 || i == 4){
                    ans += "은 ";
                }
                else{
                    ans += "는 ";
                }
                ans += eng[i];
                return ans;
            }
        }
        ans += "는 저의 사전에 없습니다.";
        return ans;
    }
}

public class ex_4_12 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램");
        while(true){
            System.out.print("한글 단어? > ");
            String ans = scanner.next();
            if(ans.equals("그만")){
                scanner.close();
                System.exit(0);
            }
            System.out.println(Dictionary.kor2eng(ans));
        }
    }
}
