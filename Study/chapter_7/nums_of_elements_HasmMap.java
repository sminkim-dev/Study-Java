package Java.Study.chapter_7;
import java.util.*;
public class nums_of_elements_HasmMap {
    public static void main(String [] args){
        var scoreMap = new HashMap<String, Integer>();

        // save in five integer
        scoreMap.put("김은비", 97);
        scoreMap.put("하여린", 88);
        scoreMap.put("전아린", 98);
        scoreMap.put("이동건", 70);
        scoreMap.put("양승연", 99);

        System.out.println("HashMap의 요소 개수 : " + scoreMap.size());

        // print score of all of people, scoreMap에 들어 있는 모든 (key, value) 쌍 출력
        Set<String> keys = scoreMap.keySet(); // 모든 key를 가진 set 컬렉션 리턴
        Iterator<String> it = keys.iterator(); // set에 있는 모든 key를 순서대로 검색하는 iterator 리턴
        
        while(it.hasNext()){
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + " : " + score);
        }
    }
}
