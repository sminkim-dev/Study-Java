package Univ.Practice_problem;

public class bubble_sort {
    public void run(){
        int input[] = {60, 34, 55, 100, 90, 76, 60, 90, 80, 87}; // 입력 값.

        int n = 1000000;
        int in_[] = new int[n];

        for(int i = 0; i < n; i++){
            in_[i] = (int)(Math.random() * n);
        }


        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 9; j++){
                if(input[j] > input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    public static void main(String [] args){
        bubble_sort b = new bubble_sort();
        b.run();
    }
}
