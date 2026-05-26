package Study.chapter_7;
import java.util.*;

class Student{
    private int id;
    private String tel;
    public Student(int id, String tel){this.id = id; this.tel = tel;}
    public int getId(){return id;}
    public String getTel(){return tel;}
}

public class management_student_hashMap {
    public static void main(String [] args){
        // create hashmap for save student name and tel
        var map = new HashMap<String, Student>();
        map.put("황기태", new Student(1, "010-111-1111"));
        map.put("이재문", new Student(2, "010-222-2222"));
        map.put("정인환", new Student(3, "010-333-3333"));

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("검색할 이름 ? >>> ");
            String name = scanner.next();
            if(name.equals("exit"))break;
            Student student = map.get(name);
            if(student == null){
                System.out.println(name + "은 없는 사람입니다.");
            }
            else{
                System.out.println("id : " + student.getId() + ", tel : " + student.getTel());
            }
        }
        System.out.println("program exit...");
        scanner.close();
    }
}
