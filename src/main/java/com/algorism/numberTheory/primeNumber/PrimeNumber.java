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

    }
}
