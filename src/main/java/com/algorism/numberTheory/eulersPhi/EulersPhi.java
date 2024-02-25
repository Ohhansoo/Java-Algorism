package com.algorism.numberTheory.eulersPhi;

import com.algorism.numberTheory.primeNumber.PrimeNumber_MyAnswer;

/**
 * 오일러 피 : 1부터 N까지 범위에서 N과 서로소인 자연수의 개수를 뜻합니다.
 *
 * [오일러 피]
 * 1. 구하고자 하는 오일러 피의 범위만큼 배열을 초기화한다.
 * 2. 2부터 시작해 현재 배열의 값과 인덱스가 같으면(= 소수일 때) 현재 선택된 숫자(K)의 배수에 해당하는 수를
 *    배열에 끝까지 탐색하며 P[i] = P[i] - P[i]/K 연산을 수행한다.(i는 K의 배수)
 * 3. 배열의 끝까지 2를 반복하여 오일러 피 함수를 완성한다.
 * */
public class EulersPhi {

    public static void main(String[] args) {
        EulersPhi_MyAnswer myAnswer = new EulersPhi_MyAnswer();

        //문제 1(07-2-041) : 오일러 피 함수 구현하기
        /************************************** 개 요 *************************************
         * 자연수 n이 주어졌을 때 GCD(n,k) = 1(1 <= k <= n)을 만족하는 자연수의 개수를 구하는 프로그램을 작성하시오
         * */
        //입력 : 1번째 줄에 자연수 n(1 <= n <= 10^12)이 주어진다.
        //출력 : GCD(n,k) = 1(1 <= k <= n)을 만족하는 자연수의 개수를 출력한다.
        //[예제 입력1] : 10
        //[예제 출력1] : 4

        System.out.println("문제 1(07-2-041) : 오일러 피 함수 구현하기");
        //myAnswer.findPrimeNumber();
    }

}
