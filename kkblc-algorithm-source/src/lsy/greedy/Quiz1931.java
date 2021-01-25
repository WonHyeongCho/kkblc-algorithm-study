package lsy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Quiz1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[1]== arr2[1]) {
					return arr1[0]-arr2[0];
				}
				return arr1[1]-arr2[1];
			}
		});
		int[] choice = arr[0];
		int answer = 1;
		for(int i=1; i< N; i++) {
			if(arr[i][0] >= choice[1]) {
				answer++;
				choice = arr[i];
			}
		}
		System.out.println(answer);
		
	}

}
