package Univ.Chaper_7;
import java.util.*;

class Location{
    private double longitude;
    private double latitude;
    public Location(double longitude, double latitude){
        this.longitude = longitude; // 경도
        this.latitude = latitude; // 위도
    }
    public double getLongitude(){return longitude;}
    public double getLatitude(){return latitude;}
}

public class exam_7 {
    private HashMap<String, Location> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    // 입력까지 실행
    public void read(){
        System.out.println("도시, 경도, 위도를 입력하세요.");
        // 4개의 도시를 입력받음
        for(int i = 0; i < 4; i++){
            System.out.print(">>> ");
            String [] line = sc.nextLine().split(", ");
            String capital = line[0];
            double longitude = Integer.parseInt(line[1]);
            double latitude = Integer.parseInt(line[2]);
            Location l = new Location(longitude, latitude);
            map.put(capital, l);
        }
    }
    // 입력 이후 해시맵에 있는 모든 것을 출력
    public void showAll(){
        System.out.println("-----------------------");
        for(Map.Entry<String, Location> entry : map.entrySet()){
            Location loc = entry.getValue();
            System.out.println(entry.getKey() + "\t" + loc.getLongitude() + "\t" + loc.getLatitude());
        }
        System.out.println("-----------------------");
    }
    public void searchCapital(){
        while(true){
            System.out.print("도시 이름 >>> ");
            String capital = sc.next();
            if(capital.equals("그만"))break;
            Location find = map.get(capital);
            if(find == null){
                System.out.println(capital + "은 없습니다.");
            }
            else{
                System.out.println(capital + "\t" + find.getLongitude() + "\t" + find.getLatitude());
            }
        }
        System.out.println("program exit...");
        sc.close();
    }
    public static void main(String [] args){
        exam_7 e = new exam_7();
        e.read();
        e.showAll();
        e.searchCapital();
    }
}
