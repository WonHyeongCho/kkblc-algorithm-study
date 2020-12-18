package lsy.dfs;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class QuizTravel {
	public static final int FAIL = -1;
	public static final int SUCCEED = 0;
	
	public String[] solution(String[][] tickets) {
        String[] answer;
        ArrayList<String> list = new ArrayList<String>();
        
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        PriorityQueue<String> que;
        for(String[] arr : tickets) {
        	que = map.getOrDefault(arr[0], new PriorityQueue<String>());
        	que.add(arr[1]);
        	map.put(arr[0], que);
        }
        list.add("ICN");
        String temp =map.get("ICN").poll();
        String next;
        while(dfs(map, temp, list, tickets.length+1)== FAIL) {
        	next = map.get("ICN").poll();
        	map.get("ICN").add(temp);
        	temp = next;
        	list.remove(list.size()-1);
        }
        answer = list.stream().toArray(size -> new String[list.size()]);
        return answer;
    }
	
	public int dfs(HashMap<String, PriorityQueue<String>> map, 
			String department, ArrayList<String> list, int lastIndex) {
		list.add(department);

		if(map.get(department)==null || map.get(department).size()==0) {
			if(list.size()== lastIndex) {
				return SUCCEED;
			}else {
				return FAIL;
			}
		}
		String temp = map.get(department).poll();
		String next;
		while(dfs(map, temp, list, lastIndex)== FAIL) {
			list.remove(list.size()-1);
			if(map.get(department).size()==0) {
				map.get(department).add(temp);
				return FAIL;
			} 
        	next = map.get(department).poll();
        	map.get(department).add(temp);
        	temp = next;
        	
        }
		return SUCCEED;
	}
	public static void main(String[] args) {
		QuizTravel q = new QuizTravel();
		String[] arr = q.solution(new String[][] {{"ICN","JFK"},{"ZBC", "HND"},{"ICN","ZBC"},{"HND","ICN"},{"JFK","WOW"}});
		System.out.println(Arrays.toString(arr));
	}
/*
 * ,{"ICN", "SFO"},{"ICN", "ATL"},
			{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}
 * 
 * */
}
