package cwh.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz1747 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str = br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(String str) {
        int number = Integer.parseInt(str);

        if(number == 1){ // 숫자가 1일때 처리
            return 2;
        }

        while(true) {
            boolean palindromeFlag = true;
            boolean primeNumberFlag = true;

            String numberStr = Integer.toString(number);
            int middle = numberStr.length()/2;

            for(int i = 0; i < middle; i++) { // 펠린드롬 검사
                if(!(numberStr.charAt(i) == numberStr.charAt(numberStr.length()-1-i))) {
                    palindromeFlag = false;
                    break;
                }
            }

            if(palindromeFlag) { // 펠린드롬 통과
                for(int i = 2; i <= Math.sqrt(number); i++) { // 소수 검사
                    if(number%i == 0) {
                        primeNumberFlag = false;
                        break;
                    }
                }

                if(primeNumberFlag) { // 소수일 경우
                    return number;
                }
            }

            number++;
        }
    }
}
