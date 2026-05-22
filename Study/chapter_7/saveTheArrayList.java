package Java.Study.chapter_7;
import java.util.*;
public class saveTheArrayList {
    public static void main(String [] args){
        ArrayList<String> a = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
        for(int i = 0; i < 4; i++){
            System.out.print("name >>> ");
            a.add(scanner.next()); // insert of ArrayList Collection
        }

        // all of name in ArrayList print
        for(int i = 0; i < a.size(); i++){
            System.out.print("name : " + a.get(i) + "\n");
        }

        // longest name print
        int longestIndex = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(longestIndex).length() < a.get(i).length()){
                longestIndex = i;
            }
        }
        System.out.println("Longest name is '" + a.get(longestIndex) + "'");
        scanner.close();
    }
}
