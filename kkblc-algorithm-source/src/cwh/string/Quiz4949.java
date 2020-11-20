package cwh.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 링크: https://www.acmicpc.net/problem/4949
 * 제목: 균형잡힌 세상
 */

public class Quiz4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> bracketStack = new Stack<>();
        Character bracket;
        String answer;

        while(true) {
            answer = "yes";
            String paragraph = br.readLine();

            if(paragraph.equals(".")) {
                return;
            }

            for(int i = 0; i < paragraph.length(); i++) {
                char c = paragraph.charAt(i);

                if(c == '.') {
                    break;
                }

                if(c == '[' || c == '(') {
                    bracketStack.push(c);
                } else if (c == ']') {
                    if(bracketStack.size() > 0){
                        bracket = bracketStack.pop();
                        if(bracket != '[') {
                            answer = "no";
                            break;
                        }
                    } else {
                        answer = "no";
                        break;
                    }
                } else if (c == ')') {
                    if(bracketStack.size() > 0) {
                        bracket = bracketStack.pop();
                        if(bracket != '(') {
                            answer = "no";
                            break;
                        }
                    } else {
                        answer = "no";
                        break;
                    }
                }
            }

            if(!bracketStack.empty()) {
                answer = "no";
            }

            bracketStack.clear();
            System.out.println(answer);
        }
    }
}