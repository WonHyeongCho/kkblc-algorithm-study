package lsy.dnc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2630 {
	public static int one;
	public static int zero;
	public static String[][] map;
	public static String none = "NO";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		map = new String[size+1][size+1];
		
		StringTokenizer st;
		
		for(int i=1; i<=size; i++) {
			st = new StringTokenizer(br.readLine());
			int j=1;
			while(st.hasMoreTokens()) {
				map[i][j] = st.nextToken();
				j++;
			}
		}
		find(size, size, size);
		System.out.println(zero);
		System.out.println(one);
	}
	public static String find(int x, int y, int len) {
		if(len==1) return map[x][y];
		
		String rightTop = find(x-len/2, y-len/2, len/2);
		String rightBottom = find(x, y-len/2, len/2);
		String leftTop = find(x-len/2, y, len/2);
		String leftBottom = find(x, y, len/2);
		if(rightTop.equals(rightBottom) && rightBottom.equals(leftTop) && leftTop.equals(leftBottom)) {
			if(rightTop.equals("1") || rightTop.equals("0")) {
				return rightTop;
			}
		}
		add(rightTop);
		add(rightBottom);
		add(leftTop);
		add(leftBottom);
		
		return none;
	}
	public static void add(String str) {
		if(str.equals("1")) {
			one++;
		}else if(str.equals("0")){
			zero++;
		}
	}

}
