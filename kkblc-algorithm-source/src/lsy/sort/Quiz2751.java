package lsy.sort;
/*
 * https://www.acmicpc.net/problem/2751
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quiz2751 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N;i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+"\n");
			}
			System.out.println(sb);
		}catch(IOException e) {
			
		}
	}

}

