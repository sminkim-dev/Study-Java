package Univ.Practice_problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Shortest_len_maze {

    private final int SIZE = 10;

    private int[][] maze = new int[SIZE][SIZE];

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

    // 상 하 좌 우
    private final int[] dx = { -1, 1, 0, 0 };
    private final int[] dy = { 0, 0, -1, 1 };

    // 좌표 클래스
    static class Point {
        int x;
        int y;
        int depth;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public void run() {

        settingMaze();

        System.out.println("===== 미로 =====");
        showMaze();

        int bfsResult = bfs();
        int dfsResult = dfsUsingStack();

        System.out.println("\n==============================");

        if (bfsResult != -1) {
            System.out.println("BFS 최단 거리 : " + bfsResult);
        } else {
            System.out.println("BFS : 먹이에 도달 불가");
        }

        if (dfsResult != Integer.MAX_VALUE) {
            System.out.println("DFS 최단 거리 : " + dfsResult);
        } else {
            System.out.println("DFS : 먹이에 도달 불가");
        }

        System.out.println("==============================");
    }

    // BFS
    public int bfs() {

        int[][] distance = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                distance[i][j] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(1, 1));
        distance[1][1] = 0;

        while (!queue.isEmpty()) {

            Point curr = queue.poll();

            // 먹이 발견
            if (maze[curr.x][curr.y] == 2) {

                System.out.println("\n===== BFS 거리 맵 =====");
                showDistanceMap(distance);

                return distance[curr.x][curr.y];
            }

            for (int i = 0; i < 4; i++) {

                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (isValid(nx, ny)) {

                    if (maze[nx][ny] != 1 && distance[nx][ny] == -1) {

                        distance[nx][ny] = distance[curr.x][curr.y] + 1;

                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return -1;
    }

    // DFS (Stack 사용)
    public int dfsUsingStack() {

        Stack<Point> stack = new Stack<>();

        boolean[][] visited = new boolean[SIZE][SIZE];

        int minDistance = Integer.MAX_VALUE;

        stack.push(new Point(1, 1, 0));

        while (!stack.isEmpty()) {

            Point curr = stack.pop();

            int x = curr.x;
            int y = curr.y;
            int depth = curr.depth;

            // 이미 방문한 경우
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // 먹이 발견
            if (maze[x][y] == 2) {
                minDistance = Math.min(minDistance, depth);
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {

                    if (maze[nx][ny] != 1 && !visited[nx][ny]) {

                        stack.push(new Point(nx, ny, depth + 1));
                    }
                }
            }
        }

        return minDistance;
    }

    // 범위 체크
    public boolean isValid(int x, int y) {

        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    // 미로 세팅
    public void settingMaze() {

        int index = 0;

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                maze[i][j] = copyArray[index++];
            }
        }
    }

    // 미로 출력
    public void showMaze() {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                System.out.print(maze[i][j] + " ");
            }

            System.out.println();
        }
    }

    // 거리 맵 출력
    public void showDistanceMap(int[][] distArr) {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                if (distArr[i][j] == -1) {
                    System.out.print(" - ");
                } else {
                    System.out.printf("%2d ", distArr[i][j]);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        new Shortest_len_maze().run();
    }
}