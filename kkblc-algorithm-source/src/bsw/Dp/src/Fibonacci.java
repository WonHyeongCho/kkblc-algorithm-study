/*
* 탑다운 보텀업 방식 차이
*
* */
import java.util.*;
public class Fibonacci {
    //탑 다운 방식 [재귀방식]

    public static long[] d = new long[100];

    //피보나치 함수를 재귀함수로 구현
    public static int fibo(int x){
        if(x == 1 || x == 2){
            return 1;
        }
        //이미 계산한 적 있는 문제라면 그대로 반환
        if(d[x] != 0){
            return d[x];
        }
        //아직 계산하지 않은 문제면 점화식에 따라 결과 반환
        d[x] = fibo(x-1) + fibo(x-2);
        return d[x];
    }

    public static void main (String[] args)
    {
        System.out.println(fibo(4));
    }

}
