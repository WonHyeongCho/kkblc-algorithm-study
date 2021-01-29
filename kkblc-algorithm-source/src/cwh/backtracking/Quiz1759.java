package cwh.backtracking;

/*
 * 제목: 암호 만들기
 * 링크: https://www.acmicpc.net/problem/1759
 * 해설:
 */

import java.util.Arrays;
import java.util.Scanner;

public class Quiz1759 {
    static int C, L;
    static char[] password; // 문자 저장 배열
    static boolean[] flags = new boolean[26]; // 문자를 저장했는지 안했는지 배열
    static char[] chars;
    static int consonant; // 자음
    static int vowel; // 모음

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();
        chars = new char[C];
        password = new char[L];

        for(int i = 0; i < C; i++) {
            chars[i] = sc.next().charAt(0);
        }

        Arrays.sort(chars);

        for(int i = 0; i < L; i++) {
            solve(0, chars[i]);
        }
    }

    static void solve(int index, char c) {
        if(check(c)) { // 해당 문자가 쓰였는지 검사
            flags[c-'a'] = true;
            password[index] = c;

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // 모음 체크
                vowel++;
            } else { // 자음 체크
                consonant++;
            }

            if(index == L-1) { // 다 넣었을 경우
                if(vowel >= 1 && consonant >= 2){ // 자음 모음 개수 체크
                    for(int i = 0; i < L; i++) {
                        System.out.print(password[i]);
                    }
                    System.out.println();
                }
            }
            else {
                for(int i = 0; i < C; i++) {
                    if(password[index] <= chars[i]) { // 증가하는 경우
                        solve(index + 1, chars[i]);
                    }
                }
            }

            flags[c-'a'] = false;

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // 모음 체크
                vowel--;
            } else { // 자음 체크
                consonant--;
            }
        }
    }

    static boolean check(char c) {
        return !flags[c-'a'];
    }
}
