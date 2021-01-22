package cwh.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 링크: https://www.acmicpc.net/problem/1946
 * 제목: 신입사원
 * --> Scanner 보다는 Br이 더 빠르다
 *
 */

public class Quiz1946 {
    static int T;
    static int N;
    static int[][] result;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        T = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            result = new int[N][2];
            for(int j = 0; j < N; j++) {
                String data = br.readLine();
                result[j][0] = Integer.parseInt(data.split(" ")[0]);
                result[j][1] = Integer.parseInt(data.split(" ")[1]);
            }

            // 서류전형 순으로 정렬
            Arrays.sort(result, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int answer = 1; // 서류면접 1등은 무조건 뽑는다
            int iRank = result[0][1]; // 서류면접 1등의 인터뷰 점수

            for(int j = 1; j < N; j++) {
                if(result[j][1] < iRank) { // 뽑힌 사람의 인터뷰 점수보다 높을 경우
                    answer++;
                    iRank = result[j][1];
                }
            }

            System.out.println(answer);
        }
    }
}
