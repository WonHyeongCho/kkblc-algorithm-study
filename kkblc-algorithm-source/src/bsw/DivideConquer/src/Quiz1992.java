import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz1992 {

    static StringBuilder sb = new StringBuilder();
    static int[][] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        input = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(temp[j]);
            }
        }
        check(0, 0, n);
        System.out.println(sb);
    }

    public static void check(int x, int y, int n) {
        int first = input[x][y];
        boolean c = false;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (input[i][j] != first) {
                    split(x, y, n);
                    c = true;
                    break;
                }
            }
            if (c) {
                break;
            }
        }

        if (!c) {
            if (first == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
    }

    public static void split(int x, int y, int n) {
        int newN = n / 2;

        sb.append("(");
        check(x, y, newN);
        check(x, y + newN, newN);
        check(x + newN, y, newN);
        check(x + newN, y + newN, newN);
        sb.append(")");
    }
}
