import java.util.Scanner;

public class Quiz1780 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1780
	 * 
	 * 풀이: devide&conquer를 사용한다.
	 *      9등분으로 나누는 devide와 
	 *      해당 구간의 값이 모두 같은지 확인하는 isSame함수 필요
	 * 
	 */
	static int[][] map;
	static int[] answer  = new int[3];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		devide(0,0,N);
		
		for(int i=0; i<3; i++)
			System.out.println(answer[i]);
	}
	public static int isSame(int row, int col, int size) {
		int result = map[row][col]; //default 
		
		for(int i=row; i<row+size; i++){
			for(int j=col; j<col+size; j++) {
				if(result!=map[i][j]) {
					result = -1; //-1은 false를 뜻함
					return result;
				}
			}
		}
		
		return result+1; //-1, 0, 1 여기에+1해서 ->  0, 1, 2
	}
	public static void devide(int row, int col, int size) {
		int res = isSame(row,col,size);
		if(res>=0) { //모두 동일할경우
			answer[res]+=1; //count++
		}else {
			int newSize = size/3;
			/*9등분 해준다.
			 * 
			 * 123
			 * 456
			 * 789
			 */
			devide(row, col, newSize);            				//1
	        devide(row, col + newSize, newSize);  				//2
	        devide(row, col + newSize*2, newSize);  			//3
	        devide(row + newSize, col, newSize); 				//4
	        devide(row + newSize, col + newSize, newSize); 		//5
	        devide(row + newSize, col + newSize*2, newSize);	//6
	        devide(row + newSize*2, col, newSize); 				//7
	        devide(row + newSize*2, col + newSize, newSize); 	//8
	        devide(row + newSize*2, col + newSize*2, newSize);	//9
	        
	            
		}
	}

}	
