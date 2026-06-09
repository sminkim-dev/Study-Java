package Univ.Practice_problem;

import java.util.*;

class physcData {
    String name;
    int height;
    double eye;

    public physcData(String name, int h, double e) {
        this.name = name;
        this.height = h;
        this.eye = e;
    }
}

public class find_who_by_me {
    private physcData[] x = {
            // 시력의 내림차순 정렬해야함.
            new physcData("박준서", 175, 2.0),
            new physcData("유서범", 171, 1.5),
            new physcData("장경오", 174, 1.2),
            new physcData("김찬우", 173, 0.7),
            new physcData("황지안", 169, 0.8),
            new physcData("이수연", 168, 0.4),
            new physcData("강민하", 162, 0.3)
    };
    private Scanner sc = new Scanner(System.in);
    public void sort() {
        // for (int j = 0; j < 6; j++) {
        //     for (int i = 0; i < 6; i++) {
        //         if (x[i].eye < x[i + 1].eye) {
        //             physcData temp;
        //             temp = x[i];
        //             x[i] = x[i + 1];
        //             x[i + 1] = temp;
        //         }
        //     }
        // }
        //Arrays.sort(x , (a,b) -> Double.compare(b.eye, a.eye)); // Arrays.sort() + lamda
        Arrays.sort(x , Comparator.comparingDouble((physcData p) -> p.eye).reversed()); // 시력 기준으로 정렬하고 거꾸로 정렬.
        // ex) 비교식의 b - a는 소수점 계산에서 정밀도가 다소 떨어지기에, 이 부분이 신경쓰인다면 Double.compare를 쓰면 Java가 알아서 계산하고 비교해줌.
    }

    public boolean serach(double e){
        for(int i = 0; i < x.length; i++){
            if(x[i].eye == e){
                return true;
            }
        }
        return false;
    }
    public void run() {
        sort();
        System.out.print("시력이 몇인 사람을 찾고 있나요?: ");
        double e = sc.nextDouble();
        if(serach(e) == false){
            System.out.println("해당 시력을 가진 사람은 없습니다.");
            System.exit(0);
        }
        int idx = 0;
        String name="";
        int height_ = 0;
        for(int i = 0; i < x.length; i++){
            if(x[i].eye == e){
                idx = i;
                name = x[i].name;
                height_ = x[i].height;
                break;
            }
        }
        System.out.println("idx : " + idx);
        System.out.println("그 값은 x["+idx+"]에 있습니다.");
        System.out.printf("찾은 데이터 : %s %d %.1f",name,height_,e); 
        System.out.println();
        sc.close();
    }

    public static void main(String[] args) {
        new find_who_by_me().run();
    }
}
