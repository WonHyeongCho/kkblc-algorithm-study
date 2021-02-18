import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz2630 {

    static int[] cnt = new int[2];
    static int[][] paper;


    public static void main(String[] args) throws Exception{
        /* 읽어 봅시다~~ 첫번째에 N*N 개의 상자를 놓아둔다 */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        paper = new int[N][N];
        StringTokenizer str;
        /** 좋아 세팅을 했어요~!
          **/
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++)
                paper[i][j] =Integer.parseInt(str.nextToken());
        }
        /**
         * 이제 세팅을 한 것을 divide하는 작업이 필요해요!
         * */
        divide(N, 0, 0);
        for (int n : cnt)
            System.out.println(n);
    }

    static void divide(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++)
                if (paper[i][j] != paper[y][x]) {
                    divide(n / 2, y, x);
                    divide(n / 2, y + n / 2, x);
                    divide(n / 2, y, x + n / 2);
                    divide(n / 2, y + n / 2, x + n / 2);
                    return;
                }
        }
        cnt[paper[y][x]]++;
    }

}
