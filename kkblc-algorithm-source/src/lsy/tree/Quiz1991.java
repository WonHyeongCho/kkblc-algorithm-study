package lsy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Quiz1991 {
	public static HashMap<String, Node> nodes;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			nodes = new HashMap<String, Node>();
			
			StringTokenizer st;
			String value, left, right;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				value = st.nextToken();//a
				left = st.nextToken();//b
				right = st.nextToken();
				Node node = nodes.getOrDefault(value, new Node(value));
				if(!left.equals(".")) {
					Node leftNode = nodes.get(left);
					
					if(leftNode==null) {
						leftNode = new Node(left);
						nodes.put(left, leftNode);
					}
					node.setLeft(leftNode);
				}
				if(!right.equals(".")) {
					Node rightNodes = nodes.get(right);
					if(rightNodes==null) {
						rightNodes = new Node(right);
						nodes.put(right, rightNodes);
					}
					node.setRight(rightNodes);
				}
				nodes.put(value, node);
			}
			
			StringBuilder sb= new StringBuilder();
			//전위 순회
			sb.append("A");
			preOrder(nodes.get("A"), sb);
			sb.append("\n");
			
			//중위순회
			inOrder(nodes.get("A"), sb);
			
			//후위순회
			sb.append("\n");
			postOrder(nodes.get("A"), sb);
			System.out.println(sb);
		}catch(IOException e) {
			
		}
		
		
	}
	//preorder
	public static void preOrder(Node now , StringBuilder sb) {
		if(now.getLeft()!=null) {
			sb.append(now.getLeft());
			preOrder(now.getLeft(), sb);
		}
		if(now.getRight() !=null) {
			sb.append(now.getRight());
			preOrder(now.getRight(), sb);
		}
	}
	//inorder
	public static void inOrder(Node now, StringBuilder sb) {
		if(now.getLeft()!=null) {
			inOrder(now.getLeft(),sb);
		}
		sb.append(now.getNum());
		if(now.getRight()!=null) {
			inOrder(now.getRight(), sb);
		}
	}
	//postorder
	public static void postOrder(Node now, StringBuilder sb) {
		if(now.getLeft()!=null) {
			postOrder(now.getLeft(), sb);
		}
		if(now.getRight()!=null) {
			postOrder(now.getRight(),sb);	
		}
		sb.append(now.getNum());
	}
	
	
	private static class Node{
		String num;
		Node left;
		Node right;
		
		public Node(String num) {
			this.num = num;
		}
		
		public String getNum () {
			return this.num;
		}
		public Node getLeft() {
			return this.left;
		}
		public Node getRight() {
			return this.right;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		@Override
		public String toString() {
			return this.num;//+ "/ left: " + left.getNum() + "/ right: " + right.getNum() ; //
		}
		@Override
		public boolean equals(Object obj) {
			Node other = (Node)obj;
			if(other.getNum().equals(num)) {
				return true;
			}else {
				return false;
			}
		}
		
		
	}

}
