/*
제목 - 문자열을 정수로 바꾸기
링크 - https://programmers.co.kr/learn/courses/30/lessons/12925
* */

public class QuizStringToInt {

    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0)=='+'){
            answer = Integer.parseInt(s.substring(1,s.length()));
        }else if(s.charAt(0)=='-'){
            answer = -1*Integer.parseInt(s.substring(1,s.length()));
        }else{
            answer = Integer.parseInt(s);
        }
        return answer;
    }

    public static void main(String[] args) {
     QuizStringToInt bts = new QuizStringToInt();
     System.out.println(bts.solution("1234"));
    }


}
