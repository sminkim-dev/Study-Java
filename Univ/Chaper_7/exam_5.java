package Java.Univ.Chaper_7;
import java.util.*;
public class exam_5 {
    private Map<String, Integer> map = new LinkedHashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        System.out.println("*** 마일리지 관리 프로그램 ***");
        while(true){
            System.out.print("이름과 마일리지 >> ");
            String name = sc.next();
            if(name.equals("그만")) break;
            int mileage = sc.nextInt();
            if(map.containsKey(name)){
                // !!! [핵심] 기존 마일리지가 있다면, 가져와서 더하고 아니라면 그냥 넣어야 함.
                int old_mileage = map.get(name);
                map.put(name, old_mileage + mileage);
            }
            else{
                map.put(name, mileage);
            }
        }
        // 전체 마일리지 출력
        printAll();
        // 가장 마일리지가 높은 고객 찾지
        findMax();
        sc.close();
    }
    public void printAll(){
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print("(" + entry.getKey() + ":" + entry.getValue() + ") ");
        }
        System.out.println();
    }
    public void findMax(){
        int max = Integer.MIN_VALUE;
        String maxName = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                maxName = entry.getKey();
            }
        }
        System.out.println("가장 마일리지가 높은 고객은 " + maxName + "입니다.");
    }
    public static void main(String [] args){
        exam_5 e = new exam_5();
        e.read();
    }
}
