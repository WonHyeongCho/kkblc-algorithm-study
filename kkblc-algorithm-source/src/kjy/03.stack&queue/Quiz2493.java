import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Quiz2493 {
	/*
	 * 백준 2493(탑): https://www.acmicpc.net/problem/2493 
	 오른쪽에서 왼쪽으로 레이져를 쏴서 걸리는곳에서 레이져수신. 계산할때는 왼쪽에서 오른쪽으로 가면서 stack에 타워값을 insert해주는데
	 이때 현재 stack의 top보다 비교하는값이 크다면  pop해준다  그리고 더큰값을 push
	 
	 */
	public static void main(String[] args) {
		Deque<Tower> stack = new ArrayDeque<>();
		long[] inputs;
		long[] answers;
		int cnt=0;
		String str = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			cnt = Integer.parseInt(br.readLine());
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		inputs = new long[cnt+1];
		answers = new long[cnt+1];
		
		//입력
		StringTokenizer st = new StringTokenizer(str);
		int curIdx = 1;
		while(st.hasMoreTokens()) {
			inputs[curIdx] = Long.parseLong(st.nextToken());
			curIdx++;
		}
		
		for(int i=1;i<=cnt;i++) {
			long height = inputs[i];
			
			if(stack.isEmpty()) {
				answers[i] = 0;
			}else {
				while(!stack.isEmpty()) {
					if(stack.peek().getHeight()>=height) {
						answers[i] = stack.peek().getIdx();
						break;
					}
					stack.pop();
				}
				if(stack.isEmpty()) {
					answers[i] = 0;
				}
			}
			stack.push(new Tower(height, i));
		}
		
		//정답 배열
		for(int i=1; i<=cnt; i++) {
			System.out.print(answers[i]+" ");
		}
	}
}

class Tower {
	long height;
	long idx;
	
	public Tower() {
		height = 0;
		idx    = 0;
	}
	public Tower(long height, long idx) {
		super();
		this.height = height;
		this.idx = idx;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	
}