package Java.Univ.Practice_problem;
import java.util.*;

public class sorting_array {
    private int [] arr;
    private int [] count;
    private Scanner sc = new Scanner(System.in);
    public void run(){
        setData();
        show();
    }
    public void setData(){
        System.out.print("number >> ");
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sortCal(n);
    }
    public void sortCal(int n){
        count = new int[n];
    
        for(int i = 0; i < n; i++){
            count[i] = 1;
            // 현재 자신보다 큰 값만큼 count ++, 그러면 동일 점수도 같은 값이 도출됨.
            // boolean check = false; // 중복 값 체크해가면서 할 수도 있지만, 이중 반복문에 이중 배열이 섞이기 시작하면
            // 코드가 복잡해지고, 쉽게 꼬여서 실수할 수 있음. 차라리 이 구조가 더 간단함.
            for(int j = 0; j < n; j++){
                if(arr[i] < arr[j]){
                    count[i]++;
                }
            }
        }
    }
    public void show(){
        for(int i = 0; i < arr.length; i++) System.out.println(arr[i] + " " + count[i] + " ");
    }
    public static void main(String[] args){
        sorting_array sa = new sorting_array();
        sa.run();
    }
}
