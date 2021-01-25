package cwh.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz1339 {
    static int N;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String data = br.readLine();

            for(int j = 0; j < data.length(); j++) {
                alphabet[data.charAt(j) - 'A'] += Math.pow(10, data.length()-j-1); // 알파벳 배열에 자리수만큼 더해줌
            }
        }

        List<Integer> alphabetList = Arrays.stream(alphabet).boxed().collect(Collectors.toList());
        alphabetList.sort(Collections.reverseOrder());

        int num = 9;
        int sum = 0;

        for(int a : alphabetList) {
            sum += a*num;
            num--;

            if(a == 0 || num == 0) {
                break;
            }
        }

        System.out.println(sum);
    }
}
