package com.algorism.sort.quick;

import com.algorism.sort.selection.SelectionSort_MyAnswer;

import java.io.IOException;


/**
 * 퀵 정렬 : 기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘
 *          기준값이 어떻게 선정되는지가 시간 복잡도에 많은 영향을 미치며 시간 복잡도는 O(nlogn)입니다.
 * [과정]
 * 1. 데이터를 분할하는 pivot을 설정한다.
 * 2. pivot을 기준으로 다음 a~e과정을 거쳐 데이터를 2개의 집합으로 분리한다.
 *  2-a. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start를 오른쪽으로 1칸 이동한다.
 *  2-b. end가 가리키는 데이터가 pivot이 가리키는 데이터보다 크면 end를 왼쪽으로 1칸 이동한다.
 *  2-c. strat가 가리키는 데이터가 pivot이 가리키는 데이터보다 크고, end가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면
 *       start, end가 가리키는 데이터를 swap하고 start는 오른쪽, end는 왼쪽으로 1칸씩 이동한다.
 *  2-d  start와 end가 만날 때 까지 2-a, 2-c를 반복한다.
 *  2-e  start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여
 *       pivot이 가리키는 데이터 크면 만난 지점의 오른쪽에, 작으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입한다.
 * 3.   분리 집합에서 각각 다시 pivot을 선정한다.
 * 4.   분리 집합이 1개 이하가 될 때까지 과정 1~3을 반복한다.
 * */
public class QuickSort {

    public static void main(String[] args) throws IOException {

        QuickSort_MyAnswer myAnswer = new QuickSort_MyAnswer();

        //문제 1(04-4-019) : K번째 수 구하기
        /************************************** 개 요 *************************************
         * 수 N개(A1,A2...AN)개가 주어진다. A를 오름차순 정렬했을 때 앞에서부터 K번째에 있는 수를 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 N(1 <= N <= 5,000,000)
        //출력 : 2번째 줄에 A1, A2, ..., AN이 주어진다(-109 <= Ai <= 109)
        //[예제 입력1] : 5 2 // 데이터 개수, K번째 수
        //              4 1 2 3 5
        //[예제 출력1] : 2
        System.out.println("뮨제 1(04-4-019) : K번째 수 구하기");
        myAnswer.findKthNumber();

    }

}
