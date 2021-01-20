import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
* Quiz 1931 그리디 알고리즘
* 1개의 회의실 N 사용표에서 제일 처음 떠올린 것 차지하는 크기에 대해 sort를 하는 게 어떨까? Nope
* 종료시간이 제일 작은 수를 차지하는 수를 찾아 소트를 하였다.
* */
public class Quiz1931 {

    static int[][] basket;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bfr.readLine());
        int startTime = 0;
        int endTime = 0;
        int min = 0;
        basket = new int[number][3];
        for(int i=0;number>i;i++){
            StringTokenizer token = new StringTokenizer(bfr.readLine());
            if(token.hasMoreTokens()){
                startTime = Integer.parseInt(token.nextToken());
                endTime = Integer.parseInt(token.nextToken());
                basket[i][0] = startTime;
                basket[i][1] = endTime;
            }
        }
        //함수형으로 소트를 한다. 종료시간을 기준으로 모아서 비교를 한다. 람다식을 사용한 것이다.
        Arrays.sort(basket, (a,b)-> a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);

        /* 람다식에서 생략된 식
        Comparator 인터페이스를 이용한다. 이 인터페이스의 구현체를 Arrays.sort같은 메서드의 추가인자로 넘기면
        정렬 기준을 누락된 클래스의 객체나 기존 정렬 기준을 무시하고 새로운 정렬 기준으로 객체를 정렬할 수 있다.
        Arrays.sort(basket, new Comparator<int[]>(){
            @Override
            public int compare(int []a,int []b){
                //종료시간을 기준으로 정렬하는 식
                if(a[1] == b[1]){  //종료시간이 같다면
                    return a[0]-b[0]; //시작시간으로 비교한다.
                }
                return a[1] - b[1];
            }
        });

        위 코드를 보면 Comparator 객체를 Arrays.sort의 두번째 인자로 넘겨서 람다 식과 같은 결과를 이끌어낸다.
        첫번째 인자가 두번째 인자보다 작다면 음수 크다면 양수를 리턴한다.

        그런데 어떻게 람다로 표현이 가능할까? --> Comparator 객체는 메서드가 하나 뿐인 함수형 인터페이스를 구현하기 떄문에
        람다함수로 대체가 가능하다.
        https://www.daleseo.com/java-comparable-comparator/
        */

        int cnt =0;
        for(int j=0;j<number;j++){
            if(basket[j][0] >= min){
                min = basket[j][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
