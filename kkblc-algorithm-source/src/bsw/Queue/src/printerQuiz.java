import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 프린터 퀴즈
* https://programmers.co.kr/learn/courses/30/lessons/42587
* */
public class printerQuiz {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        if(priorities.length == 1){
            return  1;
        }

        //숫자의 값을 받는다. a b c d e 위치값
        Queue<pairing> print = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            print.add(new pairing(priorities[i],i));
        }


        while(!print.isEmpty()){
            pairing pr =  print.poll();
            for(pairing item : print){
                if(pr.value < item.value){
                    print.add(pr);
                    pr = null;
                    break;
                }
            }
           if(pr != null){
               if(pr.index == location){
                   answer++;
                   return answer;
               }else{
                   answer++;
               }
           }
        }

        return answer;
    }

    class pairing{
        int value, index;
        public pairing(int value,int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        printerQuiz bts = new printerQuiz();
        int [] priorities ={1, 1, 9, 1, 1, 1};
        int  location = 0;

        int [] priorities2 ={2, 1, 3, 2};
        int  location2 = 2;

        bts.solution(priorities,location);
        bts.solution(priorities2,location2);
    }
}
