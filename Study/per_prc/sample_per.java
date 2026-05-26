package Study.per_prc;
public class sample_per{
    public static void main(String[] args){
        int sum = 0;
        double avg;
        int [] arr = new int[10];
        System.out.print("랜덤한 정수들 >>> ");
        for(int b = 0; b < 10; b++){
            arr[b] = (int)(Math.random()*9) + 11; // math.randon()*9 > 0~8까지의 랜덤수 > 11 ~ 19 사이의 랜덤 수 출력
            System.out.print(arr[b] + " ");
            sum += arr[b];
        }
        avg = sum / 10;

        System.out.println("\n평균은 " + avg);
    }
}