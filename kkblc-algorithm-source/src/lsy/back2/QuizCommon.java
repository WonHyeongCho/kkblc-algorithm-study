package lsy.back2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class QuizCommon {
	
	HashMap<String, Integer> map;
    int max = 0;

	public String[] solution(String[] orders, int[] course) {
       StringBuilder sb =  new StringBuilder();
       PriorityQueue<String> pq = new PriorityQueue<String>();
      
       for(int i=0; i<course.length;i++) {
    	   max = 0;
    	   map = new HashMap<String, Integer>();
    	   for(int j=0; j< orders.length;j++) {
    		   char[] orderArr = orders[j].toCharArray();
    		   Arrays.sort(orderArr);
    		   find(orderArr,0,course[i],sb);
    		   sb.setLength(0);
    	   }
    	   
    	   for(String str : map.keySet()) {
    		   int value = map.get(str);
    		   if(value ==max && max >1) {

    			   pq.add(str);
    		   }
    	   }
    	   System.out.println("--keyMAp-----------------------");
    	   for(String ket: map.keySet()) {
    		   System.out.println(ket + " : " + map.get(ket));
    	   }
    	   System.out.println("--EndkeyMAp-----------------------");

    	   
       }
       String[] answer = new String[pq.size()];
       int idx = 0;
       while(pq.size()>0) {
    	   answer[idx] = pq.poll();
    	   idx ++;
       }
       return answer;
    }
	
	public void find(char[] arr, int start, int courseSize, StringBuilder sb) {
		System.out.println(arr + " : " + start + " : " + courseSize + " : " + sb.toString());
		if(sb.length() == courseSize) {
			int value = map.getOrDefault(sb.toString(), new Integer(0));
			map.put(sb.toString(), value+1);
			max = value +1 > max ? value+1: max;
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		String temp = sb.toString();
		for(int i=start; i<arr.length;i++) {
			char c = arr[i];
			StringBuilder sbtemp = new StringBuilder();
			sbtemp.append(temp);
			sbtemp.append(c);
			find(arr, i+1, courseSize, sbtemp);
		}
	}

	public static void main(String[] args) {
		QuizCommon q = new QuizCommon();
		//String[] arr = q.solution(new String[] {"ABCFG",  "CDE","AC", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
		String[] arr = q.solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4});

		System.out.println(Arrays.toString(arr));
	}

}
