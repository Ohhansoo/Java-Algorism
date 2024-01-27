package com.algorism.sort.insertion;

import com.algorism.sort.selection.SelectionSort_MyAnswer;

/**
 * 삽입 정렬 : 이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식
 *            평균 시간복잡도는 O(n2)으로 느린 편이지만 구현하기가 쉽다.
 *            적절한 삽입 위치를 탐색하는 부분에서 이진 탐색 등과 같은 탐색 알고리즘을 사용하면 시간 복잡도를 줄일 수 있다.
 * [과정]
 * 1. 현재 index에 있는 데이터 값을 선택한다.
 * 2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다.
 * 3. 삽입 위치부터 index에 있는 위치까지 shift 연산을 수행한다.
 * 4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행한다.
 * 5. 전체 데이터의 크기만큼 index가 커질 때까지, 즉 선택할 데이터가 없을 때까지 반복한다.
 * */
public class InsertionSort {

    public static void main(String[] args){
        InsertionSort_MyAnswer myAnswer = new InsertionSort_MyAnswer();

        //문제 1(04-2-018) : ATM 인출 시간 계산하기
        /************************************** 개 요 *************************************
         * 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는 데 걸리는 시간 Pi가 주어졌을 때 각 사람이 돈을 인출하는 데
         * 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 사람의 수 N(1 <= N <= 1,000)
        //출력 : 2번째 줄에 각 사람이 돈을 인출하는 데 걸리는 시간 Pi(1 <= Pi <= 1,000)가 주어진다.
        //[예제 입력1] : 5 (데이터 개수)
        //              3 1 4 3 2
        //[예제 출력1] : 32
        System.out.println("문제 1(04-2-017) : 내림차순으로 자릿수 정렬하기");
        myAnswer.ATMWithdrawalTime();
    }


}
