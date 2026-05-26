package Study.chapter_7;
import java.util.*;
public class using_Iterator_Vector {
    public static void main(String [] args){
        // create generic vector that handles only integer values
        Vector<Integer> v = new Vector<>();
        v.add(5);
        v.add(100);
        v.add(-1);
        v.add(2,110);
        // output all of integers using an iterator
        Iterator<Integer> it = v.iterator(); // gain Iterator object
        while(it.hasNext()){ // all of integer print of vector v
            int n = it.next();
            System.out.println(n);
        }
        // using Iterator, all of integer values add
        int sum = 0;
        it = v.iterator(); // 커서가 다음으로 넘어가는 과정을 거침. 즉 위에 while문에서 끝에 도달했기 때문에.
        // 추가로 다시 iterator 객체를 만들(재 발행)지 않으면 이미 끝난 벡터이므로 false를 반환하기에 값이 올바르게 나오지 않음.
        while(it.hasNext()){
            int n = it.next();
            sum += n;
        }
        System.out.println("sum of vector v is '" + sum + "'");
    }
}
