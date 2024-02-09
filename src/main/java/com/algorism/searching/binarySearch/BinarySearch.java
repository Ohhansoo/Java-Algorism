package com.algorism.searching.binarySearch;

import com.algorism.searching.breadthFirstSearch.BFS_MyAnswer;

import java.io.IOException;


/**
 * 이진 탐색 : 데이터가 정렬돼 있는 상태에서 원하는 값을 찾아내는 알고리즘
 *  - 기능 : 다깃 데이터 탐색
 *  - 특징 : 중앙값 비교를 통한 대상 축소 방식
 *  - 시간 복잡도 : O(logN)
 *  - 응용 문제 : 단절점 찾기, 단절선 찾기, 사이클 찾기, 위상 정렬
 *  [과정]
 *   1. 현재 데이터셋의 중앙값(median)을 선택한다.
 *   2. 중앙값 > 타깃 데이터(target data)일 때 중앙값 기준으로 왼쪽 데이터셋을 선택한다.
 *   3. 중앙값 < 타깃 데이터일 때 중앙값 기준으로 오른쪽 데이터셋을 선택한다.
 *   4. 과정 1~3을 반복하다가 중앙값 == 타깃 데이터일 때 탐색을 종료한다.
 *
 */
public class BinarySearch {

    public static void main(String[] args) throws IOException {
        BinarySearch_MyAnswer myAnswer = new BinarySearch_MyAnswer();

        //문제 1(05-3-029) : 원하는 정수 찾기
        /************************************** 개 요 *************************************
         * N개의 정수 A[1], A[2], ---, A[N]이 주어져 있을 때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 자연수 N(1 <= N <= 100,000)
        //      2번째 줄에 M(1 <= M <= 100,000)
        //      그 다음 줄에 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
        //      모든 정수의 범위는 -231 보다 크거나 같고, 231보다는 작다.
        //출력 : M개의 줄에 답을 출력한다. 존재하면 1, 존재하지 않으면 0을 출력한다.
        //[예제 입력1] : 5 // 데이터 개수
        //             4 1 5 2 3
        //              5 // 찾아야 할 숫자 개수
        //              1 3 7 9 5
        //[예제 출력1] : 1
        //              1
        //              0
        //              0
        //              1
        System.out.println("문제 1(05-3-029) : 원하는 정수 찾기");
        //myAnswer.findInteger();

        //문제 2(05-3-030) : 블루레이 만들기
        //입력 : 1번째 줄에 레슨의 수 N(1 <= N <= 100,000), M(1 <= M <= N)
        //      2번째 줄에 강토의 기타 레슨의 길이가 레슨 순서대로 분 단위로(자연수)로 주어진다.
        //      각 레슨의 길이는 10,000분을 넘지 않는다.
        //출력 : 1번째 줄에 블루레이 크기 중 최솟값을 출력한다.
        //[예제 입력1] : 9 3 //레슨 수, 블루레이 개수
        //              1 2 3 4 5 6 7 8 9
        //[예제 출력1] : 17
        System.out.println("문제 2(05-3-030) : 블루레이 만들기");
        myAnswer.makeBlueLay();
    }
}
