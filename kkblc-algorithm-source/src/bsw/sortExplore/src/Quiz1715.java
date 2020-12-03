/*
* URL - https://www.acmicpc.net/problem/1715
* 알고리즘 sort
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Quiz1715 {

    static long solution(int arrlength, List<Integer> arr){
        long answer=0;
        int length = arrlength;
        Collections.sort(arr);
        //순차적으로 더하는 것이 작다!!
        if(length == 1){
            answer = 0;
        }else if(length == 0){
            answer =0;
        }
        else{
            for(int i=0;i<length-1;i++){
                if(i == 0 && length != 1){
                    answer = arr.get(0)+arr.get(1);
                }else{
                    answer += answer +arr.get(i+1);
                }
            }
        }
        return answer;
    }

//    public static void main(String[] args) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        try{
//            int lenght = Integer.parseInt(bufferedReader.readLine());
//            List <Integer> array = new ArrayList<>();
//            for(int i=0;i<lenght;i++){
//                int d = Integer.parseInt(bufferedReader.readLine());
//                array.add(d);
//            }
//            bufferedReader.close();
//
//            System.out.println(solution(lenght,array));
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//    }
//  List 로 놓고 풀었을때는 답이 안된다. 우선 순위 큐를 꼭 사용을 해야한다.

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int length = Integer.parseInt(bufferedReader.readLine());
            long answer = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();
            for(int i=0;i<length;i++)
                priorityQueue.offer(Integer.parseInt(bufferedReader.readLine()));

            while (priorityQueue.size() != 1) {
                int p = priorityQueue.poll(), q = priorityQueue.poll();
                answer += p + q;
                priorityQueue.offer(p + q);
            }

            bufferedWriter.write(answer+"\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
