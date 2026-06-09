package Study.per_prc;
import java.util.*;
public class memo {
    public static void main(String [] args){
        // Arrays
        int n[] = {1,2,3};
        System.out.println(Arrays.toString(n)); // print arrays
        int len = n.length;
        System.out.println(len);

        int copy[] = Arrays.copyOf(n, len);
        System.out.println(Arrays.toString(copy));

        Arrays.fill(copy, 10);
        System.out.println(Arrays.toString(copy));

        // ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1,30);
        int target = list.get(2);
        System.out.println(target);
        //list.set(0, 12);
        System.out.println(list.get(0));
        //list.remove(0);
        int size = list.size();
        System.out.println(size);
        if(list.contains(10)){
            System.out.println("contain");
        }
        else{
            System.out.println("no contain");
        }
        //list.clear();
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();

        // stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        for(int num : stack){
            System.out.print(num + " ");
        }
        System.out.println();
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        stack.peek(); // 조회 느낌, 디버깅 용도, 값을 변경하지 않고 살짝 보는 느낌
        stack.size();
        stack.empty();

        // deque // stack 대체
        Deque<Integer>deque = new ArrayDeque<>();
        // stack이랑 동일
        deque.push(10);
        deque.push(20);
        deque.pop();
        deque.size();
        deque.peek();

        // queue
        Queue<Integer>queue = new LinkedList<>();
        // or
        //Queue<Integer>queue2 = new ArrayDeque<>();
        // insert
        queue.offer(10);
        queue.offer(20);
        // remove
        queue.poll();
        if(queue.isEmpty()){
            System.out.println("e");
        }
        else{
            System.out.println("f");
        }

        // deque 양방향 큐
        Deque<Integer> d = new ArrayDeque<>();
        d.offerFirst(10);
        d.offerLast(20);

    }
}
