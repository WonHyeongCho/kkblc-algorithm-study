package bsw.string;

/*
 * 링크: https://www.acmicpc.net/problem/8595
 * 제목: 히든 넘버
 * Write 백상
 */

import java.util.Arrays;
import java.util.Scanner;

public class Quiz8595 {

    public static long solution(int n,String line){
        long hiddenNumber=0;
        int hiddenNumberLenght=0;
        long [] numberBox = new long[6];
        for(int i=0;i<n;i++){
            if(line.charAt(i)>='0' && line.charAt(i)<='9'){
                numberBox[hiddenNumberLenght]=line.charAt(i)-48;
                hiddenNumberLenght++;
            }
            else{ //문자일 때
                if(hiddenNumberLenght>0){
                    int calulateHiddenNumberLenght= hiddenNumberLenght;
                    for(int j=0;j<hiddenNumberLenght;j++){
                        hiddenNumber += numberBox[j]*Math.pow(10,calulateHiddenNumberLenght-1);
                        calulateHiddenNumberLenght-=1;
                    }
                    hiddenNumberLenght=0;
                }

            }

            if(i+1==n){ //마지막 입력일때
                if(hiddenNumberLenght>0){
                    int calulateHiddenNumberLenght= hiddenNumberLenght;
                    for(int j=0;j<hiddenNumberLenght;j++){
                        hiddenNumber += numberBox[j]*Math.pow(10,calulateHiddenNumberLenght-1);
                        calulateHiddenNumberLenght-=1;
                    }
                    hiddenNumberLenght=0;
                }
            }
        }
        return hiddenNumber;
    }


    public static void main(String[] args)  {
        int wordLength;
        String word;
        Scanner scan = new Scanner(System.in);
        // 숫자
        wordLength = Integer.parseInt(scan.nextLine());
        // 문자
        word = scan.nextLine();
        System.out.println(solution(wordLength,word));

    }
   //처음 푼 것
}

//두번째로 푼 것
/*
* public class Main {
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{

        int wordLength;
        String word;
        long answer;
        Scanner scan = new Scanner(System.in);
        wordLength = Integer.parseInt(scan.nextLine());
        word = scan.nextLine();

        long hiddenNumber=0;
        String temp="";
        for(int i=0;i<wordLength;i++){
            if(word.charAt(i)>='0' && word.charAt(i)<='9'){
                temp+=word.charAt(i);
            }
            else{
                if(temp.length() > 0){
                    hiddenNumber+=Long.parseLong(temp);
                    temp="";
                }

            }
        }
        if(temp.length() > 0){
                    hiddenNumber+=Long.parseLong(temp);
                    temp="";
         }

        bw.write(String.valueOf(hiddenNumber));
         bw.flush();
    }
}
* */