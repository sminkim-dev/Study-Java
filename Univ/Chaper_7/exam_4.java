package Univ.Chaper_7;
import java.util.*;
public class exam_4 {
    private HashMap<String, Integer> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void set(){
        map.put("고추장", 3000);
        map.put("만두", 500);
        map.put("새우깡", 1500);
        map.put("콜라", 600);
        map.put("참치캔", 2000);
        map.put("치약", 1000);
        map.put("연어", 2500);
        map.put("삼겹살", 2500);
    }
    public void run(){
        set();
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        System.out.println(map);
        while(true){
            System.out.print("물건과 개수를 입력하세요 >> ");
            String item = sc.next();
            if(item.equals("그만")){
                System.out.println("prgram exit...");
                break;
            }
            int count = sc.nextInt();
            Integer price = map.get(item);
            if(price == null){
                System.out.println(item + "은 없는 상품입니다!");
            }
            else{
                int total_price = price * count;
                System.out.println("전체 비용은 " + total_price + "원입니다.");
            }
        }
        sc.close();
    }
    public static void main(String [] args){
        exam_4 e = new exam_4();
        e.run();
    }
}
