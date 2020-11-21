import java.util.*;
/*
* 문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
*
* 입출력 예
arr	answer
[1,1,3,3,0,1,1]	[1,3,0,1]
[4,4,4,3,3]	[4,3]
입출력 예 설명
입출력 예 #1,2
문제의 예시와 같습니다.
*
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
