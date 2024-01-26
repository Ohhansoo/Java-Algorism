package com.algorism.sort.selection;

import com.algorism.sort.bubble.BubbleSort_MyAnswer;

import java.io.IOException;

/**
 * 선택 정렬 : 대상 데이터에서 최대나 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택하는 방법
 *            구현 방법이 복잡하고, 시간 복잡도도 O(N2)로 효율적이지 않아 많이 사용되진 않는다.
 *            최솟값 또는 최댓값을 찾고, 남은 정렬 부분의 가장 앞에 있는 데이터와 swap 하는 것이 핵심
 * [과정]
 * 1. 남은 정렬 부분에서 최솟값 또는 최댓값을 찾는다.
 * 2. 남은 정렬 부분에서 가장 앞에 있는 데이터와 선택된 데이터를 swap한다.
 * 3. 가장 앞에 있는 데이터의 위치를 변경해(index++) 남은 정렬 부분의 범위를 축소한다.
 * 4. 전체 데이터 크기만큼 index가 커질 때까지, 즉 남은 정렬 부분이 없을 떄까지 반복한다.
 * */
public class SelectionSort {

    public static void main(String[] args) throws IOException {

        SelectionSort_MyAnswer myAnswer = new SelectionSort_MyAnswer();

        //문제 1(04-2-017) : 내림차순으로 자릿수 정렬하기
        /************************************** 개 요 *************************************
         * 배열을 정렬하는 것은 쉽다. 수가 주어지면 그 수의 각 자릿수를 내림차순으로 정렬하시오.
         * */
        //입력 : 1번째 줄에 정렬할 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수다.
        //출력 : 1번째 줄에 자릿수를 내림차순 정렬한 수를 출력한다.
        //[예제 입력1] : 2143
        //[예제 출력1] : 4321
        System.out.println("문제 1(04-2-017) : 내림차순으로 자릿수 정렬하기");
        myAnswer.sortDescending();

    }
}
