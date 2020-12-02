package kyh.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Quiz1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        String result = "I'm Sorry Hansoo";
        System.out.println(result.substring(0,1));

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<name.length() ;i++){
            map.put(name.charAt(i),  map.getOrDefault(name.charAt(i),0)+1);

            System.out.println(name.charAt(i)+" / "+map.get(name.charAt(i)));
        }




        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);

        StringBuilder sb = new StringBuilder();

        // 결과 출력
        for (Character nKey : map.keySet())
        {

            System.out.println(nKey+"/"+map.get(nKey));
        }

    }


}
