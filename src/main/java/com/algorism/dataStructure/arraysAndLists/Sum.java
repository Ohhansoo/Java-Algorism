package com.algorism.dataStructure.arraysAndLists;

import java.util.Scanner;

public class Sum {
    /**
     * 1번째 줄에 숫자의 개수 N (1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
     */
    public static void sum(int count, String num) {
        int answer = 0;

        String[] numbers = num.split("");

        for (int i = 0; i <= numbers.length - 1; i++) {
            answer += Integer.parseInt(numbers[i]);
        }

        System.out.println(answer);
    }

    public static void sum_answer(int count, String num) {

        //1. N의 범위가 1 ~ 100 까지이므로 값을 int형, long형과 같은 숫자형으로 담을 수 없다.
        //따라서 문자열 형태로 입력값을 받은 후 이를 문자 배열로 변환하고, 순서대로 숫자형으로 바꿔 더해야한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        //Char 안에 숫자가 아니라 문자로 저장되어 있음(아스키코드가 다름)
        //숫자와 문자의 아스키코드 차이는 48
        for (int i = 0; i < cNum.length; i++) {
            System.out.println(cNum[i]);
            sum += cNum[i] - 48;
        }
        System.out.println(sum);
    }

}
