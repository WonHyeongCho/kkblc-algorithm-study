package cwh.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 링크: https://www.acmicpc.net/problem/1072
 * 제목: 게
 */

public class Quiz1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");

        long x = Long.parseLong(strings[0]);
        long y = Long.parseLong(strings[1]);
        long z = 100*y/x;

        if(z >= 99) {
            System.out.println("-1");
            return;
        }

        int left = 0;
        int right = 1000000000;
        int result = -1;

        while(left <= right) {
            int mid = (left+right)/2;
            long tmpZ = 100*(y+mid)/(x+mid);

            if(z >= tmpZ) {
                left = mid+1;
                result = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}