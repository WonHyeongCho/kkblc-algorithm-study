import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Quiz1197_Kruskal {
	public static int[] root;
	public static ArrayList<NodeInfo> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();		
		root = new int[node + 1];
		
		//root를 나타내는 배열(노드가 연결될때마다 루트를 정해준다)
		for (int i = 1; i <= node; i++) {
			root[i] = i;
		}
		
		//간선 정보를 list에 담는다
		for(int j=0;j<edge;j++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long value = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(start,end,value));
		}
		
		//value값이 작은순서부터 sorting
		Collections.sort(list, new Comparator<NodeInfo>() {
			@Override
			public int compare(NodeInfo a1, NodeInfo a2) {
				if(a1.getValue()-a2.getValue()>=0) {
					return 1;
				}else{
					return -1;
				}
			}
		});
		
		int cnt = 0;
		long result = 0;
		while (cnt < list.size()) {
			int start = list.get(cnt).start;
			int end = list.get(cnt).end;
			int res = find(start,end);
			//root가 같을경우(같은그룹일경우) cnt+
			if (res==1) { 
				cnt++;
				continue;
			}
			//같은 그룹이 아닐경우 노드를 서로연결해주면서 value++, cnt++
			union(start,end);
			result += list.get(cnt).value;
			cnt++;
		}
		System.out.println(result);
	}
	
	//parent가 같은지 보고 합치는 작엄
	public static int parent(int idx) {
		if (root[idx] == idx)
			return idx;
		return root[idx] = parent(root[idx]);
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
class NodeInfo{
	int start;
	int end;
	long value;
	
	public NodeInfo() {
		super();
	}
	public NodeInfo(int start, int end, long value) {
		super();
		this.start = start;
		this.end = end;
		this.value = value;
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
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
}