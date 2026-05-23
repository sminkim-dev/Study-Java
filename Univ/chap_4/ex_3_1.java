package study_Java.chap_4;

public class ex_3_1 {
    public static class TV{
        int inch;
        int price;
        String brand;
        public TV(String brand, int inch, int price){
            this.inch = inch;
            this.price = price;
            this.brand = brand;
        }
        public void show(){
            System.out.print(brand + "에서 만든 " + price + "만원짜리의 " + inch + "인치 TV\n");
        }
    }
    public static void main(String[] args){
        TV tv = new TV("Samsung", 50, 300);
        tv.show();
    }
}
