package study_Java.chap_4;

public class ex_3_2 {
    public static class Cube{
        int width; //가로
        int length; //세로
        int height; //높이
        public Cube(int width, int length, int height){
            this.width = width;
            this.length = length;
            this.height = height;
        }
        public void increase(int width, int length, int height){
            this.width += width;
            this.length += length;
            this.height += height;
        };
        public int getVolume(){
            int volume = 0;
            volume = width * length * height;
            return volume;
        }
        public boolean isZere(){
            int volume = getVolume();
            return (volume == 0) ? true : false;
        }
    }
    public static void main(String[] args){
        Cube cube = new Cube(1,2,3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1,2,3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        /* if(cube.isZere()){
            System.out.println("큐브의 부피는 0");
        }
        else{
            System.out.println("큐브의 부피는 0이 아님");
        } */
       /* String isZero = cube.isZere() ? "큐브의 부피는 0" : "큐브의 부피는 0이 아님";
       System.out.println(isZero);  */
       System.out.println(cube.isZere() ? "큐브의 부피는 0" : "큐브의 부피는 0이 아님");
    }
}
