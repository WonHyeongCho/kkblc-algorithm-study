package lsy.dp;
//https://www.acmicpc.net/problem/9251
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizLCS {
	public static void main(String[] args) {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      try {
	         String firstLine = br.readLine();
	         String secondLine = br.readLine();
	         int[][] lcs = new int[firstLine.length()+1][secondLine.length()+1];
	         for(int i=1; i<firstLine.length()+1; i++) {
	            char first = firstLine.charAt(i-1);
	            for(int j=1; j<secondLine.length()+1; j++) {
	               char second = secondLine.charAt(j-1);
	               if(first == second) {
	                  lcs[i][j] = lcs[i-1][j-1]+1;
	               }else {
	                  lcs[i][j] = Integer.max(lcs[i-1][j], lcs[i][j-1]);
	               }
	            }
	         }
	         
	         int answer = lcs[firstLine.length()][secondLine.length()];
	         
	         System.out.println(answer);
	      }catch(IOException e) {
	         
	      }
	   }

}
