package Java.Study.chapter_7;

class GStack<T>{
    // 제네릭 스택 선언, 제네릭 타입 T
    int tos;
    Object [] stck; // 스택에 요소를 저장할 공간 배열
    public GStack(){
        tos = 0;
        stck = new Object[10];
        // 데이터를 저장할 배열입니다. 자바 제네릭의 제한 사항 때문에
        // new T[10]처럼 타입을 직접 생성할 수 없어, 모든 클래스의 조상인 Object 배열로 만듭니다.
    }
    public void push(T item){
        if(tos == 10){
          // 스택이 꽉 차서 더이상 요소를 삽입할 수 없음.
          return;  
        } 
        stck[tos] = item;
        tos++;
    }
    //@SuppressWarnings("unchecked")
    // 자바 컴파일러가 보기에 stck은 모든 것이 담기는 Object[]인데, 이걸 검증도 없이 T로 바꾸겠다고 하니,
    // 실행시키기 전까지는 확신하지 못한다고 주의를 주게 됨. 해당 주의를 무시하기 위해서는 해당 경고 억제 "어노테이션"을 활용하면 된다.
    // 해당 어노테이션은 최대한 좁은 범위로 쓰는 것을 권장, 클래스 전체에 하면 진짜 위험한 경고까지 못 볼 수 있음.
    public T pop(){
        if(tos == 0){
            // 스택이 비어있어 꺼낼 요소가 없음
            return null;
        }
        tos--;
        // 이런 식으로 최소 범위로 어노테이션을 주로 사용함.
        // 코드를 쪼개서 경고 지점 명확히 해야함.
        @SuppressWarnings("unchecked")
        T item = (T)stck[tos];
        return item;
    }
}

public class create_generic_stack {
    public static void main(String [] args){
        GStack<String> stringStack = new GStack<String>();
        // type stirng의 Gstack 생성
        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        for(int i = 0; i < 3; i++){
            System.out.println(stringStack.pop());
        }

        GStack<Integer> intStack = new GStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        for(int i = 0; i < 3; i++){
            System.out.println(intStack.pop());
        }
    }
}
