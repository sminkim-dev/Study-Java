package Java.Univ.Chaper_7;
import java.util.*;
public class exam_3 {
    private HashMap<String, Integer> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        System.out.println("주식 종목과 주가를 입력하세요.(예:삼성전자 75000)");
        while(true){
            System.out.print("종목, 주가 >> ");
            String event = sc.next();
            if(event.equals("그만")) break;
            int stock_price = sc.nextInt();
            map.put(event, stock_price);
        }
    }
    public void search(){
        System.out.println("주가를 검색합니다.");
        while(true){
            System.out.print("종목 >> ");
            String find_event = sc.next();
            if(find_event.equals("그만")){
                System.out.println("program exit...");
                break;
            }
            
            Integer price = map.get(find_event);
            if(price == null){
                System.out.println(find_event + "은 없는 종목입니다.");
            }
            else{
                System.out.println(find_event + "의 주가는 " + price + "원");
            }
        }
        sc.close();
    }
    public static void main(String [] args){
        exam_3 e = new exam_3();
        e.read();
        e.search();
    }
}
