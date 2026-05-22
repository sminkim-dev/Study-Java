package Java.Univ.Practice_problem;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_len_maze {
    private int[][] maze = new int[10][10];
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

    // 좌표를 저장하기 위한 내부 클래스
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void run() {
        setting_maze();
        System.out.println("--- 기본 미로 구조 ---");
        show(maze);

        // 1. 거리를 기록할 배열 (방문하지 않은 곳은 -1로 초기화)
        int[][] distance = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                distance[i][j] = -1; 
            }
        }

        // 2. BFS를 위한 큐와 방향 배열 생성
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        // 시작점 세팅 (1, 1)
        queue.offer(new Point(1, 1));
        distance[1][1] = 0; // 시작점의 거리는 0

        int finalDistance = -1; // 먹이를 찾지 못했을 때의 기본값

        // 3. BFS 탐색 시작
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // 먹이(2)를 만났다면 현재까지의 거리를 저장하고 탈출!
            // if (maze[curr.x][curr.y] == 2) {
            //     finalDistance = distance[curr.x][curr.y];
            //     break;
            // }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                // 범위 체크 및 벽(1) 확인, 그리고 '아직 방문하지 않은 곳(-1)'인지 확인
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) {
                    if (maze[nx][ny] != 1 && distance[nx][ny] == -1) {
                        // 이전 칸의 거리 + 1 을 해준다.
                        distance[nx][ny] = distance[curr.x][curr.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        System.out.println("\n--- 각 칸별 이동 거리 맵 (계산 결과) ---");
        showDistanceMap(distance);

        System.out.println("\n==================================");
        if (finalDistance != -1) {
            System.out.println("★ 먹이까지의 최단 거리: " + finalDistance + " 칸");
        } else {
            System.out.println("먹이에 도달할 수 없습니다.");
        }
        System.out.println("==================================");
    }

    // 미로 출력용
    public void show(int[][] arr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 거리 배열 출력용 (벽은 [-]로 표기해서 보기 편하게 만듦)
    public void showDistanceMap(int[][] distArr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (distArr[i][j] == -1) {
                    System.out.print(" - "); // 벽이거나 갈 수 없는 곳
                } else {
                    System.out.printf("%2d ", distArr[i][j]); // 정렬을 위해 %2d 사용
                }
            }
            System.out.println();
        }
    }

    public void setting_maze() {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j] = copyArray[index++];
            }
        }
    }

    public static void main(String[] args) {
        new Shortest_len_maze().run();
    }
}