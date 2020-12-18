import java.io.*;
import java.util.*;
/*
 * dfs는 생각도 안나서 바로 gg치고 풀이를 봄.
 * https://dragon-h.tistory.com/14
 *
 * */

public class Quiz1012 {
    static int xLatitude;
    static int yLatitude;
    static boolean arr[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int cabbage;
        //첫줄에는 테스트 개수 T가 주어진다. (몇 번 시행해야 하는지 나온다.)
        int testLength = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < testLength; i++) {
            StringTokenizer token = new StringTokenizer(bufferedReader.readLine());
            xLatitude = Integer.parseInt(token.nextToken());
            yLatitude = Integer.parseInt(token.nextToken());
            int cnt = Integer.parseInt(token.nextToken());
            arr = new boolean[xLatitude][yLatitude];
            check = new boolean[xLatitude][yLatitude];
            cabbage = 0;

            for (int j = 0; j < cnt; j++) {
                token = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                //행렬이니 n n  (2,2) 이걸 가르킬때 arr(1,0) 행 열이 아니라 열
                //    이 n n
                arr[x][y] = true;
            }

            for (int cy = 0; cy < yLatitude; cy++) {
                for (int cx = 0; cx < xLatitude; cx++) {
                    if (CheckLocation(cy, cx) == true) {
                        cabbage++;
                        dfs(cy, cx);
                    }
                }
            }
            bufferedWriter.write(cabbage + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }

    }
    public static boolean CheckLocation(int row, int col){

        if (row < 0 || row > yLatitude || col < 0 || col >= xLatitude) return false;

        if (check[row][col] == true || arr[row][col] == false) return false;

        return true;
    }

    public static void dfs(int x, int y){
        check[x][y] = true;
        //상의 좌표
        if (CheckLocation(x - 1, y)) dfs(x - 1, y);
        //하의 좌표
        if (CheckLocation(x + 1, y)) dfs(x + 1, y);
        //좌의 좌표
        if (CheckLocation(x, y - 1)) dfs(x, y - 1);
        //우의 좌료
        if (CheckLocation(x, y + 1)) dfs(x, y + 1);
    }
}

