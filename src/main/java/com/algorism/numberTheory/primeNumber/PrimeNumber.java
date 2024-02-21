package com.algorism.numberTheory.primeNumber;

import com.algorism.sort.bubble.BubbleSort_MyAnswer;

import java.io.IOException;

/**
 * 소수 구하기 : 자신보다 작은 2개의 자연수를 곱해 만들 수 없는 1보다 큰 자연수.
 *              1과 자기 자신 외에 약수가 존재하지 않는 수.
 *              대표적인 판별법으로 에'라토스테네스의 체' 가 있다.
 *              시간복잡도는 O(n^2)이지만 최적화에 따라 일반적으로 O(logN)이다.
 *
 * [에라토스테네스의 체]
 * 1. 구하고자 하는 소수의 범위만큼 1차원 배열 생성
 * 2. 2부터 시작하고 현재 숫자가 지워지지 않을 때는 현재 선택된 숫자의 배수에 해당하는 수를 배열에서 끝까지 탐색하며 지운다.
 *    이 때 처음으로 선택된 숫자는 지우지 않는다.
 * 3. 배열의 끝까지 2를 반복한 후 배열에서 남아 있는 모든 수를 출력한다.
 * */
public class PrimeNumber {

    public static void main(String[] args) throws IOException {
        PrimeNumber_MyAnswer myAnswer = new PrimeNumber_MyAnswer();

        //문제 1(07-1-037) : 소수구하기
        /************************************** 개 요 *************************************
         * M 이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오
         * */
        //입력 : 1번째 줄에 자연수 M과 N이 빈칸을 사이에 두고 주어진다(1 <= M <= N <= 1,000,000)
        //      M 이상 N이하의 소수가 1개 이상 있는 입력만 주어진다.
        //출력 : 1줄에 1개씩, 증가하는 순서대로 소수를 출력한다.
        //[예제 입력1] : 3 16
        //[예제 출력1] : 3
        //              5
        //              7
        //              11
        //              13
        System.out.println("문제 1(07-1-037) : 소수구하기");
        myAnswer.findPrimeNumber();
    }
}
