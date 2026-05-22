package Java.Study.chapter_7;

public class create_reverseStack_method {
    public static <T> GStack<T> reverse(GStack<T> a){
        // T가 타입 매개변수인 제네릭 메소드
        GStack<T> s = new GStack<T>(); // 스택 a를 반대로 저장할 목적 GStack 생성
        while(true){
            T tmp;
            tmp = a.pop(); // 원래 스택에서 요소 하나를 꺼냄
            if(tmp == null){
                // 스택이 비었음
                break; // 거꾸로 만드는 작업 종료
            }
            else{
                s.push(tmp); // 새 스택에 요소를 삽입
            }
        }
        return s;
    }
    public static void main(String [] args){
        GStack<Double> gs = new GStack<>(); // create type Double of GStack
        
        for(int i = 0; i < 5; i++){
            //5개의 요소를 스택에 push
            gs.push(Double.valueOf(i));
            // gs.push(new Double(i)); 이 부분이 노란 줄로 경고 뜰 수 있음.
            // 최신 버전에서는 new Double() 대신, Double.valueOf() or (double)i로 써서
            // 오토박싱(AutoBoxing)이 일어나게 하는 것을 권장함.
        }
        gs = reverse(gs);
        for(int i = 0; i < 5; i++){
            System.out.println(gs.pop());
        }
    }
}
