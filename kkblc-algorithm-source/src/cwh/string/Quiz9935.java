package cwh.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/*
 * 링크: https://www.acmicpc.net/problem/9935
 * 제목: 문자열 폭발
 */

public class Quiz9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        char[] result = new char[1000001];

        int index = 0;

        for(int i = 0; i < str.length(); i++) {

            result[index++] = str.charAt(i); // result 에 일단 넣기

            int bombIndex = bomb.length(); // 뒤에서부터
            if(str.charAt(i) == bomb.charAt(--bombIndex)) {
                boolean checkFlag = true;
                int startIndex = index - bomb.length() - 1; // result 에서 bomb 찾을 시작점
                for(int j = index-2; j > startIndex; j--) {
                    if(result[j] != bomb.charAt(--bombIndex)) {
                        checkFlag = false;
                        break;
                    }
                }

                if(checkFlag) index = index - bomb.length();
            }
        }

        if(index == 0) {
            System.out.println("FRULA");
        } else {
            for(int i = 0; i < index; i++) {
                System.out.print(result[i]);
            }
        }
    }

    /*
     * Deque로 하다가 실패...
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Character[] bombArray = new Character[bomb.length()];

        // deque를 왔다갔다...
        List<Deque<Character>> strDequeArray = new ArrayList<>();
        Deque<Character> strDeque1 = new LinkedList<>();
        Deque<Character> strDeque2 = new LinkedList<>();
        strDequeArray.add(strDeque1);
        strDequeArray.add(strDeque2);

        Queue<Character> tmpQueue = new LinkedList<>(); // 폭탄 문자를 발견했을 때 임시로 넣는 큐

        for(int i = 0; i < str.length(); i++) { // 큐에 한글자씩 집어 넣기
            strDequeArray.get(i).offer(str.charAt(i));
        }

        for(int i = 0; i < bomb.length(); i++) {
            bombArray[i] = bomb.charAt(i);
        }

        int i = 0;
        int j = 0;
        int count = 0;
        while(strDeque.size() > i) {
            Character c = strDeque.poll();

            if(c == bombArray[j]) { // 폭탄 문자 발견!
                tmpQueue.offer(c);
                j++;

                if(j == bombArray.length) { // 폭탄 문자 전체 발견
                    tmpQueue.clear();
                    j = 0;
                    i = 0; // 폭탄 문자 전체 발견했으면 처음부터 다시 시작
                }
            } else {
                if(tmpQueue.size() > 0) { // 이전에 폭탄 문자 발견했을 경우
                    strDeque.addAll(tmpQueue);
                    strDeque.offerFirst(c);
                    j = 0;
                } else {
                    strDeque.offer(c);
                }
            }
            System.out.println(strDeque.toString());
            i++;
        }

        if(strDeque.size() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(strDeque.toString());
        }
    }
     */


    /*
     * 메모리 초과... 속도도 엄청 느림

    private static boolean answerFlag = true;
    private static char[] bombArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        bombArray = new char[bomb.length()];

        for(int i = 0; i < bombArray.length; i++) { // 폭탄을 배열로
            bombArray[i] = bomb.charAt(i);
        }

        while(answerFlag) {
            str = solution(str);

            if(str.length() == 0) {
                System.out.println("FRULA");
                break;
            }
        }

        if(str.length() != 0) {
            System.out.println(str);
        }
    }

    private static String solution(String str) {
        int i = 0;
        int j = 0;
        boolean doneFlag = true;
        boolean findFlag = false;

        while(str.length() > i) {
            if(str.charAt(i) == bombArray[j]) {
                j++;
                findFlag = true;

                if(j == bombArray.length) { // 폭탄 문자열 찾았을 경우
                    str = str.substring(0, i-j+1) + str.substring(i+1);
                    i = i-1; // 원래는 그냥 i 인데 밑에서 ++ 해줘서 -1 해줌
                    j = 0;

                    doneFlag = false;
                    findFlag = false;
                }
            } else {
                if(findFlag) {
                    i = i-1;
                    j = 0;
                    findFlag = false;
                }
            }
            i++;
        }

        if(doneFlag) {
            answerFlag = false;
        }

        return str;
    }
     */
}
