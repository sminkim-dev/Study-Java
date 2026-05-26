package Univ.Chaper_7;
import java.util.*;
public class exam_6 {
    private HashMap<String, Integer> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void run(){
        System.out.println("*** 은행에 오신 것을 환영합니다. ***");
        while(true){
            System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5 >>> ");
            int select = sc.nextInt();
            if(select == 5){
                System.out.println("program exit...");
                break;
            }
            if(select == 1){
                deposit();
            }
            if(select == 2){
                withDrawal();
            }
            if(select == 3){
                showTarget();
            }
            if(select == 4){
                showAll();
            }
        }
        sc.close();
    }
    public void deposit(){
        System.out.print("계좌명과 액수 >> ");
        try {
            String name = sc.next();
            int money = sc.nextInt();
            if(map.containsKey(name)){
                int old_money = map.get(name);
                map.put(name, old_money + money);
            }
            else{
                map.put(name, money);
            }
        } catch (InputMismatchException e) {
            System.out.println("자료형(type)을 올바르게 입력하십시오.");
        }
    }
    public void withDrawal(){
        System.out.print("계좌명과 액수 >>> ");
        try {
            String name = sc.next();
            int wd_money = sc.nextInt();
            Integer total_m = map.get(name);
            if(total_m == null){
                System.out.println("없는 계좌명입니다.");
            }
            else{
                if(total_m > wd_money){
                    map.put(name, total_m - wd_money);    
                }
                else{
                    System.out.println("잔액이 부족하여 출금할 수 없음.");
                }
            }

        } catch (NumberFormatException e) {
            
        }
    }
    public void showAll(){
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print("(" + entry.getKey() + ":" + entry.getValue() + ") ");
        }
        System.out.println();
    }
    public void showTarget(){
        System.out.print("계좌명 >>> ");
        try {
            String name = sc.next();
            Integer money = map.get(name);
            if(money == null){
                System.out.println("계좌를 찾을 수 없습니다.");
            }
            else{
                System.out.println("(" + name + ":" + money + "원)");
            }
        } catch (Exception e) {

        }
    }
    public static void main(String [] args){
        exam_6 e = new exam_6();
        e.run();
    }
}
