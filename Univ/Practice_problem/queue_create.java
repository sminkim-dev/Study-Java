package Univ.Practice_problem;
import java.util.*;

public class queue_create {
    // 입력 전용 스택 (데이터가 들어오는 곳)
    private Stack<Integer> s1 = new Stack<>();
    // 출력 전용 스택 (데이터가 나가는 곳)
    private Stack<Integer> s2 = new Stack<>();

    // 데이터 삽입은 s1에 push만 하면 끝: O(1)
    public void enqueue(Integer _in){
        s1.push(_in);
    }

    // 데이터 추출
    public Integer dequeue(){
        // 두 스택이 모두 비어있다면 큐가 빈 상태임
        if (isEmpty()) {
            System.out.println("Queue가 비어있습니다.");
            return null; 
        }

        // 출력 스택(s2)이 비어있을 때만 입력 스택(s1)의 데이터들을 뒤집어서 옮겨옴
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        // s2의 맨 위 데이터를 꺼내서 반환
        return s2.pop();
    }

    // 맨 앞 데이터 확인 (버그 수정 및 명칭 변경)
    public Integer peek(){
        if (isEmpty()) {
            System.out.println("Queue가 비어있습니다.");
            return null;
        }

        // dequeue와 마찬가지로 s2가 비어있을 때만 이사옴
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        // ★ 핵심 버그 수정: pop()이 아니라 peek()을 써서 데이터 유지!
        return s2.peek(); 
    }

    // 큐가 비어있는지 확인하는 헬퍼 함수
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args){
        queue_create q = new queue_create();
        
        for(int i = 0; i < 10; i++){
            q.enqueue(i);
        }
        
        // 데이터 유실 없이 0이 잘 출력됨
        System.out.println("맨 앞 데이터 확인 (peek): " + q.peek()); 
        
        System.out.print("전체 데이터 출력 (dequeue): ");
        for(int i = 0; i < 10; i++){
            System.out.print(q.dequeue() + " ");
        }
        System.out.println();
    }
}