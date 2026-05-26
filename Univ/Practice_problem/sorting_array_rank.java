package Univ.Practice_problem;

import java.util.*;

public class sorting_array_rank {
    private int[] arr;
    private Integer[] clone;
    private int[] rank;
    private Scanner sc = new Scanner(System.in);

    public void setData() {
        System.out.print("number >> ");
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        clone = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++)
            clone[i] = arr[i];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            rank[i] = 0;
    }

    public void sortCal() {
        Arrays.sort(clone, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {

            int number = 1;

            for (int j = 0; j < clone.length; j++) {

                if (arr[i] == clone[j]) {
                    rank[i] = number;
                    break;
                }

                number++;
            }
        }
    }
    // 예시
    // input 100 5 100 55 3
    // sorting reverser 100 100 55 5 3
    // rank 1 1 3 4 5
    // show 1 4 1 3 5 
    // 후위 연산자 고려해서 계산할 것, 로직 >> input == sorting 동일할 때까지 count++ 하고, 동일할 때 break;
    // 를 통해 반복문을 빠져나오고 해당 값을 rank[i]에 저장한다.
    // 이유 현재 원본이랑 정렬된 배열의 값 인덱스가 서로 불일치하기 때문에, 원본 배열의 값이 정렬된 배열에서 몇 번째에 위치하는지 계산하기 위해서이다.
    // 단순히, 반복문 안에 자신보다 큰 값 개수만큼 더하는 로직이 지금 이 구조보단 간단함.
    public void show() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " " + rank[i] + " ");
    }

    public void run() {
        setData();
        sortCal();
        show();
    }

    public static void main(String[] args) {
        sorting_array_rank obj = new sorting_array_rank();
        obj.run();
    }
}
