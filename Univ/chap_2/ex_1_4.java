package Univ.chap_2;
import java.util.*;

public class ex_1_4 {
    public static void main(String[] args){
        
        //System.setProperty("file.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in);

        System.out.print("여행지 >> ");
        String travelPlace = scanner.nextLine();

        System.out.print("인원수 >> ");
        int peopleNumbers = scanner.nextInt();

        System.out.print("숙박일 >> ");
        int sleep_day = scanner.nextInt();

        System.out.print("1인당 항공료 >> ");
        int personAirFee = scanner.nextInt();

        System.out.print("1방 숙박비 >> ");
        int oneRoomFee = scanner.nextInt();

        int room = (peopleNumbers / 2) + (peopleNumbers % 2);
        int total_air_fee = personAirFee * peopleNumbers;
        int total_romm_fee = room * oneRoomFee * sleep_day;
        int final_result = total_air_fee + total_romm_fee;

        System.out.printf("%d명의 %s %d박 %d일 여행에는 방이 %d개 필요하며 경비는 %d원입니다.\n",peopleNumbers,travelPlace,sleep_day,sleep_day+1,room,final_result);
        scanner.close();
    }
}
