import java.util.Scanner;

public class Quiz10830 {
	/*
	 * 출처: https://www.acmicpc.net/problem/10830
	 * 풀이: 행렬의 크기 N과 B가 주어지는데, 이 B를 이용해야한다.
	 *      Res = A ^(B)
	 *      B를 빠르게 줄여주는게 핵심 
	 *          
	 *          IF(B가 짝수){
	 *          	(A^2)^(B/2)
	 *          }ELSE{
	 *				A*A^(B-1)     //짝수로 만들기 위함이다.    
	 *          }
	 */
	static int N;
	static long B;
	static long[][] A;
	//static long[][] res; //B가 홀수일 경우에 초기값을 나중에 곱해주기위해 기억하는 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextLong();
		
		A = new long[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		/*
		 * 이렇게 풀면될것같았는데 망했죠..
		 * 검색찬스 사용
		 * 
		while(B>0) {  //1제곱이 될때까지
			if(B%2==1) { //홀수제곱이라면
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						int temp = 0;
						for(int k = 0; k < N; k++ ) {
							temp += (res[i][k] * map[k][j]);
						}
						res[i][j] = temp % 1000;
					}
				}
				B-=1;
			}
			
			B/=2;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int temp = 0;
					for(int k = 0; k < N; k++ ) {
						temp += (map[i][k] *= map[k][j]);
					}
					map[i][j] = temp % 1000;
				}
			}
		}
		*/
		
		long[][] res = mul(B);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static long[][] mul(long b) {
	    long[][] result = new long[N][N];
	    long[][] temp = new long[N][N];

	    if(b == 1) {
	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          result[i][j] = A[i][j] % 1000;
	        }
	      }
	    }else if(b % 2 == 0) {
	      
	      temp = mul(b/2);

	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          int el = 0;
	          for (int k = 0; k < N; k++) {
	            el += temp[i][k] * temp[k][j];
	          }
	          result[i][j] = el % 1000;
	        }
	      }
	    }else {
	      temp = mul(b-1);

	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          int el = 0;
	          for (int k = 0; k < N; k++) {
	            el += temp[i][k] * A[k][j];
	          }
	          result[i][j] = el % 1000;
	        }
	      }
	    }
	    
	    return result;
	    
	  }
}
