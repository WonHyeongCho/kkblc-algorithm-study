public class targetNumber {


    public int solution(int[] numbers, int target){
        int answer = 0;
        int sums =numbers[0];
        //어떻게 짤까 n일때 전체 가  + - 를 해야한다. 2^n승번의 곱이 있어야한다.
        //재귀를 사용해야한다 하나는 더하는 것 하나는 - 인것
        answer += dfs(sums,1,numbers,target); //하나는 +인 상태의 것으로 시작한다.
        answer += dfs(-sums,1,numbers,target);//하나는 -인 상태의 것으로 시작한다.

        return answer;
    }

    public int dfs(int sum,int index,int [] numbers,int target){

        if(index>=numbers.length){ //마지막까지 진행했을 때
            if(target==sum){  //목표한 숫자와 sum한 값이 같으면
                return 1;
            }
            return 0;
        }

        int plus = sum + numbers[index];
        int minus = sum - numbers[index];

        int answer=0;
        //계속 재귀를 하게 된다. 끝까
        answer +=dfs(plus,index+1,numbers,target);
        answer +=dfs(minus,index+1,numbers,target);
        return answer;

    }

    public static void main(String[] args) {

        targetNumber bts = new targetNumber();
        int [] numbers ={1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(bts.solution(numbers,target));
    }

}
