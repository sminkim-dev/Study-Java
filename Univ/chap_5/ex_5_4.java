package Univ.chap_5;

class Point{
    private int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    protected void move(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class ColorPoint2 extends Point{
    private String color;
    public ColorPoint2(){
        super(0, 0);
        this.color = "WHITE";
    }
    public ColorPoint2(int x, int y){
        super(x, y);
        this.color = "BLACK";
    }
    public ColorPoint2(int x, int y, String color){
        super(x , y);
        this.color = color;
    }
    public String toString(){
        String str = color + "색의 " + "(" + getX() + "," + getY() + ")의 점";
        return str;
    }
    public void set(String color){
        this.color = color;
    }
    public void set(int x, int y){
        move(x, y);
    }
    public double getDistance(ColorPoint2 holdPoint){
        int xDiff = this.getX() - holdPoint.getX();
        int yDiff = this.getY() - holdPoint.getY();
        double diff = Math.sqrt(Math.pow(xDiff,2) + Math.pow(yDiff, 2));
        return diff;
    }
}
public class ex_5_4 {
    public static void main(String[] args){
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
        cp.set("BLUE");
        cp.set(10, 20);
        System.out.println(cp.toString() + "입니다.");
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        System.out.println("CP에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
