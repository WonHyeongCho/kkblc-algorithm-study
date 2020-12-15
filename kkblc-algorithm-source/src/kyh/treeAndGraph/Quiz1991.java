package com.company.baek.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*4주차*/

/*
 * 링크: https://www.acmicpc.net/problem/1991
 * 제목: 트리 순회
 */

/* 풀이
 *  모든 노드에 대해 .이 아닌 경우 노드 클래스를 만듬.
 *  해당 노드를 map에 담음
 *  순회를 할때 map을 순회함.
 * */

/* 총평
 *
 * */


public class Quiz1991 {

    static HashMap<String, Node> hMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //알파벳 또는 . 을 담을 String 배열
        String []strArr = new String[3];

        String data = "";
        String leftStr = "";
        String rightStr = "";

        Tree t = new Tree();

        for(int i=0;i<N;i++){
            Node parentNode = new Node();
            Node leftNode = new Node();
            Node rightNode = new Node();
            strArr = br.readLine().split(" ");
            data = strArr[0];
            leftStr = strArr[1];
            rightStr = strArr[2];

            //문자 3개에 대하여 3개 전부 노드를 만든다.
            parentNode = t.createNode(data);
            leftNode = t.createNode(leftStr);
            rightNode =	t.createNode(rightStr);

            //위에서 만든 노드를 가져와서 parentNode에 자식으로 넣는다.
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            hMap.put(data, parentNode);
        }

        t.preOrder("A");
        System.out.println();
        t.inOrder("A");
        System.out.println();
        t.postOrder("A");

    }

    //Node class
    public static class Node {
        String data;
        Node left;
        Node right;

    }

    //Tree class
    public static class Tree{
        public Node createNode(String data){
            Node node = new Node();

            //Map에 없으면 Node를 만든다.
            //Map의  value에 Node를 넣는다.
//			if(!hMap.containsKey(data)){

            //입력받은 String이 . 일 경우 null을 리턴한다.
            if(data.equals(".")){
                return null;

            }else{ // . 이 아닐 경우 Node를 만들어 리턴한다.
                node.data = data;
                node.left = null;
                node.right = null;
                hMap.put(data, node);
            }

//			}else{//Map에 있으면 Map의 value를 가져온다.
//				node = hMap.get(data);
//			}
            return node;
        }

        //전위순회
        public static void preOrder(String data){
            System.out.print(data);
            if(hMap.get(data).left != null) preOrder(hMap.get(data).left.data);
            if(hMap.get(data).right != null) preOrder(hMap.get(data).right.data);
        }

        //중위순회
        public static void inOrder(String data){
            if(hMap.get(data).left != null)	inOrder(hMap.get(data).left.data);
            System.out.print(data);
            if(hMap.get(data).right != null) inOrder(hMap.get(data).right.data);
        }
        //후위순회
        public static void postOrder(String data){
            if(hMap.get(data).left != null) postOrder(hMap.get(data).left.data);
            if(hMap.get(data).right != null) postOrder(hMap.get(data).right.data);
            System.out.print(data);
        }

    }

}
