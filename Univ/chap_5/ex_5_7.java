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

class Point3DColor extends Point{
    private int z;
    private String color;
    public Point3DColor(int x, int y, int z, String color){
        super(x, y);
        this.z = z;
        this.color = color;
    }
    public String getColor(){return color;}
    @Override
    public String toString(){
        String str = "("+getX() + "," +getY() + "," + getZ() + ") " + color + "점";
        return str;
    }
    public int getZ(){return z;}
    
    public void move(Point3DColor q){
        // 점 p를 점 q의 위치로 이동.
        super.move(q.getX(),q.getY());
        this.z = q.getZ();
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Point3DColor){
            Point3DColor r = (Point3DColor) obj;
            if(this.getX() == r.getX() && this.getY() == r.getY() && 
            this.getZ() == r.getZ() && this.color.equals(r.color)){
                return true;
            }
        }
        return false;
    }
}
public class ex_5_7 {
    public static void main(String[] args){
        Point3DColor p = new Point3DColor(10, 20, 30, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
        p.move(q);
        System.out.println(p.toString() + "입니다.");
        Point3DColor r = new Point3DColor(1, 2, 3, "RED");
        if(p.equals(r))System.out.println("예, 같은 위치 , 색깔의 점 입니다.");
        else System.out.println("아니오");
    }
}
