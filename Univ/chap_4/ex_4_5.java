package Univ.chap_4;

public class ex_4_5 {
    public static class Song{
        String title;
        String singer;
        int present_year;
        String talent_country;
        public Song(String title, String singer, int present_year, String talent_country){
            this.title = title;
            this.singer = singer;
            this.present_year = present_year;
            this.talent_country = talent_country;
        }
        public void show(){
            System.out.println(present_year + "년 " + talent_country + "의 " + singer + "가 부른 " + title);
        }
    }
    public static void main(String[] args){
        Song song = new Song("가로수 그늘 아래 서면","이문세" , 1988, "한국");
        song.show();
    }
}
