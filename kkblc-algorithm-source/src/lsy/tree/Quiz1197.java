package lsy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Quiz1197 {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int node1, node2, edge;
		PriorityQueue<A> pq = new PriorityQueue<A>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			A a = new A(node1, node2, edge);
			pq.add(a);
		}
		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		int answer=0;
		while(!pq.isEmpty()) {
			A now = pq.poll();
			node1 = now.node1;
			node2 = now.node2;
			edge = now.edge;
			
			int parent1 = find(node1);
			int parent2 = find(node2);
			if(parent1 != parent2) {
				union(node1, node2);
				answer += edge;
			}
		}
		System.out.println(answer);
		
	}
	
	public static void union(int node1, int node2) {
		int parent1 = parent[node1];
		int parent2 = parent[node2];
		parent[parent1] = parent2;
 	}
	
	public static int find(int node1) {
		if(node1 == parent[node1]) return node1;
		parent[node1] = find(parent[node1]);
		return parent[node1];
	}
}

class A implements Comparable<A>{
	int node1;
	int node2;
	int edge;
	
	public A(int node1, int node2, int edge){
		this.node1 = node1;
		this.node2= node2;
		this.edge = edge;
	}
	
	public int compareTo(A other) {
		return this.edge - other.edge;
	}
	
}	