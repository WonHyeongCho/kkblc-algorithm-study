package lsy.dividAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/67257

public class QuizNumeric {
	public long solution(String expression) {
        long answer = 0;
        LinkedList<Long> list = new LinkedList<Long>();
        LinkedList<Character> operators = new LinkedList<Character>();
        ArrayList<Character> realOp = new ArrayList<Character>();
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<expression.length();i++) {
           char c= expression.charAt(i);
           //숫자인지 확인
           if(c >=48 && c <=57) {
              sb.append(c);
           }else {
              operators.add(c);
              if(!realOp.contains(c)) realOp.add(c);
              list.add(Long.parseLong(sb.toString()));
              sb.delete(0, sb.length());
           }
          if(i==expression.length()-1) list.add(Long.parseLong(sb.toString()));
        }
        long[] arr = list.stream().mapToLong(x->x.longValue()).toArray();
        Character[] cloneOp = operators.toArray(new Character[operators.size()]);
       
        for(int i=0; i <realOp.size();i++) {
           calculate(list, operators, realOp.get(i));
           for(int j=0;j<realOp.size()-1;j++) {
              LinkedList<Long> cloneTemp= (LinkedList<Long>)list.clone();
        	  LinkedList<Character> cloneTempOp = (LinkedList<Character>)operators.clone();
              int nextIdx = (i+j+1)%realOp.size();
             // System.out.println(realOp.get(nextIdx));
              calculate(list,operators,realOp.get(nextIdx));
              if(realOp.size()==3) {
            	  nextIdx = 3-nextIdx-i;
                  //System.out.println(realOp.get(nextIdx));
            	  calculate(list, operators, realOp.get(nextIdx));
              }
              if(Math.abs(list.peek())>answer) answer = Math.abs(list.peek());
             // System.out.println(list.peek());
              list = cloneTemp;
              operators= cloneTempOp;
           }
           
           if(Math.abs(list.peek())>answer) answer = Math.abs(list.peek());
           list = (LinkedList<Long>)Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
           operators = (LinkedList<Character>)Arrays.stream(cloneOp).collect(Collectors.toCollection(LinkedList::new));
        }
        return answer;
    }
   
   public void calculate(LinkedList<Long> list, LinkedList<Character> operators, Character op) {
      Iterator<Character> itr= operators.iterator();
      int idx = 0;
      while(itr.hasNext()) {
         char next= itr.next();
         if(next == op) {
            
            long number = 0;
            if(op==43) {
               number = list.get(idx)+ list.get(idx+1);
            }else if(op==45) {
               number = list.get(idx)- list.get(idx+1);
            }else {
               number = list.get(idx)* list.get(idx+1);
            }
            list.remove(idx);
            list.remove(idx);
            list.add(idx, number);
            itr.remove();
            //System.out.println(operators.size());
         }else {
            idx++;
         }
      }
   }
   
   public static void main(String[] args) {
      QuizNumeric q = new QuizNumeric();
      long a = q.solution("50*2");
      System.out.println(a);
   }

}
