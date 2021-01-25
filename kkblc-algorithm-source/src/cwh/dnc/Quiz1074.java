package cwh.dnc;

import java.util.Scanner;

public class Quiz1074 {
    static int N, r, c, count;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();


        divide(0, 0, (int)Math.pow(2.0, N));
    }

    static void divide(int row, int col, int n) {
        if(row == r && col == c) {
            System.out.println(count);
            System.exit(0);
        }

        if(n == 1) {
            count++;
            return;
        }

        if(!(row <= r && r < row + n && col <= c && c < col +n )) {
            count += n * n;
            return;
        }

        divide(row, col, n/2);
        divide(row, col+n/2, n/2);
        divide(row+n/2, col, n/2);
        divide(row+n/2, col+n/2, n/2);
    }
}
