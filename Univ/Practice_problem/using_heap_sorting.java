package Univ.Practice_problem;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class using_heap_sorting {
    public static void main(String [] args){
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        //PriorityQueue<Integer> maxheap = new PriorityQueue<>((a , b) -> b - a);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int array [] = new int[size];
        int input[] = {60, 34, 55, 100, 90, 76, 60, 90, 80, 87}; // 입력 값.
        for(int i = 0; i < size; i++){
            array[i] = input[i]; // 지금은 하드코딩되어있지만, 실제 입력해서 값을 넣게 되면 이 부분에 의해 값이 들어가고.
        }
        for(int i = 0 ; i < 10; i++){
            minheap.offer(input[i]); // input[i] 부분을 실제로 입력 받게 된 배열의 값으로 변경한다.
            maxheap.offer(input[i]);
        }
        for(int i = 0; i < 10; i++){
            int t = minheap.poll();
            System.out.print(t + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            int t = maxheap.poll();
            System.out.print(t + " ");
        }
        System.out.println();
        sc.close();
    }
}
