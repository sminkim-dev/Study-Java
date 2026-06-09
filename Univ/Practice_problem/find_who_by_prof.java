package Univ.Practice_problem;
import java.util.*;

// java.arrays.binarysearch()는 배열이 정렬되어있다고 판단하고 작동. // 즉, 해당 기능 구현 전에 정렬되어 있어야함.
// 시력 기준으로 정렬하기 위해 Comparable interface 를 implement 할 것.

class Data_ implements Comparable<Data_>{
    String name;
    int height;
    double eye;
    public Data_(String name, int heiht, double eye){
        this.name=name;
        this.height=heiht;
        this.eye=eye;
    }
    @Override
    public int compareTo(Data_ o){
        // a - b -> -1 : a , b | 0 : 유지 | 1 : b , a
        //return Double.compare(o.eye, this.eye);
        return Double.compare(eye, o.eye);
    }
}

public class find_who_by_prof {
    private Scanner sc = new Scanner(System.in);
    private Data_[] x = {
            // 시력의 내림차순 정렬해야함.
            new Data_("박준서", 175, 2.0),
            new Data_("유서범", 171, 1.5),
            new Data_("장경오", 174, 1.2),
            new Data_("김찬우", 173, 0.7),
            new Data_("황지안", 169, 0.8),
            new Data_("이수연", 168, 0.4),
            new Data_("강민하", 162, 0.3)
    };
    public int myBSort(int low, int high, Data_ key){
        if(low > high) return -1;
        int mid = (low + high) / 2;
        System.out.println(" " + mid);
        if(x[mid].compareTo(key) == 0)return mid;
        else if(x[mid].compareTo(key) > 0)return myBSort(low, mid - 1, key);
        else return myBSort(mid + 1, high, key);
    }
    public int myBSearch2(int low, int high, Data_ key){
        while (!(low > high)) {
            int mid = (low + high) / 2;
            System.out.println(" " + mid);
            if(x[mid].compareTo(key) == 0) return mid;
            else if(x[mid].compareTo(key) > 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public void run(){
        Arrays.sort(x);
        // 정렬 확인용 출력.
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i].name + " " + x[i].height + " " + x[i].eye);
        }

        System.out.print("시력이 몇인 사람을 찾고 있나요? ");
        double eye_ = sc.nextDouble();

        //Data_ key = new Data_("null", 0, eye_);
        //int idx = Arrays.binarySearch(x, key);
        //int idx = myBSort(0, x.length - 1, new Data_("null", 0, eye_));
        int idx = myBSearch2(0, x.length - 1, new Data_(null, 0, eye_));
        if(idx < 0){
            System.out.println("해당 시력을 가진 사람은 현재 목록에 없습니다.");
        }
        else{
            System.out.println("idx : "+ idx);
            System.out.println("그 값은 x["+idx+"]에 있습니다.");
            System.out.printf("찾은 데이터 : %s %d %.1f",x[idx].name,x[idx].height,x[idx].eye);
            System.out.println();
        }
        sc.close();
    }
    public static void main(String [] args){
        new find_who_by_prof().run();
    }
}
