package study_Java.chap_5;

class TV{
    private int size;
    public TV(int size){this.size = size;}
    protected int getSize(){return size;}
}

class SmartTV extends TV{
    private String address;
    private int color;
    public SmartTV(String addresee, int size, int color){
        this.address = addresee;
        super(size);
        this.color = color;
    }
    public void printProperty(){
        System.out.println(address + " 주소의 " + getSize() + "인치 " + color);
    }
}

public class ex_5_2 {
    public static void main(String [] args){
        SmartTV sTV = new SmartTV("192.168.0.5", 77, 2000000000);
        sTV.printProperty();
    }
}
