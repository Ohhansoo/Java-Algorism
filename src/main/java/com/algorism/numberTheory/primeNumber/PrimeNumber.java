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
       //myAnswer.findPrimeNumber();

        //문제 2(07-1-038) : 나머지 합 구하기
        /************************************** 개 요 *************************************
         * 어떤 수가 소수의 N제곱(N >= 2)일 때 이 수를 '거의 소수'라고 한다. A와 B가 주어질 때 A보다 크거나
         * 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력하는 프로그램을 작성하시오
         * */
        //입력 : 1번째 줄에 왼쪽 범위 A와 오른쪽 범위 B가 공백 한 칸을 사이에 두고 주어진다.
        //      A의 범위는 10^14보다 작거나 같은 자연수, B는 A보다 크거나 같고 10^14보다 작거나 같은 자연수다
        //출력 : 1번째 줄에 거의 소수가 총 몇개가 있는지 출력한다.
        //[예제 입력1] : 1 1000 //A, B
        //[예제 출력1] : 25
        System.out.println("문제 2(07-1-038) : 나머지 합 구하기");
        //myAnswer.sumRemainder();


        //문제 3(07-1-039) : 소수 & 팰린드롬 수 중에서 최솟값 찾기
        /************************************** 개 요 *************************************
         * 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 '팰린드롬'이라 부른다.
         * 예를 들어 79197과 324423 등이 팰린드롬 수다.
         * 어떤 수 N(1 <= N <= 1,000,000)이 주어졌을 때 N보다 크거나 같고 소수이면서 팰린드롬인 수 중
         * 가장 작은 수를 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 N이 주어진다.
        //출력 : 1번째 줄에 조건을 만족하는 수를 출력한다.
        //[예제 입력1] : 31
        //[예제 출력1] : 101
        System.out.println("문제 3(07-1-039) : 소수 & 팰린드롬 수 중에서 최솟값 찾기");
        //myAnswer.findMinOfRemainderAndPalindrome();

        //문제 4(07-1-040) : 제곱이 아닌 수 찾기
        /************************************** 개 요 *************************************
         * 어떤 수 X가 1보다 큰 제곱수로 나누어떨어지지 않을 때, 이 수를 '제곱이 아닌 수'라고 가정해보자.
         * 여기서 제곱수는 정수의 제곱이다. min과 max의 값이 주어질 때 min보다 크고, max보다 작은 값 중
         * '제곱이 아닌 수'가 몇 개 있는지 출력하시오
         * */
        //입력 : 1번째 줄에 두 정수 min과 max가 주어진다.
        //출력 : 1번째 줄에 [min, max] 구간에 제곱이 아닌 수가 몇 개인지 출력한다.
        //      (1 <= min <= 1,000,000,000,000, min <= max <= min + 1,000,000)
        //[예제 입력1] : 1 10 //min max
        //[예제 출력1] : 7
        System.out.println("문제 4(07-1-040) : 제곱이 아닌 수 찾기");
        myAnswer.findNotSquare();

    }
}