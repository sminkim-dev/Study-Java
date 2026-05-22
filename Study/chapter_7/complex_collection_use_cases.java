package Java.Study.chapter_7;
import java.util.*;
public class complex_collection_use_cases {
    public static void main(String [] args){
        HashMap<String, Vector<Integer>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // 해시맵에 4명 학생 저장, 성적이 저장되는 벡터는 비어있음.
        map.put("한지운", new Vector<Integer>());
        map.put("김하진", new Vector<Integer>());
        map.put("하여린", new Vector<Integer>());
        map.put("윤단비", new Vector<Integer>());

        System.out.println("등록된 학생 : 한지운, 김하진, 하여린, 윤단비 등 4명입니다.");
        while(true){
            System.out.print("이름과 점수들 >> ");
            String line = scanner.nextLine();
            if(line.equals("그만")) break;
            String [] tokens = line.split(" ");
            String name = tokens[0];
            Vector<Integer> v = map.get(name); // 해시맵에서 name의 키를 가진 벡터 읽기
            if(v == null){
                System.out.println(name + "은 없는 학생입니다.");
                continue;
            }
            // 이름이 해시맵에 있는 경우 벡터 v에 점수 삽입
            for(int i = 0 ; i < tokens.length - 1; i ++){
                v.add(Integer.parseInt(tokens[i+1])); // 두번째 토큰부터는 점수들
            }
        }
        while (true) {
            System.out.print("검색할 이름 >>> ");
            String name = scanner.next(); // 한 라인 입력
            if(name.equals("그만")) break;
            Vector<Integer> v = map.get(name); // 이름으로 해시맵 검색, 벡터 알아냄
            if(v == null){
                // 이름이 해시맵에 없는 경우
                System.out.println(name + "은 없는 학생입니다.");
                continue;
            }
            if(v.size() == 0){
                // 성적이 저장된 벡터가 비어 있을 때
                System.out.println(name + "은 토익 점수가 없습니다.");
                continue;
            }
            for(int score : v){
                // for(int i = 0; i < v.size(); i++) int score = v.get(i); 와 동일함
                System.out.print(score + " ");
            }
            System.out.println();
        }
        System.out.println("program exit...");
        scanner.close();
    }
}
