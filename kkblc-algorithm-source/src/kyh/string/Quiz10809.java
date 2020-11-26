package com.company.baek.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Quiz10809 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        //HashMap을 쓰면 순서 보장이 안된다.
        //따라서 LinkedHashMap을 사용하여 a~z순서를 보장한다.
        Map<Character, Integer> map = new LinkedHashMap<>();
        String abc= "abcdefghijklmnopqrstuvwxyz";
        //a~z까지 String을 map에 넣기.
        for(int i =0; i<abc.length(); i ++){
            map.put(abc.charAt(i),-1);
        }

        solution(str, (HashMap) map);

        //hashmap이므로 iterater를 사용하여 순회한다.
        Iterator<Character> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            char key = keys.next();
            System.out.print( String.format("%s ", map.get(key)) );
        }
    }

    static Map<Character, Integer>  solution(String inputStr, HashMap map) {
        char ch;

        //입력받은 스트링 길이만큼 순회
        for(int i =0; i<inputStr.length(); i ++){
            ch = inputStr.charAt(i);
            //i번째 문자열이 -1인이 아닌지 확인 후 
            //-1이라면 i를 삽입
            if(map.get(ch).equals(-1)){
                map.put(ch,i);
            }
        }
        return map;
    }
}
