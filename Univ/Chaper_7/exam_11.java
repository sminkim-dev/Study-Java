package Univ.Chaper_7;
import java.util.*;
public class exam_11 {
    private HashMap<String , ArrayList<Integer>> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        while(true){
            System.out.print("이름과 걸음 수 >> ");
            String [] line = sc.nextLine().split(" ");
            if(line[0].equals("그만"))break;
            ArrayList<Integer> steps = map.computeIfAbsent(line[0], k -> new ArrayList<>());
            // ArrayList<Integer> steps = map.get(line[0]);
            // if(steps == null){
            //      steps = new ArrayList<>();
            //      map.put(line[0], steps); 
            // }
            for(int i = 1; i < line.length; i++){
                steps.add(Integer.parseInt(line[i].trim()));
            }
        }
    }
    public void lotOtNums(){
        int max = Integer.MIN_VALUE;
        String name = "";
        for(Map.Entry<String,ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> a = entry.getValue();
            int sum = 0;
            for(int b = 0; b < a.size(); b++){
                sum += a.get(b);
            }
            if(max < sum){
                max = sum;
                name = entry.getKey();
            }
        }
        System.out.println("걸음수가 가장 많은 사람은 " + name + " " + max + "보");
    }
    public void search(){
        while(true){
            System.out.print("검색할 이름 >> ");
            String name = sc.next();
            if(name.equals("그만")) break;
            ArrayList<Integer> a = map.get(name);
            if(a == null){
                System.out.println(name + "은 없는 학생입니다.");
            }
            else{
                int sum = 0;
                for(int i = 0; i < a.size(); i++){
                    sum += a.get(i);
                    System.out.print(a.get(i) + " ");
                }
                System.out.println("평균 : " + sum / a.size());
            }
        }
    }
    public void run(){
        read();
        lotOtNums();
        search();
        System.out.println("prgram exit...");
        sc.close();
    }
    public static void main(String [] args){
        exam_11 e = new exam_11();
        e.run();
    }
}
