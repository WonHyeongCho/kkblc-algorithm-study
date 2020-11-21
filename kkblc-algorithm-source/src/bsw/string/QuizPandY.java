/*
링크 - https://programmers.co.kr/learn/courses/30/lessons/12916
제목 - 문자열 내 p와 y의 개수

* */

public class QuizPandY {
    boolean solution(String s) {
        boolean answer = true;

        String low = s.toLowerCase();
        int numP = 0;
        int numY = 0;

        for (int i = 0; i < s.length(); i++) {
            if (low.charAt(i) == 'p') {
                numP++;
            } else if (low.charAt(i) == 'y') {
                numY++;
            }

        }
        answer = numP == numY;
        return answer;
    }

    public static void main(String[] args) {

        QuizPandY btn = new QuizPandY();
        String s = "pPoooyY";
        btn.solution(s);
        System.out.println(btn.solution(s));
    }
}
