package Univ.chap_5;

import java.util.*;

interface IStack {
    int capacity(); // 스택에 저장 가능한 개수 리턴
    int length(); // 스택에 현재 저장된 개수 리턴
    boolean push(String val); // 스택의 톱(top)에 문자열을 저장하고 true 리턴// 꽉 차서 넣을 수 없으면 false 리턴
    String pop(); // 스택의 top에 저장된 문자열 리턴, 스택이 비어 있으면 null 리턴
}
class StringStack implements IStack{
    private String [] sttack;
    private int top;
    public StringStack(int capacity){
        this.sttack = new String[capacity];
        this.top = 0;
    }

    @Override
    public int capacity(){
        return sttack.length;
    }
    @Override
    public int length(){
        return top;
    }
    @Override
    public boolean push(String val){
        if(top == sttack.length){
            return false;
        }
        sttack[top] = val;
        top++;
        return true;
    }
    @Override
    public String pop(){
        if(top == 0){
            return null;
        }
        top--;
        return sttack[top];
    }
}

public class ex_5_11 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("스택 용량 >> ");
        int capacity = scanner.nextInt();
        StringStack ss = new StringStack(capacity);

        while(true){
            System.out.print("문자열 입력 >> ");
            String input = scanner.next();
            if(input.equals("그만")){
                break;
            }
            if(!ss.push(input)){
                System.out.println("스택이 꽉 차서 " + input + "저장 불가");
            }
        }
        System.out.print("시택에 저장된 문자열의 팝 : ");
        int totallen = ss.length();
        for(int i = 0; i < totallen; i++){
            System.out.print(ss.pop() + " ");
        }
        System.out.println();

        scanner.close();
    }
}
