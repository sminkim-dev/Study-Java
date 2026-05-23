package study_Java.chap_4;

class Memo{
    private String name;
    private String date;
    private String text;
    public Memo(String name, String date, String text){
        this.name = name;
        this.date = date;
        this.text = text;
    }
    public boolean isSameName(Memo a){
        return (this.name == a.name) ? true : false;
    }
    public void show(){
        System.out.println(name + ", " + date + " " + text);
    }
    public int length(){
        return text.length();
    }
    public String getName(){
        return name;
    }
}
public class ex_4_7 {
    public static void main(String[] args){
        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박채원", "10:15", "시카고로 어학연수 가요");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

        a.show();
        System.out.println((a.isSameName(b)) ? "동일 이름입니다." : "다른 사람입니다.");
        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length() + "입니다."); 
    }
}
