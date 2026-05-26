package Univ.Chaper_7;
import java.util.*;

class Student{
    private int id;
    private double score;
    private String major;
    public Student(String major, int id, double score){
        this.major = major;
        this.id = id;
        this.score = score;
    }
    public String getMajor(){return major;}
    public int getID(){return id;}
    public double getScore(){return score;}
}

public class exam_8 {
    private HashMap<String, Student> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        System.out.println("4명 이름, 전공, 학번, 학점 입력...");
        for(int i = 0; i < 4; i++){
            System.out.print(">>> ");
            String [] line = sc.nextLine().split(", ");
            int id = Integer.parseInt(line[2].trim());
            double score = Double.parseDouble(line[3].trim());
            map.put(line[0], new Student(line[1], id, score));
        }
    }

    public void showAll(){
        System.out.println("------------------------------");
        for(Map.Entry<String, Student> entry : map.entrySet()){
            Student st = entry.getValue();
            System.out.printf("이름 : %-15s 전공 : %-10s 학번 : %-4d 학점평균 : %.2f%n",entry.getKey(), st.getMajor(),st.getID(),st.getScore());
        }
    }
    public void selectBestStudent(){
        System.out.println("------------------------------");
        System.out.print("장학생 : ");
        for(Map.Entry<String, Student> entry : map.entrySet()){
            Student st = entry.getValue();
            if(st.getScore() > 4.0){
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }

    public void searchName(){
        System.out.println("------------------------------");
        while (true) {
            System.out.print("학생 이름 >> ");
            String name = sc.next();
            if(name.equals("그만")) break;
            Student story = map.get(name);
            if(story == null){
                System.out.println(name + "은 없는 학생입니다.");
            }
            else{
                System.out.println(name + ", " + story.getMajor() + ", " + story.getID() + ", " + story.getScore());
            }
        }
        System.out.println("program exit...");
        sc.close();
    }
    public static void main(String [] agrs){
        exam_8 e = new exam_8();
        e.read();
        e.showAll();
        e.selectBestStudent();
        e.searchName();
    }
}
