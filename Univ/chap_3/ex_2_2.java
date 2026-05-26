package Univ.chap_3;

public class ex_2_2 {
    public static class whileLoop {
        int n [] = {1, -2, 6 , 20, 5, 72, -16, 256};
        public whileLoop(){}
        void show(){
            int i = 0;
            while(i < n.length){
                if(n[i] > 0 && n[i] % 4 == 0){
                    System.out.print(n[i] + " ");
                }
                i++;
            }
            System.out.println("");
        }
    };
    public static class forLoop{
        int n [] = {1, -2, 6 , 20, 5, 72, -16, 256};
        public forLoop(){}
        void show(){
            for(int i = 0; i < n.length; i++){
                if(n[i] > 0 && n[i] % 4 == 0){
                    System.out.print(n[i] + " ");
                }
            }
            System.out.println("");
        }
    };
    public static class doWhile{
        int n [] = {1, -2, 6 , 20, 5, 72, -16, 256};
        public doWhile(){}
        void show(){
            int i = 0;
            do{
                if(n[i] > 0 && n[i] % 4 == 0){
                    System.out.print(n[i] + " ");
                }
                i++;
            }while(i < n.length);
            System.out.println("");
        }
    };
    public static void main(String[] agrs){
        whileLoop W = new whileLoop();
        forLoop L = new forLoop();
        doWhile D = new doWhile();
        W.show();
        L.show();
        D.show();
    }
}
