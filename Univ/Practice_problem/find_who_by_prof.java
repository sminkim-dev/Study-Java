package Univ.Practice_problem;
import java.util.*;

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
        return Double.compare(o.eye, this.eye);
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
    public void run(){
        Arrays.sort(x);

        System.out.print("시력이 몇인 사람을 찾고 있나요? ");
        double eye_ = sc.nextDouble();

        Data_ key = new Data_("null", 0, eye_);
        int idx = Arrays.binarySearch(x, key);
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
