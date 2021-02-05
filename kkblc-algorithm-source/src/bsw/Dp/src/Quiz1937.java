import java.util.*;
public class Quiz1937 {

    static int n = 0;
    static int[][] map;
    static int[][] dp;
    static int[] tx = {1, -1, 0, 0};
    static int[] ty = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(dfs(i, j), ans);
            }
        }
        System.out.println(ans);
    }

    static int dfs(int i, int j) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int cnt = 1;
        for (int k = 0; k < 4; k++) {
            if(i + tx[k] >= 0 && i + tx[k] < n && j + ty[k] >= 0 && j + ty[k] < n) {
                if(map[i][j] < map[i + tx[k]][j + ty[k]]) {
                    cnt = Math.max(dfs(i + tx[k], j + ty[k]) + 1, cnt);
                    dp[i][j] = cnt;
                }
            }
        }
        return cnt;
    }
}
