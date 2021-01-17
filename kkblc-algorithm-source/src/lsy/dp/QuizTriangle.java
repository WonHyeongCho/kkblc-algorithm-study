package lsy.dp;
//https://programmers.co.kr/learn/courses/30/lessons/43105
import java.util.Arrays;

public class QuizTriangle {
	
	public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] mem = new int[height][height];
        mem[0][0] = triangle[0][0];
        
        int[] depth;
        int temp;
        for(int i=0; i<triangle.length-1;i++) {
        	depth = triangle[i];
        	
        	for(int j=0; j<depth.length;j++) {
        		temp = mem[i][j] + triangle[i+1][j];
        		mem[i+1][j] = temp > mem[i+1][j] ? temp: mem[i+1][j];
        		temp = mem[i][j] + triangle[i+1][j+1];
        		mem[i+1][j+1] = temp > mem[i+1][j+1] ? temp: mem[i+1][j+1];
        	}
        }
        
        int[] lastRow = mem[height-1];
        Arrays.sort(lastRow);
        answer = lastRow[lastRow.length-1];
        return answer;
    }
	
	public static void main(String[] args) {
		QuizTriangle q = new QuizTriangle();
		q.solution(new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});

	}

}
