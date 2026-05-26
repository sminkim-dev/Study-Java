package Univ.chap_5;

class TV{
    private int size;
    public TV(int size){this.size = size;}
    protected int getSize(){return size;}
}
class ColorTV extends TV{
    private int price;
    public ColorTV(int size, int price){
        super(size); // 부모 클래스에서 기본 생성자가 아닌 값을 가진 생성자임으로 해당size값을 자식 클래스에게 넘겨야할 의무가 있음.
        this.price = price; // 가격이 아니라 컬러였음.
    }
    public void printProperty(){
        System.out.println(getSize() + "인치 " + price + "컬러");
    }
}
public class ex_5_1 {
    public static void main(String[] args){
        ColorTV myTv = new ColorTV(65, 65536);
        myTv.printProperty();
    }
}
