import java.util.*;

public class FunctionDevelop {

    public int[] solution(int[] progresses, int[] speeds) {

//삽
//        //중복 동일 값이 있을 때 카운트를 하고 싶다.
//        int [] lists = new int[progresses.length];
//        for(int i=0;i<progresses.length;i++){
//
//            for(int j=1;j<100 ;j++){
//                if(progresses[i]+j*speeds[i] >=100)
//                    lists[i] =j;
//                    break;
//            }
//        }
//        Arrays.sort(lists);
//        List<Integer> answerlist = new ArrayList<>();
//        int duplicate =1; //완료되는 시간 순서대로 나열이된다.
//        //여기서 나열된 순서에 맞추어 자르면 된다. 1 1 1 2 2 2 2 3 3 3 3 3
//        int temp=0;
//
//        for(int i=0;i<progresses.length;i++){
//           if(i==0){
//               temp= lists[i];
//           }else{
//               if(temp != lists[i]){
//                   answerlist.add(duplicate);
//                   //1로 초기화 한다.
//                   duplicate =1;
//               }else if(i==progresses.length-1){
//                   answerlist.add(duplicate);
//                   //1로 초기화 한다.
//               }
//               else{
//                   duplicate++;
//               }
//           }
//        }
//        int [] answer = new int[answerlist.size()];
//        for(int i=0;i<answerlist.size();i++){
//            answer[i] = answerlist.get(i);
//        }

        //        //중복 동일 값이 있을 때 카운트를 하고 싶다.
        int [] lists = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){

            for(int j=1;j<100 ;j++){
                if(progresses[i]+j*speeds[i] >=100) {
                    lists[i] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(lists));
        List<Integer> answers = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<lists.length;i++){
            if(queue.isEmpty()){
                queue.add(lists[i]);
            }else{
                if(queue.peek()<lists[i]){
                    answers.add(queue.size());
                    queue.clear();
                    queue.add(lists[i]);
                }else{
                    queue.add(lists[i]);
                }
            }

        }
        if(!queue.isEmpty()){
            answers.add(queue.size());
            for(int k =0;k<queue.size();k++){
                queue.poll(); //전부다 끄내버린다.
            }
        }

        int [] answer = new int[answers.size()];

        for(int i=0;i<answers.size();i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }



    public static void main(String[] args) {
        FunctionDevelop bts = new FunctionDevelop();

        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};

        bts.solution(progresses,speeds);

    }
}
