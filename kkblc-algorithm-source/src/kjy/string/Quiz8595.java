package kjy.string;

/*
 * 링크: https://www.acmicpc.net/problem/8595
 * 제목: 히든 넘버
 */

public class Quiz8595 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		String str = sc.next();
		long totalSum = 0;
		long curSum = 0;
		char curChar;
		
		/*
		 String에 0번째부터 cnt-1번째 index까지 하나씩 점검한다.
		 이때 가져온 문자(num)가 숫자라면, 다음문자가 숫자인지 본다.
		 (i==cnt-1이라면 num==숫자더라도 sum에 더해주고 나와야함)
		 
		 if(num==숫자){
		 	curSum = curSum*10+num;
		 }else{
		 	Sum += curSum;
		 }
		 */
		for(int i=0; i<cnt ; i++) {
			curChar = str.charAt(i);
			
			if(curChar>='0'&&curChar<='9') {
				curSum = curSum*10 + Long.parseLong(curChar+"");
				if(i==cnt-1) {
					totalSum += curSum;
				}
			}else {
				if(curSum>0) {
					totalSum += curSum;
					curSum = 0;
				}
			}
		}
		
		System.out.println(totalSum);
    }
}
