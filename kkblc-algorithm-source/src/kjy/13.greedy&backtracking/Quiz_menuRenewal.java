import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Quiz_menuRenewal {
	/*
	 * 출처: https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
	 * 풀이: hashMap을 사용해서 각 문자열을 재귀적으로 조합해서 key값으로 저장시키면서,
	 *      중복값이 있을경우 value+=1해준다.
	 *      마지막에 value>=2인것들을 string배열에 담아준다
	 * 		그중에서 각 개수별로 가장 많이 선택된 조합을 세트로 정한다.
	 */
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static String curStr;

	static int[] maxNum = new int[11];
	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		
		String[] ans = solution(orders, course);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
			
	}
	 public static String[] solution(String[] orders, int[] course) {
	        ArrayList<String> sList = new ArrayList<>();
			
	        for(int i=0; i<orders.length; i++) { //order수만큼 반복수행한다.
				curStr = orders[i];
				char[] charArr = curStr.toCharArray(); //String to Char Array
				Arrays.sort(charArr); //char Array 알파벳 순 정렬
				curStr = String.valueOf(charArr);
				
				makeString("",0,course);
			}
			
			for(String str : map.keySet()) {
				if(map.get(str)>1) {
					if(map.get(str)>maxNum[str.length()]) {
						maxNum[str.length()] = map.get(str);
					}
				}
			}
			
			for(String str : map.keySet()) {
				if(map.get(str)==maxNum[str.length()]) {
					sList.add(str);
				}
			}
			
			String[] answer = new String[sList.size()];
			
			for(int i=0; i<sList.size(); i++)
				answer[i] = sList.get(i);
			
			Arrays.sort(answer);
	        return answer;
	    }
		public static void makeString(String str, int index, int[] course) {
			if(index>=curStr.length()) {
				boolean flag = false;
				for(int i=0; i<course.length;i++) {
					if(str.length()==course[i]) { //선택된음식갯수 == 코스수
						flag = true;
						break;
					}
				}

				if(!flag)	//코스 갯수에 속하지않으면 return
					return;
					
				if(map.containsKey(str)) { //이미 있는조합
					int cnt = map.get(str);
					map.put(str, cnt+1);
				}else { //처음
					map.put(str, 1);
				}
				return;
			}
			
			makeString(str+curStr.charAt(index), index+1, course); //index번째 뽑는경우
			makeString(str, index+1, course); //index번째 안뽑는경우
			
		}
	
}
