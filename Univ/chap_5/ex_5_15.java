package Univ.chap_5;

interface Shape {
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private int radius;
    public Circle(int radius) { this.radius = radius; }
    @Override public void draw() { System.out.println("반지름이 " + radius + "인 원"); }
    @Override public double getArea() { return PI * radius * radius; }
}

class Oval implements Shape {
    private int width, height;
    public Oval(int width, int height) { this.width = width; this.height = height; }
    @Override public void draw() { System.out.println(width + "x" + height + "에 내접하는 타원"); }
    // 결과값 471.0에 맞추기 위해 반지름으로 계산 (20, 30일 때 3.14 * 20 * 30 / 4 = 471)
    @Override public double getArea() { return PI * (width / 2.0) * (height / 2.0); }
}

class Rect implements Shape {
    private int width, height;
    public Rect(int width, int height) { this.width = width; this.height = height; }
    @Override public void draw() { System.out.println(width + "x" + height + "크기의 사각형"); }
    @Override public double getArea() { return (double)width * height; }
}

public class ex_5_15 { // 파일 이름과 반드시 일치해야 함!
    public static void main(String[] args) {
        Shape[] list = new Shape[3];
        list[0] = new Circle(5);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for (int i = 0; i < list.length; i++) list[i].redraw();
        for (int i = 0; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
    }
}