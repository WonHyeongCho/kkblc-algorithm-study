import java.util.Arrays;

public class network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        //n은 몇개인줄 안다 for문 돌기
        //dfs에서 boolean으로 된 array에 담아서 해당 array를 방문 미방문으로 분류한다.
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){ //n번 반복한다. n행이
            if(!visited[i]){
                answer+=dfs(i,computers,visited);
            }
        }
        return answer;
    }
    public int dfs(int i,int [][]computers, boolean [] visited){

        if(visited[i]){ // 방문을 하였다면 0으로 되돌아온다.
            return 0; // 방문을 했다
        }
        visited[i] = true; //방문을 한것이다.
        for (int j=0;j<computers[i].length;j++){
            if(computers[i][j]==1){ //다른 행에서 자신에게 작대기를 그은게 있으면 찾아서 방문을 한것으로 만든다.
                dfs(j,computers,visited); //해당 것은 자신에게
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {
                {1, 1, 0}, //0번재 것은 자기 자신에게 1 1번에 1 2번에 0
                {1, 1, 0}, //1번째 것은 0번째에게 1 자기도 1 2번은 0
                {0, 0, 1}
        };
        network bts = new network();

        System.out.println(bts.solution(n,computers));

    }

}