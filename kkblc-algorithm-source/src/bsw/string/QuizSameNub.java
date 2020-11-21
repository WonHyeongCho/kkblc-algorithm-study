import java.util.*;
/*
링크 - https://programmers.co.kr/learn/courses/30/lessons/12906
제목 -같은 숫자는 싫어
* Sangwoo
* */

public class QuizSameNub {
    public int[] solution(int []arr) {


//        연속된 중복을 제거한다. 배열의 길이?
//        int same = -1;
//        int irr =  0;
//
//        int [] list = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++){
//            if (same == arr[i]) {
//                //넘어가~
//            } else {
//                same = arr[i];
//                list[irr] = same;
//                irr++;
//            }
//        }



        //int [] arr 을 ArrayList로 for문을 사용하여 담는다.
        List<Integer> list = new ArrayList<>();

        int temp = -1;//임시값을 -1로 초기화
        for (int i: arr) {
            if(temp != i){
                temp = i;
                list.add(temp);
            }

        }
        int [] answer = list.stream().mapToInt(i->i).toArray();
        //람다 표현식


        return answer;
    }
    public static void main(String[] args) {
        QuizSameNub obj = new QuizSameNub();
        int [] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(obj.solution(arr)));
    }
}
