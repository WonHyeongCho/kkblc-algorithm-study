package cwh.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Quiz1931 {
    static int N;
    static int reservation[][]; // 회의실 예약

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        reservation = new int[N][2];

        int min;
        int count = 0;

        for(int i = 0; i < N; i++) {
            String data = br.readLine();
            reservation[i][0] = Integer.parseInt(data.split(" ")[0]);
            reservation[i][1] = Integer.parseInt(data.split(" ")[1]);
        }

        Arrays.sort(reservation, new Comparator<int[]>() { // 오름차순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) {
                    return -1;
                }
                else if(o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                else {
                    return 1;
                }
            }
        });

//        for(int i = 0; i < N; i++) {
//            System.out.println("(" + reservation[i][0] + ", " + reservation[i][1] + ")");
//        }

        min = reservation[0][1];
        count++;

        for(int i = 1; i < reservation.length; i++) {
            if(reservation[i][0] >= min) {
                min = reservation[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
