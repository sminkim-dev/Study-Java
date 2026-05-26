package Univ.Chaper_7;
import java.util.*;
import java.util.stream.Collectors;
public class exam_10 {
    private ArrayList<String> str = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        while(true){
            str.clear();
            System.out.print("문자열들을 입력하세요 >> ");
            String [] line = sc.nextLine().split(" ");
            if(line[0].equals("그만")) break;
            for(int i = 0 ; i < line.length; i++){
                str.add(line[i]);
            }
            remove();
            show();
        }
    }
    public void other_read(){
        // 처음 입력 받을 때부터 중복 처리하고 입력들어감.
        while(true){
            str.clear();
            System.out.print("문자열을 입력하세요 >> ");
            String [] line = sc.nextLine().split(" ");
            if(line[0].equals("그만")) break;
            for(int i = 0; i < line.length; i++){
                if(!str.contains(line[i])){
                    str.add(line[i]);
                }
            }
        }
    }
    public void remove(){
        for(int i = 0; i < str.size(); i++){
            String find = str.get(i);
            for(int b = i + 1; b < str.size(); b++){
                if(find.equals(str.get(b))){
                    str.remove(b);
                    b--;
                    // 삭제된 자리에 새로 온 요소를 다시 확인하기 위함. 안 그러면 이 부분을 무시하고 지나감. 이유 b++로 넘어가기 때문
                }
            }
        }
    }
    public void other_remove(){
        // list 자체에서 중복 제거
        str = (ArrayList<String>) str.stream().distinct().collect(Collectors.toList());
    }
    public void show(){
        for(int i = 0; i < str.size(); i++){
            System.out.print(str.get(i) + " ");
        }
        System.out.println();
    }
    public void run(){
        read();
    }
    public static void main(String [] args){
        exam_10 e = new exam_10();
        e.run();
    }
}
