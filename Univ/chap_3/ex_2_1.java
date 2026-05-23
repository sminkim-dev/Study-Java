package study_Java.chap_3;
// main 메소드를 만들고 클래스로 whileloop , forloop 클래스를 작성 + do - while 까지.


public class ex_2_1 {

    public static void main(String[] agrs){
        int sum = 0, i =1;
        while(true){
            if(i > 50){
                break;
            }
            sum += i;
            i += 3;
        }
        System.out.println(sum);
    }
}
