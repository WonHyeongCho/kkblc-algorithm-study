import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz1991 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeNode treeNode = new TreeNode();
		String str ="";
		int cnt = 0;
		try {
			cnt = Integer.parseInt(br.readLine());
			//System.out.println(cnt);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i=0; i<cnt; i++) {	
			try {
				str = br.readLine();
				//System.out.println("str : "+str);
				
				st = new StringTokenizer(str);
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				//System.out.println("s1,s2,s3 : "+s1+", "+s2+", "+s3);
				treeNode.add(s1, s2, s3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//전위순회
		treeNode.preOrder(treeNode.getRoot());
		System.out.println();
		//중위순회
		treeNode.inOrder(treeNode.getRoot());
		System.out.println();
		//후위순회
		treeNode.postOrder(treeNode.getRoot());
	}

}
class Node{ //Node
	String data;
	Node left;
	Node right;
	
	public Node() {
		;
	}
	public Node(String data) {
		this.data=data;
	}
}
class TreeNode{
	Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void add(String data, String leftData, String rightData) {
		if(root==null) {
			if(!".".equals(data))
				root = new Node(data);
			if(!".".equals(leftData))
				root.left = new Node(leftData);
			if(!".".equals(rightData))
				root.right = new Node(rightData);
		}else { //만약 최초 상태가 아니면 -> 어디에 들어가야 하는지 찾는다.
			search(root, data, leftData, rightData);
		}
	}
	
	public void search(Node root, String data, String leftData, String rightData) {
		//재귀를 사용하므로 도착한 노드가 null이면 종료 = 삽입 위치를 찾지 못한 경우
		if(root==null) { 
			return; 
		}else if(root.data.equals(data)){//위치를 찾았으면
	        //'.'이 아닌 경우에 한해서 좌, 우 노드 생성 후 데이터 삽입
			if(!".".equals(leftData)) root.left = new Node(leftData);
			if(!".".equals(rightData)) root.right = new Node(rightData);
		}
		else{
			search(root.left, data, leftData, rightData); //왼쪽 탐색
			search(root.right, data, leftData, rightData);//오른쪽 탐색
		}
	}
	
	// 전위순회: (루트) (왼쪽 자식) (오른쪽 자식)
	public void preOrder(Node curNode) {
		System.out.print(curNode.data);
		if(curNode.left!=null) preOrder(curNode.left);
		if(curNode.right!=null) preOrder(curNode.right);
	}
	
	// 중위순회: (왼쪽 자식) (루트) (오른쪽 자식)
	public void inOrder(Node curNode) {
		if(curNode.left!=null) inOrder(curNode.left);
		System.out.print(curNode.data);
		if(curNode.right!=null) inOrder(curNode.right);
	}
	
	// 후위순회: (왼쪽 자식) (오른쪽 자식) (루트)
	public void postOrder(Node curNode) {
		if(curNode.left!=null)postOrder(curNode.left);
		if(curNode.right!=null) postOrder(curNode.right);
		System.out.print(curNode.data);
	}
}
