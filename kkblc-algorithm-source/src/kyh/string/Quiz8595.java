package kyh.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 링크: https://www.acmicpc.net/problem/8595
 * 제목: 히든 넘버
 */

public class Quiz8595 {
    public static void main(String[] args) throws IOException {
        int num = 0;
        String hiddenStr = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        hiddenStr = br.readLine();


        System.out.print(solution(hiddenStr));
    }

    static long solution(String hiddenStr) {

        long answer = 0;
        int tempNum = 0;
        int hiddencnt = 0; //hiddenNumber의 숫자를 세는 변수

        //입력받은 스트링 길이만큼 돌림.
        for(int i = 0; i< hiddenStr.length() ; i++){
            //스트링의 i번째 문자열이 A~Z,a~z인지 확인
            if((int)hiddenStr.charAt(i) >= 65 && (int)hiddenStr.charAt(i) <=122){
                hiddencnt = 0; //i번째 문자열이 숫자가 아니므로 count는 0으로 초기화
            }else{ //숫자라면 tempNum이라는 임시 숫자에 더함.
                hiddencnt++; //i번째 문자열이 숫자이므로 count 증가
                tempNum = (int)hiddenStr.charAt(i)-48 + tempNum*10; //이전 tempNum과 i번째 숫자를 더함.
            }
            //현재 문자열이 문자거나 마지막번째 문자일 경우 지금까지의 tempNum을 더함.
            if(hiddencnt==0 || i == hiddenStr.length()-1) {
                answer += tempNum;
                tempNum = 0;
            }
            //조건중에서 hiddenNumber는 6자리를 초과하지 않는다고 함.
            if(hiddencnt>6){
                return 0;
            }
        }
        return answer;
    }
}
