package com.algorism.dataStructure.arraysAndLists;

import java.util.Arrays;
import java.util.Scanner;

import static com.algorism.dataStructure.arraysAndLists.Average.average_answer;
import static com.algorism.dataStructure.arraysAndLists.Sum.sum;
import static com.algorism.dataStructure.arraysAndLists.Sum.sum_answer;

public class ArraysAndLists_Answer {

    //03-1 배열과 리스트
    //문제 : 숫자의 합 구하기
    /**
     * 1번째 줄에 숫자의 개수 N (1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
     * */
    public static void main(String[] args){

        //문제 : 숫자의 합 구하기
        sum_answer(25, "10987654321");

        //문제2 : 평균 구하기
        average_answer(3, new int[] {10, 20 ,30});

    }




}
