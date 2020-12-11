package cwh.tree;

/*
 * 링크: https://www.acmicpc.net/problem/1197
 * 제목: 최소 스패닝 트리
 * 비고: Kruskal, Prim, Union-Find
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Union-Find로 풀이, https://brenden.tistory.com/37
public class Quiz1197 {
    static int[] parent;
    static List<Edge> edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        edges = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(v1, v2, cost));
        }

        // 부모 연결 리스트 초기화
        parent = new int[v+1];
        for(int i = 1; i < v+1; i++) {
            parent[i] = i;
        }

        Collections.sort(edges); // 간선으로 오름차순 정렬

        int sum = 0;
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if(!isSameParent(edge.v1, edge.v2)) { // 부모가 다르면
                sum += edge.cost;
                // union(edge.v1, edge.v2);
                parent[edge.v2] = edge.v1; // union
            }
        }

        System.out.println(sum);
    }

    static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static int findParent(int x) {
        if(parent[x] == x) { // 부모가 자기 자신
            return x;
        }

        return parent[x] = findParent(parent[x]); // 부모 찾아 재귀
    }

    static void union(int x, int y) {
        if(findParent(x) != findParent(y)) { // 부모가 다르면 합친다.
            parent[y] = x;
        }
    }

}

class Edge implements Comparable<Edge> {
    int v1; // 첫 번째 vertex
    int v2; // 두 번째 vertex
    int cost; // 두 vertex 사이의 간선

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost > o.cost)
            return 1;
        else
            return 0;
    }
}