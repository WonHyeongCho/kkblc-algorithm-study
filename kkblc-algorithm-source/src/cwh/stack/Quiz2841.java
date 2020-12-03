package cwh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 링크: https://www.acmicpc.net/problem/2841
 * 제목: 외계인의 기타연주
 */


public class Quiz2841 {
    static int N;
    static int P;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String example = br.readLine();
        N = Integer.parseInt(example.split(" ")[0]);
        P = Integer.parseInt(example.split(" ")[1]);
        result = 0;
        Stack<Integer>[] stack = new Stack[7];

        for(int i = 0; i < 7; i++) {
            stack[i] = new Stack<>();
        }

        for(int i = 0; i < N; i++) {
            String next = br.readLine();
            int line = Integer.parseInt(next.split(" ")[0]);
            int fret = Integer.parseInt(next.split(" ")[1]);

            while (!stack[line].empty()) {
                if(stack[line].peek() < fret) { // 현재 플랫보다 클 경우
                    stack[line].push(fret);
                }
                else if (stack[line].peek() > fret) { // 작을 경우
                    stack[line].pop();
                }
                else { // 같으면 아무것도 안함
                    break;
                }
                result++;
            }

            if(stack[line].empty()) { // 스택에 값이 없을 경우
                stack[line].push(fret);
                result++;
            }
        }

        System.out.println(result);
    }
}