import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Quiz {
	public static final String YES = "YES";
	public static final String NO = "NO";
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tcNum = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<tcNum;i++) {
				int arrSize = Integer.parseInt(br.readLine());
				String[] arr = new String[arrSize];
				ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
				for(int j=0;j<10;j++) {
					list.add(new ArrayList<String>());
				}
				String temp;
				for(int j=0;j<arrSize;j++) {
					temp= br.readLine();
					arr[j] = temp;
					//System.out.println((int)temp.charAt(0)-48);
					list.get((int)temp.charAt(0)-48).add(temp);
				}
				sb.append(solution(list, arr) + "\n");
			}
			System.out.println(sb);
		}catch(IOException e) {
			
		}
	}
	
	public static String solution(ArrayList<ArrayList<String>> list,String[] arr) {
		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}else {
					if(s1.length()>s2.length()) {
						return 1;
					}else {
						return -1;
					}
				}
			}
		});
		//System.out.println("ARR: "+Arrays.toString(arr));
		int idx;
		String compare;
		ArrayList<String> now ;
		for(int i=0;i<arr.length;i++) {
			compare = arr[i];
			idx = (int)compare.charAt(0)-48;
			now = list.get(idx);
			for(int j=0;j<now.size();j++) {
				if(now.get(j).startsWith(compare)&& !now.get(j).equals(compare)) {
					return NO;
				}
			}
		}
		return YES;
	}

}
