package kyh.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 링크: https://www.acmicpc.net/problem/2493
 * 제목: 탑
 */

/* 풀이
 *  기본적으로 탑은 stack에 쌓는다.
 *  N번째 탑이 N+1번째 탑보다 길이가 낮으면
 *  N번째 이하탑들은 전부 제거. N+1탑만 stack에 넣어둔다
 *  N번째 탑이 N+1번째 탑보다 길이가 높으면
 *  N번째 탑과 N+1번째 탑 모두 stack에 쌓는다.
 * */

/* 총평
 * 처음에는 왜 stack을 써야하는지 몰랐다.
 * 배열로 for loop 2번돌리면 시간초과난다.
 * */


public class Quiz2493 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //탑의 갯수 N
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        //int 배열을 넣는 stack
        Stack<int[]> stack = new Stack<>();

        //탑의 높이를 가져오는 String 변수
        String strArr[] = new String[N];
        strArr = br.readLine().split(" ");
        //다음 top의 높이
        int tmpN = 0;
        //0번째에는 index 저장, 1번째에는 탑의 높이를 저장.
        int topArr[] = new int[2];
        //첫번째는 무조건 0
        sb.append("0 ");
        //topArr에 0번째 push
        topArr[0] = 0;
        topArr[1] = Integer.parseInt(strArr[0]);
        stack.push(topArr);

        //stack pop의 탑의 높이
        int tmpPop = 0;

        //기본적으로 pop의 높이와 다음 탑의 높이를 비교
        //pop이 높으면 pop, 다음 탑 둘다 push
        //다음 탑이 높으면, 다음 탑만 push
        for(int i = 1 ; i<N ; i++){
            tmpN= Integer.parseInt( strArr[i]);

            while(!stack.empty()){
                topArr = stack.pop();
                tmpPop = topArr[1];

                if(tmpPop < tmpN){
                    //stack이 비었으면 i번째 탑의 answer는 0
                    if(stack.empty()) {
                        topArr[1] = tmpN;
                        topArr[0] = i;
                        stack.push(topArr);

                        sb.append("0 ");

                        break;
                    }
                    //안비었으면 다음 pop과 tmpN을 다시 비교
                }
                else{
                    sb.append(topArr[0]+1);
                    sb.append(" ");

                    stack.push(topArr);
                    //메모리 새로 할당해야함.
                    topArr= new int[2];

                    topArr[0] = i;
                    topArr[1] = tmpN;

                    stack.push(topArr);
                    break;
                }
            }

        }
        System.out.println(sb);
    }
}
