
public class Quiz_Joystick {
	/*
	 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42860
	 * 풀이: 왼쪽으로갈지, 오른쪽으로갈지 정한다('A'가 아닌 문자가 있는 위치로 이동할때 더 거리가 짧은쪽 선택)
	 *      이름위치만큼 조이스틱을 조작한다.( '?'-'A')
	 * 		이때 다음알파벳순서로 조작할지, 이전알파벳순서로 조작할지는 중간지점인 알파벳 'N'을 기준으로한다
	 *      'N'까지는 다음순서로 조작하고, 'N'이후 알파벳은 이전알파벳순서로 'Z'쪽으로 찾아가도록 조작한다.
	 */
	public static void main(String[] args) {
		String str = "JEROEN";
		
		System.out.println(solution(str));
	}
	public static int solution(String name) {
		 int answer = 0, curIndex = 0, nameLen=name.length();
		 
		 boolean[] visited = new boolean[nameLen];
		 
		 for(int i=0; i<nameLen; i++) {
			 if(name.charAt(i)=='A') {
				 visited[i] = true; //이미 'A'인곳은 조작이 필요없기때문에 true처리
			 }
		 }
		 
		 //첫번째위치 조작
		 if(!visited[curIndex]) {
			 if(name.charAt(curIndex)-'A'<13) {
				 answer+=(name.charAt(curIndex)-'A');
			 }else {
				 answer+=('Z'-name.charAt(curIndex)+1); //뒤에서부터 센다
			 }
			 visited[curIndex] = true;
		 }
		 
		 while(true) {
			 boolean flag = true;
			 
			 //모두 다 방문했으면 break;
			 for(int i=0; i<nameLen; i++) {
				 if(!visited[i]) {
					 flag = false;
					 break;		 
				 }
			 }
			 
			 if(flag) //종료조건
				 break;
			 
			 //왼쪽, 오른쪽 선택하기
			 int moveLeft = 0, moveRight = 0, rightIndex = curIndex, leftIndex = curIndex;
			 while(true) {
				 rightIndex = (rightIndex+1)%nameLen;
				 moveRight++;
				 
				 if(!visited[rightIndex]) // 아직방문하지않은 위치를 찾아이동
					 break;
			 }
			 
			 while(true) {
				 leftIndex = (leftIndex+(nameLen-1))%nameLen;
				 moveLeft++;
				 
				 if(!visited[leftIndex]) // 아직방문하지않은 위치를 찾아이동
					 break;
			 }
			 
			 //해당위치로 이동(더 거리가 짧은쪽으로)
			 if(moveRight>moveLeft) {
				 curIndex = leftIndex;
				 answer+=moveLeft;
			 }else {
				 curIndex = rightIndex;
				 answer+=moveRight;
			 }
			 
			 //조이스틱조작, 방문표시
			 if(name.charAt(curIndex)-'A'<13) {
				 answer+=(name.charAt(curIndex)-'A');
			 }else {
				 answer+=('Z'-name.charAt(curIndex)+1); //뒤에서부터 센다
			 }
			 
			 visited[curIndex] = true;
		 }
		 
		 return answer;
	}
}
