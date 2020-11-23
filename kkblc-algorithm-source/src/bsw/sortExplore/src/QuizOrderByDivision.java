/*
* url - https://programmers.co.kr/learn/courses/30/lessons/12910
* 제목 - 나누어 떨어지는 숫자 배열
 * */
import java.util.*;

public class QuizOrderByDivision {


    int[] solution(int[] arr, int divisor) {

        Arrays.sort(arr);
        List<Integer> save = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {


            if (arr[i] % divisor == 0) {
                save.add(arr[i]);
            }
        }
        if (save.size() == 0) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = save.stream().mapToInt(i -> i).toArray();
            return answer;
        }
    }


    public static void main(String[] args) {
        QuizOrderByDivision bts = new QuizOrderByDivision();
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        bts.solution(arr, divisor);
    }

}
