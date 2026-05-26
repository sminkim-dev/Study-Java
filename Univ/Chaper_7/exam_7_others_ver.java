package Univ.Chaper_7;
import java.util.*;

class rLocation{
    private String capital;
    private double longitude;
    private double latitude;
    public rLocation(String captial, double longitude, double latitude){
        this.capital = captial;
        this.longitude = longitude; // 경도
        this.latitude = latitude; // 위도
    }
    public double getLongitude(){return longitude;}
    public double getLatitude(){return latitude;}
    public String getCapital(){return capital;}
}

public class exam_7_others_ver {
    private ArrayList<rLocation> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void read(){
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for(int i = 0; i < 4; i++){
            System.out.print(">> ");
            String [] line = sc.nextLine().split(",");
            double longitude = Double.parseDouble(line[1].trim());
            double latitude = Double.parseDouble(line[2].trim());
            list.add(new rLocation(line[0], longitude, latitude));
        }
    }
    public void showAll(){
        System.out.println("---------------------");
        for(int i = 0; i < list.size(); i++){
            rLocation loc = list.get(i);
            System.out.printf("%-10s %-10.1f %.1f%n",loc.getCapital(),loc.getLongitude(),loc.getLatitude());
        }
    }
    public void searchCapital(){
        System.out.println("---------------------");
        while(true){
            System.out.print("도시 이름 >> ");
            String capital = sc.nextLine().trim();
            if(capital.equals("그만")) break;
            boolean find = false;
            for(int i = 0; i < list.size(); i++){
                rLocation loc = list.get(i);
                if(capital.equals(loc.getCapital())){
                    find = true;
                    System.out.println(loc.getCapital() + "\t" + loc.getLongitude() + "\t" + loc.getLatitude());
                }
            }
            if(!find){
                System.out.println(capital + "은 없습니다.");
            }
        }
        System.out.println("program exit...");
        sc.close();
    }
    public static void main(String [] args){
        exam_7_others_ver e = new exam_7_others_ver();
        e.read();
        e.showAll();
        e.searchCapital();
    }
}
