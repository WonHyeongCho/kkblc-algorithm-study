/*
* 취업을 위한 코딩테스트 1로 만들기
*
* 조건 1. x가 5로 나누어 떨어지면 5로 나눈다.
* 조건 2. x가 3으로 나누어 떨어지면 3으로 나눈다.
* 조건 3. x가 2로 나누어떨어지면 2로 나눈다.
* 조건 4. x에서 1을 뺀다.
* x가 1로 될때를 연산을 최소로 적용하여 구하라.
* */

import java.util.Scanner;

public class MakeOne {

    //DP테이블 초기화
    public static int [] d = new int[30001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //점화식 분석
        //a(i) = i 1로 만들기 위한 최소 연산 횟수
        //a(i) = min(a(i-1),a(i/2),a(i/3),a(i/5))+1
        int n = scanner.nextInt();
        int count=0;

        for(int i=2;i<=n;i++){//보텀업 방식
            //현재의 수에서 1을 빼는 경우에서 그보다 하나가 더 늘테니 1을 더한다.
            d[i] = d[i-1] +1;
            //현재의 수가 2로 나누어 떨어지는 경우
            if(i%2==0){
                d[i]=Math.min(d[i],d[i/2]+1);
            }
            if(i%3==0){
                d[i] = Math.min(d[i],d[i/3]+1);
            }
            if(i%5==0){
                d[i] = Math.min(d[i],d[i/5]+1);
            }

        }
        System.out.println(d[n]);

    }
}
