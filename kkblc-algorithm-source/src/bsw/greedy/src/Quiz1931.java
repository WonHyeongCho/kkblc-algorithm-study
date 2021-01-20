import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* Quiz 1931 그리디 알고리즘
* 1개의 회의실 N 사용표에서 제일 처음 떠올린 것 차지하는 크기에 대해 sort를 하는 게 어떨까?
*
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
        //함수형으로 소트를 한다. 제일 짧은 것을 모아서 비교를 한다.
        Arrays.sort(basket, (a,b)-> a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);
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
