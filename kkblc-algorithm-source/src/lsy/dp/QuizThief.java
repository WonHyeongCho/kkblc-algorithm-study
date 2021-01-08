package lsy.dp;
//https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
public class QuizThief {
	public int solution(int[] money) {
      int answer = 0;
      int[] mem = new int[money.length];
      mem[0] = money[0];
      mem[1] = money[0] > money[1] ? money[0]: money[1];
      
      boolean[] isFirstContain = new boolean[money.length];
      isFirstContain[0] = true;
      isFirstContain[1] = money[0] > money[1] ? true: false;
      
      int number;
      for(int i=2; i<money.length;i++) {
           number = mem[i-2] + money[i];
           if(i==money.length-1 &&isFirstContain[i-2]) {
              number = mem[i-2];
           }
           if(number > mem[i-1]) {
              mem[i] = number;
              if(isFirstContain[i-2]) {
                 isFirstContain[i] = true;
              }
           }else {
              mem[i] = mem[i-1];
              if(isFirstContain[i-1]) {
                 isFirstContain[i] = true;
              }
           }
      }
      int comparedValue = mem[money.length-1];
      if(isFirstContain[money.length-3]) {
           mem[0] = 0;
           mem[1] = money[1];
           
           for(int i=2;i<money.length; i++) {
              number = mem[i-2] + money[i];
              mem[i] = number > mem[i-1] ? number: mem[i-1];
           }
      } 
      answer = comparedValue > mem[money.length-1]? comparedValue : mem[money.length-1];
        return answer;
    }
   
   
   public static void main(String[] args) {
      QuizThief q = new QuizThief();
      int result = q.solution(new int[] {100, 90, 5, 0,10,5,100});
      System.out.println(result);
   }

}
