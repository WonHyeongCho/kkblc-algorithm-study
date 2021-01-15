package lsy.dividAndConquer;
//https://programmers.co.kr/learn/courses/30/lessons/12980
public class QuizJumpAndTeleport {
	
	public int solution(int n) {
        int ans = 0;
        while(n!=1) {
        	if(n%2==0) {
        		n=n/2;
        	}else {
        		n--;
        		ans++;
        	}
        }
        //System.out.println("??"+n+"me, " +mem[n]);
        ans += 1;
        
        return ans;
    }

	/*
	 * public int dp(int findNum) { if(mem[findNum]!=0 || findNum ==0) { return
	 * mem[findNum]; } System.out.println(findNum); int ans=0; if(findNum%2 !=0) {
	 * ans = dp(findNum-1)+1; }else { ans = Math.min(dp(findNum-1)+1,
	 * dp(findNum/2)); } mem[findNum] = ans;
	 * 
	 * return ans; }
	 */
	public static void main(String[] args) {
		QuizJumpAndTeleport q = new QuizJumpAndTeleport();
		int ans = q.solution(6);
		System.out.println(ans);
	}

}
