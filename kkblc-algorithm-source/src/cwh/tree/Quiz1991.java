package cwh.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 링크: https://www.acmicpc.net/problem/1991
 * 제목: 트리 순회
 * 비고: 객체를 사용하지 않고 2차원 배열로 해결할 수 있음
 */


public class Quiz1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            tree.insertNode(new Node(line.split(" ")[1]), line.split(" ")[0], new Node(line.split(" ")[2]));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }

    static class Tree {
        Node root;

        void insertNode(Node left, String data, Node right) {
            if(root == null) {
                root = new Node();
                root.data = data;
                root.left = left;
                root.right = right;
            }
            else {
                Node searchNode = search(this.root, data);
                searchNode.left = left;
                searchNode.right = right;
            }
        }

        // 노드 검색, 항상 루트부터 검색
        Node search(Node node, String data) { // 비교할 노드, 비교할 데이터
            Node searchNode = null;
            if(node == null) return null; // 루트가 비어있는 경우

            if(node.data.equals(data)) {
                return node;
            }
            else { // 중위 순회
                searchNode = search(node.left, data);
                if(searchNode != null) return searchNode;
                searchNode = search(node.right, data);
            }

            return searchNode;
        }

        // 중위순회
        void inOrder(Node node) {
            if(node.data.equals(".")) return;
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        // 전위순회
        void preOrder(Node node) {
            if(node.data.equals(".")) return;
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        // 후위순회
        void postOrder(Node node) {
            if(node.data.equals(".")) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);

        }
    }

    static class Node {
        String data;
        Node left;
        Node right;

        Node(){};

        Node(String data) {
            this.data = data;
        }
    }
}
