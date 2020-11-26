package cwh.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 링크: https://www.acmicpc.net/problem/5052
 * 제목: 전화번호 목록
 */

public class Quiz5052 {

    private static final int NUMBERCOUNT = 10;
    private static TrieNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for(int i = 0; i < t; i++) {
            root = new TrieNode();

            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            boolean result = false;

            for(int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
                insert(phoneNumbers[j]);
            }

            for(int j = 0; j < n; j++) {
                if(!solution(phoneNumbers[j])) {
                    result = false;
                    break;
                } else{
                    result = true;
                }
            }

            if(result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUMBERCOUNT];

        boolean isEndOfWord; // 단어의 끝 표시

        TrieNode() {
            isEndOfWord = false;
            for(int i = 0; i < NUMBERCOUNT; i++) {
                children[i] = null;
            }
        }
    }

    private static void insert(String number) {
        TrieNode currentTrie = root;
        int index;

        for(int i = 0; i < number.length(); i++) {
            index = number.charAt(i)-'0'; // char 문자열을 숫자로 변경

            if(currentTrie.children[index] == null) {
                currentTrie.children[index] = new TrieNode();
            }
            currentTrie = currentTrie.children[index]; // 자식 노드로 변경
        }

        currentTrie.isEndOfWord = true;
    }

    private static boolean solution(String number) {
        TrieNode currentTrie = root;
        int index;

        for(int i = 0; i < number.length(); i++) {
            index = number.charAt(i)-'0';

            if(currentTrie.isEndOfWord){
                return false;
            }
            currentTrie = currentTrie.children[index];
        }
        return true;
    }

    /*
     * 일반적으로 2중반복문 돌리면 시간 초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];

            for(int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }

            Arrays.sort(phoneNumbers);

            System.out.println(solution(phoneNumbers));
        }
    }

    private static String solution(String[] phoneNumbers) {
        for(int j = 0; j < phoneNumbers.length; j++) {
            String phoneNumber = phoneNumbers[j];
            for(int k = j+1; k < phoneNumbers.length; k++) {
                if(phoneNumber.substring(0, 1).equals(phoneNumbers[k].substring(0, 1))) { // 첫재짜리만 비교 첫째가 넘어가면 break
                    if(phoneNumber.length() <= phoneNumbers[k].length()) { // 길이 비교
                        String splitPhoneNumber = phoneNumbers[k].substring(0, phoneNumber.length());

                        if(phoneNumber.equals(splitPhoneNumber)) {
                            return "NO";
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return "Yes";
    }
     */
}
