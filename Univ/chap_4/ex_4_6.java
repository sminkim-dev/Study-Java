package study_Java.chap_4;

public class ex_4_6 {
    public static class Rectangle{
        int x, y, width, height;
        public Rectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        public boolean insquare(){
            return (width == height) ? true : false;
        }
        public boolean contains(Rectangle c){
            if(this.x < c.x && this.y < c.y && this.width + this.x > c.width + c.x && this.height + this.y > c.height + c.y){
                return true;
            }
            else{
                return false;
            }
        }
        public void show(){
            System.out.println("(" + x + "," + y + ")에서 크기가 (" + width + "," + height + ")인 사각형");
        }
    }
    public static void main(String[] args){
        Rectangle a = new Rectangle(3,3 ,6 , 6);
        Rectangle b = new Rectangle(4, 4, 2, 3);

        a.show();
        if(a.insquare()) System.out.println("a는 정사각형입니다.");
        else System.out.println("a는 직사각형입니다.");
        if(a.contains(b)) System.out.println("a는 b를 포함합니다.");
    }
}
