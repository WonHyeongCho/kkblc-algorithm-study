import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Quiz2493 {


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        try {
            //숫자를 몇개 만들것이냐
            int count = Integer.parseInt(bufferedReader.readLine());
            List<Integer> list = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine()," ");

            while (st.hasMoreTokens()){
                //StringTokenizer로 만든 값이 있는 것 만큼 list에 집어 넣음
                list.add(Integer.parseInt(st.nextToken()));
            }

            int arr[] = new int[count];
            for(int i=count-1;i>=0;i--){
                //이중 포문
                for(int k=i-1;k>=0;k--) {
                    if (list.get(k) > list.get(i)) {
                        arr[i] = k+1;
                        break;
                    }
                }
            }
            for(int k=0;k<count;k++){
                System.out.print(arr[k]);
                if(k!=count-1)
                System.out.print(' ');
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        */

        try{
            int count = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine()," ");
            Stack<Integer> stack = new Stack<>();
            while(st.hasMoreTokens()){

//                if(st.nextToken() < stack.peek()){
//
//                }
//                stack.pop(st.nextToken());



            }

//            Stack<Integer> stack = new Stack<>();

        }catch (Exception e){

        }
    }
}
