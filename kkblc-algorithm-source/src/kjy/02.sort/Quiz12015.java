import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz12015 {
	/*
	 백준12015: https://www.acmicpc.net/problem/12015
	 가장 긴 증가수열을 찾는 문제로, 이분탐색을 활용하여 비교하면서 수열에 추가하면된다.
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		String str = "";
		
		try {
			cnt = Integer.parseInt(br.readLine());
			str = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		StringTokenizer st = new StringTokenizer(str);
		
		int value=0, left=0, mid=0, right=0;
		//배열에 수 담기
		while(st.hasMoreTokens()) {
			value = Integer.parseInt(st.nextToken());
			if(value>list.get(list.size()-1)) { //수열의 맨끝값보다 크다면 뒤에 추가
				list.add(value);
			}else {	// 수열의 맨끝값보다 작다면 이분탐색으로 위치를 찾아서 넣어준다.
				left = 0;
				right = list.size()-1;
				while(left<right) {
					mid = ( left + right ) / 2;  
                	if(value <= list.get(mid)) {
                    	right = mid;
                	}else {
                    	left = mid + 1;
                	}
				}
				list.set(right, value); //셋팅
			}
		}
		System.out.println( list.size()-1 );
	}
}
