package com.algorism.sort.selection;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SelectionSort_MyAnswer {


    public void sortDescending_MyAnswer() throws IOException {
        Scanner sc = new Scanner(System.in);
        Long number = sc.nextLong();
        String[] arrNum = number.toString().split("");
        Arrays.sort(arrNum, Collections.reverseOrder());
        String strNum = "";

        for(int i=0; i< arrNum.length; i++){
            strNum += arrNum[i];
        }

        System.out.println(Long.parseLong(strNum));
    }

    /*
    * [TIP] 자바의 내장 함수를 사용해도 되지만, n의 길이가 크지 않으므로 앞에서 배운 선택 정렬을 사용해 내림차순 정렬
    *       나머지 연산을 분리할 수도 있지만, 입력값을 String으로 받은 후 substring()함수를 이용해 자릿수 단위로 분리하고
    *       이를 다시 int형으로 변경해 배열에 저장해보기
    * */
    public void sortDescending() throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i+1; j < str.length(); j++) {
                // 내림차순이므로 최댓값을 찾음
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.println(A[i]);
        }
    }
}
