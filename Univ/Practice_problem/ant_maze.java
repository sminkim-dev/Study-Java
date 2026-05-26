package Univ.Practice_problem;

public class ant_maze {
    private int [][]maze = new int[10][10];
private int[] copyArray = {
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 0, 0, 1, 0, 0, 0, 0, 0, 1,
    1, 0, 0, 1, 1, 1, 0, 0, 0, 1,
    1, 0, 0, 0, 0, 0, 0, 1, 0, 1,
    1, 0, 0, 0, 0, 0, 0, 1, 0, 1,
    1, 0, 0, 0, 0, 1, 0, 1, 0, 1,
    1, 0, 0, 0, 0, 1, 2, 1, 0, 1,
    1, 0, 0, 0, 0, 1, 0, 0, 0, 1,
    1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1
};
    public void run(){
        // ant maze run part
        // ant start point rule {point (1,1)} generally point (2,2)
        System.out.println("Finding the Ant maze");
        System.out.println("---default maze---");
        // maze and labyrinth means "미로" , "미궁" , etc...
        setting_maze();
        show();
        int x = 1, y = 1;
        while(true){
            // 2, when ant find feed, code stop
            //Rule :  "2" >> feed , "1" >> war , "9" >> ant went path before
            
            if(maze[x][y] == 2){
                maze[x][y] = 9;
                break;
            }
            // 지나간 길은 // 현재 위치 9로 변경
            maze[x][y] = 9;
            // 오른쪽이 벽이 아닐 경우
            if(maze[x][y + 1] != 1){
                y++;
            }
            // 오른쪽은 벽인데, 아래쪽은 아닌 경우
            else if (maze[x + 1][y] != 1) {
                x++;
            }
            else{
                break;
            }
        }
        System.out.println();
        System.out.println("after ant move maze");
        show();
    }
    public void show(){
        // result print
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void setting_maze(){
        int index = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                maze[i][j] = copyArray[index++];
            }
        }
    }
    public static void main(String [] args){
        new ant_maze().run();
    }
}
