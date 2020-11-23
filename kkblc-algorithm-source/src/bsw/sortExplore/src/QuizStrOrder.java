/*
*  url - https://programmers.co.kr/learn/courses/30/lessons/12915
*  문자열 마음대로 정렬하
* */

import java.util.*;
public class QuizStrOrder {

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<strings.length;i++){

            strings[i].substring(n,n+1);
            String tempString = strings[i].substring(n,n+1)+strings[i];
            arr.add(tempString);
        }
        Collections.sort(arr);

        answer = new String[arr.size()];
        for(int j=0;j<arr.size();j++){
            answer[j] = arr.get(j).substring(1, arr.get(j).length());
        }



        return answer;
    }

    public static void main(String[] args) {
        QuizStrOrder bts = new QuizStrOrder();
        String [] strings = {"sun","bed","car"};
        int n = 1;
        bts.solution(strings,n);
    }
}
