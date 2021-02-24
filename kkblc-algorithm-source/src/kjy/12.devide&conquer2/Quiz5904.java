import java.util.Scanner;

public class Quiz5904 {
	public static char answer; 
	/*
	 * 출처 : https://www.acmicpc.net/problem/5904
	 * 풀이: https://kwoncorin.tistory.com/54 
	 * 어려워서 답 봤습니다
	 * 
	 * 1.우선은 문자열 크기가 입력된 num값보다 크거나 같아질때까지 문자열을 늘려준다.
	 * 2.충분히 늘렸다면 그때부터 num을 찾아간다
	 *   - 추가된문자열 이후 부분인경우
	 *   - 추가된문자열 맨앞인경우
	 *   - 추가된문자열 두번째~끝인경우
	 *   
	 *   위에 구분법을 문자열 moomooomoo 로 예를 들자면
	 *   아래와 같다
	 *   - moomooo/moo  : 새로 추가된 mooo 뒤에부분인경우
	 *   - moo/m 		: 새로 추가된 문자열의 맨 앞부분
	 *   - moom/ooo     : 새로 추가된 문자열중 맨앞을 제외한 나머지부분
	 */ 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int num = sc.nextInt(); 
		Moo(num); 
		System.out.println(answer); 
		sc.close(); 
	}
	public static void Moo(int num){ 
		int size=3; 
		int index=3; //가운데 추가되는 문자열 
		
		if(num==1){ 		//num=1이면 m
			answer = 'm'; 
	    }else if(num<=3) {  //num=1or2라면 o
	    	answer = 'o'; 
	    }else{ 
	    	while(size<num){ 
	    		index++;	//o가 하나 더 붙는다.
	    		size=size*2+index;  //현재문자열*2+o가 하나 더 붙은 새로운문자열
	    	} 
	    	
	    	int front_back = (size-index)/2; 
	    	
	    	if(size-front_back+1<=num){    	// moomooomoo 여기서 추가된 mooo다음에 오는 moo범위에 있을경우
	    		Moo(num-size+front_back);   // 전체사이즈에서 moomooo만큼 빼주고, 재귀호출을 해준다
	    	}else if(num==front_back+1) {	// 추가된 mooo의 맨앞일경우
	    		answer = 'm'; 
	    	}else{							// 추가된 mooo의 나머지 ooo일 경우
	    		answer = 'o';
	    	} 
	    }
	}
}
