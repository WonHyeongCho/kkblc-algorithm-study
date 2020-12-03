package cwh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 링크: https://www.acmicpc.net/problem/2493
 * 제목: 탑
 */

public class Quiz2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Top> topStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        String[] tops = br.readLine().split(" ");

        for(int i = 0; i < tops.length; i++) {
            Top top1 = new Top(i, Integer.parseInt(tops[i]));

            while (!topStack.empty()) {
                if(topStack.peek().number >= top1.number) { // 제일 위에꺼와 비교
                    result.add(topStack.peek().index+1);
                    topStack.push(top1);
                    break;
                }
                else {
                    topStack.pop();
                }
            }

            if(topStack.empty()) { // 스택이 비어있을 경우
                result.add(0);
                topStack.push(top1);
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(result.get(i)+ " ");
        }
    }

    static class Top {
        int index;
        int number;

        Top(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
