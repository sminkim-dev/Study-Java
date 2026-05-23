package study_Java.chap_6;
//다른 파일에 따로 분류해서 import 하는 과정을 설명하는 코드. 따로 분리하진 않겠음.
// calc 는 package util에 main은 package main에 분류해서 끌고 오는 형태로 진행.
class Calc{
    private int x, y;
    public Calc(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int sum(){return x + y;}
}

public class ex_6_3 {
    public static void main(String[] args){
        Calc c = new Calc(10, 20);
        System.out.println(c.sum());
    }
}
