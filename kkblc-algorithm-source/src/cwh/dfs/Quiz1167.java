package cwh.dfs;

/*
 * 링크: https://www.acmicpc.net/problem/1167
 * 제목: 트리의 지름
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 실패함....

public class Quiz1167 {
    static int V;
    static boolean[] visited; // 방문 여부
    static List<Node>[] tree = new LinkedList[100001];

    static int maxDistance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        maxDistance = 0;

        for(int i = 0; i < 100001; i++) {
            tree[i] = new LinkedList<>();
        }

        for(int i = 0; i < V; i++) {
            int vertex = scanner.nextInt();

            while(true){
                int a = scanner.nextInt();
                if(a == -1) break; // -1 일때 종료
                int b = scanner.nextInt();
                tree[vertex].add(new Node(a, b));
                tree[a].add(new Node(vertex, b));
            }
        }

        dfs(tree[1].get(0), tree[1].get(0).weight);
    }

    static void dfs(Node node, int weight) {
        visited[node.number] = true;

        for(Node tmp : tree[node.number]) {
            if(!visited[tmp.number]) dfs(tmp, weight+tmp.weight);
        }

        if(maxDistance < weight) maxDistance = weight;
    }
}

class Node {
    int number;
    int weight;

    Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }
}
