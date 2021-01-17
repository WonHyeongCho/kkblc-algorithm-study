package lsy.dp;

//https://programmers.co.kr/learn/courses/30/lessons/42895

import java.util.ArrayList;
import java.util.HashSet;

public class QuizN {
	public int solution(int N, int numbs) {
        int answer = 1;
        long number = numbs;
        if(N==number) {
        	return 1;
        }
        HashSet<Long> visited = new HashSet<Long>();
        ArrayList<ArrayList<Long>> list = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> firstList = new ArrayList<Long>();
        firstList.add((long)N);
        firstList.add((long)-N);
        list.add(firstList);
        visited.add((long)N);
        visited.add((long)-N);
        
        int idx = 1;
        
        while(true) {
        	ArrayList<Long> nowList = new ArrayList<Long>();
        	answer++;
        	int first, second;
        	for(int i=0;i<idx;i++) {
        		first = i;
        		second = idx-1 - first;
        		if(first > second) break;

        		ArrayList<Long> firstArray = list.get(first);
        		ArrayList<Long> secondArray = list.get(second);
        		for(int j=0;j<firstArray.size();j++) {
        			for(int k=0; k<secondArray.size();k++) {
        				if(check(visited, nowList, firstArray.get(j)+secondArray.get(k), number)) {
        					return answer;
        				};
        				if(check(visited, nowList, firstArray.get(j)-secondArray.get(k), number)) {
        					return answer;
        				};
        				if(check(visited, nowList, secondArray.get(k)-firstArray.get(j),number)) {
        					return answer;
        				}
        				if(check(visited, nowList, firstArray.get(j)*secondArray.get(k), number)) {
        					return answer;
        				};
        				if(secondArray.get(k)!=0) {
        					if(check(visited, nowList, firstArray.get(j)/secondArray.get(k), number)) {
        						return answer;
        					};
        				}
        				if(firstArray.get(j)!=0){
        					if(check(visited, nowList, secondArray.get(k)/firstArray.get(j), number)) {
        						return answer;
        					}
        				}
        			}
        		}
        	}
        	if(answer ==8) {
        		return -1;
        	}
        	int settingNum = setNumber(answer, N);
        	if(settingNum == numbs) return answer;
        	visited.add((long)settingNum);
        	nowList.add((long)settingNum);
        	list.add(nowList);
        	idx++;
        }
   
    }
	
	public boolean check(HashSet<Long> visited, ArrayList<Long> nowList, long checkNum,  long findNum) {
		if(checkNum== findNum) return true;
		if(!visited.contains(checkNum)) {
			visited.add(checkNum);
			nowList.add(checkNum);
		}
		return false;
	}
	
	public int setNumber(int answer , int N) {
		int num = N;
		for(int i=0; i<answer-1;i++) {
			num = num*10 +N;
		}
		return num;
	}
	
	public static void main(String[] args) {
		QuizN q = new QuizN();
		int ans = q.solution(5, 12);
		System.out.println("ans: "+ans);
	}

}
