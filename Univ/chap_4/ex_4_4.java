package study_Java.chap_4;

public class ex_4_4 {
    public static class Average{
        int num_arr []  = new int [10];
        int size = 0;
        public Average(){
            System.out.println("*******저장된 데이터 모두 출력*******");
        }
        public void put(int num){
            this.num_arr[size++] = num;
        }
        public void showALL(){
            for(int i = 0; i < size; i ++){
                System.out.print(num_arr[i] + " ");
            }
            System.out.println("");
        }
        public double getAvg(){
            double sum = 0;
            for(int i = 0; i < size; i++){
                sum += num_arr[i];
            }
            return sum / size;
        }
    }
    public static void main(String[] args){
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showALL();
        System.out.println("평균은 " + avg.getAvg());
    }
}
