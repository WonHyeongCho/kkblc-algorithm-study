package lsy.sort;
/*
 * https://www.acmicpc.net/problem/12015
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz12015 {
	public static int[] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int k=0;
			while(temp.hasMoreTokens()) {
				arr[k++]= Integer.parseInt(temp.nextToken());
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			int last;
			int val;
			for(int i=0;i<N;i++) {
				last= list.get(list.size()-1);
				val = arr[i];
				if(val>last) {
					list.add(val);
				}else {
					int left=0;
					int right=list.size()-1;
					int mid;
					while(left<right) {
						mid = (left+right)/2;
						if(list.get(mid)>=val) {
							right = mid;
						}else {
							left=mid+1;
						}
					}
					list.set(right, val);
				}
				System.out.println(list);
			}
			System.out.println(list.size()-1);
			
		}catch(IOException e) {
			
		}
	}
}
