package cwh.string;

/*
 * 링크: https://www.acmicpc.net/problem/8595
 * 제목: 히든 넘버
 */

/*
 * 풀이:
 * 아스키코드로 문자와 숫자를 구별,
 * A ~ Z --> 65 ~ 90
 * a ~ z --> 97 ~ 122
 *
 * 히든케이스:
 * 1. 히든넘버가 마지막으로 끝날 수 도 있음.
 * 2. 결과 값이 int형 범위를 넘어갈 수 있음.
 * 3. 히든 넘버가 6자리를 넘지 않음.
 *
 */

import java.util.Scanner;

public class Quiz8595 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String str = in.next();

        long answer = solution(n, str);
        System.out.print(answer);
    }

    static private long solution(int n, String str) {

        long sum = 0;
        StringBuilder strNumber = new StringBuilder("");

        for(int i = 0; i < n; i++) {
            char a = str.charAt(i);
            int asciiCode = (int)a;

            if(!((asciiCode >= 65 && asciiCode <= 90) ||
                    (asciiCode >= 97 && asciiCode <= 122))) { // 아스키코드가 65 ~ 90, 97 ~ 122 사이가 아닐 경우
                strNumber.append(a);
            } else {
                if(!strNumber.toString().equals("")){
                    sum += Integer.parseInt(strNumber.toString());
                    strNumber.setLength(0);
                }
            }
        }

        if(!strNumber.toString().equals("")){ // 히든넘버가 마지막일 경우
            sum += Integer.parseInt(strNumber.toString());
        }

        return sum;
    }
}