package Java.Univ.Chaper_7;
import java.util.*;
public class exam_2 {
    private Vector<Integer> v = new Vector<>();

    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("0이 입력될 때까지 정수 입력 >> ");
        String [] line = sc.nextLine().split(" ");
        for(String token : line){
            int num = Integer.parseInt(token);
            if(num == 0) break;
            v.add(num);
        }
        sc.close();
    }
    public void changeToZero(){
        for(int i = 0; i < v.size(); i++){
            if(v.get(i) < 0){
                v.set(i, 0);
            }
        }
    }
    public void showAll(){
        for(int i = 0; i < v.size(); i++){
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }
    public int add(){
        int sum = 0;
        for(int i = 0; i < v.size(); i++){
            sum += v.get(i);
        }
        return sum;
    }
    public static void main(String [] args){
        exam_2 e = new exam_2();
        e.read(); // 정수들을 입력받아 벡터 v에 저장
        e.changeToZero(); // vector v에 저장된 음수들을 모두 0으로 변경
        System.out.print("음수를 0으로 바꾸면 ");
        e.showAll(); // vector v의 원소들을 모두 출력
        System.out.println("양수들의 합은 " + e.add());
    }
}
