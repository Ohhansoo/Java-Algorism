package com.algorism.sort.merge;

import java.io.IOException;

/**
 * 병합 정렬 : 분할 정복(divide and conquer)방식을 사용해 데이터를 분할하고 분할한 집합을 정렬하며 합치는 알고리즘.
 *           병합 정렬의 시간 복잡도 평균값은 O(nlogn)이다.
 * */
public class MergeSort {

    public static void main(String[] args) throws IOException {

        MergeSort_MyAnswer myAnswer = new MergeSort_MyAnswer();

        //문제 1(04-5-020) : 수 정렬하기 2
        /************************************** 개 요 *************************************
         * N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 N(1 <= N <= 1,000,000)
        //      2번째 줄부터 N개의 줄에 숫자가 주어진다. 이 수는 절대값이 1,000,000보다 작거나 같은 정수다. 수는 중복되지 않는다.
        //출력 : 1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력한다.
        //[예제 입력1] : 5 // 수의 개수
        //              5  4  3  2  1
        //[예제 출력1] : 1  2  3  4  5
        System.out.println("문제 1(04-5-020) : 수 정렬하기 2");
        myAnswer.sortNumber();

    }

}
