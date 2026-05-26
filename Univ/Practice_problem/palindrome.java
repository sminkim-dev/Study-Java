package Univ.Practice_problem;
import java.util.*;

// palindrome 회문이란? >> 앞으로 읽어도 뒤로 읽어도 같은 것을 의미.
public class palindrome {
    private Scanner sc = new Scanner(System.in);
    private Stack<Character> stack = new Stack<>();

    public void run(){
        System.out.println("Start");
        while(true){
            System.out.print(">> ");
            String input = sc.nextLine();
            if(input.equals("exit")) break;
            // 입력 받고, 각 문자를 스택에 푸쉬.
            for(int i = 0; i < input.length(); i++){
                stack.push(input.charAt(i));
            }
            String reverse = "";
            // for(int. i = 0; i < input.length(); i++); 이것보단 아래 stack에 있는 양만큼 반복하는게 더 안정적임.
            while(!stack.isEmpty()){
                reverse += stack.pop();
            }
            // 판단 로직 구현
            if(input.equals(reverse)){
                System.out.println("- 회문 O");
            }
            else{
                System.out.println("- 회문 X");
            }
        }
        System.out.println("- 종료");
        sc.close();
    }
    public static void main(String [] args){
        new palindrome().run();
    }
}
