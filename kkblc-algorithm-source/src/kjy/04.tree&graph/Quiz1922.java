import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Quiz1922 {
	public static int[] root;
	public static ArrayList<NetworkInfo> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = "";
		
		int pcCnt = Integer.parseInt(br.readLine());  //pc의 갯수
		int netCnt = Integer.parseInt(br.readLine()); //네트워크 갯수
		list = new ArrayList<>();		
		root = new int[pcCnt + 1];
		
		//root를 나타내는 배열(네트워크가 연결될때마다 루트를 정해준다)
		for (int i = 1; i <= pcCnt; i++) {
			root[i] = i;
		}
		
		//네트워크 정보 list에 담는다(나중에 연결비용으로 sorting하기위함)
		for(int j=0;j<netCnt;j++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(start!=end)
				list.add(new NetworkInfo(start,end,cost));
		}
		
		//연결 비용이 작은순서부터 sorting
		Collections.sort(list, new Comparator<NetworkInfo>() {
			@Override
			public int compare(NetworkInfo a1, NetworkInfo a2) {
				if(a1.getCost()-a2.getCost()>=0) {
					return 1;
				}else{
					return -1;
				}
			}
		});
				
		int cnt = 0;
		long result = 0;
		while (cnt < list.size()) {
			int curStart = list.get(cnt).getStart();
			int curEnd = list.get(cnt).getEnd();
			int res = find(curStart,curEnd);
			
			//root가 같을경우(같은그룹일경우) cnt++
			if (res==1) { 
				cnt++;
				continue;
			}
			
			//같은 그룹이 아닐경우 서로 네트워크연결해주면서 비용++, cnt++
			union(curStart,curEnd);
			result += list.get(cnt).cost;
			cnt++;
		}
		
		System.out.println(result);
		
	}
	
	public static int parent(int idx) { 
		if (root[idx] == idx) 
			return idx;
		return root[idx] = parent(root[idx]); //재귀로 parent를 찾아가서 root값을 셋팅
	}

	public static void union(int a, int b) { //parent가 같은지 보고 합치는 작엄
		a = parent(a);
		b = parent(b);
		if(a<b) root[b]=a; //더 작은수가 루드가 된다.
		else root[a]=b;
	}

	public static int find(int a, int b) { //parent가 같은지 찾는 함수
		a = parent(a);
		b = parent(b);
		if(a==b) return 1;
		else return 0;
	}

}
class NetworkInfo{
	int start;
	int end;
	int cost;
	
	public NetworkInfo() {
		super();
	}
	public NetworkInfo(int start, int end, int cost) {
		this.start 	= start;
		this.end 	= end;
		this.cost 	= cost;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}