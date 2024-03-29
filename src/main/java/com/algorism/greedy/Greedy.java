package com.algorism.greedy;

import com.algorism.searching.binarySearch.BinarySearch_MyAnswer;

import java.io.IOException;

/**
 * 그리디 알고리즘 (탐욕법) : 현재 단계의 선택지 중에서 최선을 선택해나가다 보면,
 *                         결과가 최선일 것이라고 가정하는 알고리즘
 *                         결과가 항상 최선을 보장하지 않는다.
 * 1. 해선택 : 현재 단계에서 가장 최선의 해를 선택한다.
 * 2. 현재 선택한 선택지가 전체 문제의 제약 조건을 벗어나지 않는다.
 * 3. 해검사 : 결과가 전체 문제를 해결할 수 있는지 검사한다. 그렇지 못하면 1로 돌아가 반복한다.
 * */
public class Greedy {

    public static void main (String[] args) throws IOException {
        Greedy_MyAnswer myAnswer = new Greedy_MyAnswer();

        //문제 1(06-1-032) : 동전 개수의 최솟값 구하기
        /************************************** 개 요 *************************************
         * 준규가 소유하고 있는 동전은 총 N종류이고, 각 동전의 개수가 많다. 동전을 적절히 사용해 그 가격의 합을 K로 만들려고 한다.
         * 이 때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 N과 K(1 <= N <= 10, 1 <= K <= 100,000,000)
        //      2번째 줄부터 N개의 줄에 동전의 가격 A가 오름차순으로 주어진다
        //        (1 <= A <= 1,000,000, A1 = 1, i >= 2일 때 Ai는 Ai의 배수)
        //출력 : 1번째 줄에 K원을 만드는 데 필요한 동전 개수의 최솟값을 출력한다.
        //[예제 입력1] : 10 4200 // 동전 수, 목표 금액
        //              1
        //              5
        //              10
        //              50
        //              100
        //              500
        //              1000
        //              5000
        //              10000
        //              50000
        //[예제 출력1] : 6
        System.out.println("문제 1(05-3-032) : 동전 개수의 최솟값 구하기");
        //myAnswer.findMinimumCoins();

        //문제 2(06-2-033) : 카드 정렬하기
        /************************************** 개 요 *************************************
         * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을
         * 작성하시오.
         * */
        //입력 : 1번째 줄에 N이 주어진다 (1 <= N <= 100,000)
        //      그 다음 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
        //      숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수다.
        //출력 : 1번째 줄에 최소 비교 횟수를 출력한다.
        //[예제 입력1] : 3 // 카드 묶음 수
        //              10
        //              20
        //              40
        //[예제 출력1] : 100
        System.out.println("문제 2(06-2-033) : 카드 정렬하기");
        //myAnswer.sortCard_MyAnswer();

        //문제 3(06-2-034) : 수를 묶어서 최댓값 만들기
        /************************************** 개 요 *************************************
         * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을
         * 작성하시오.
         * */
        //입력 : 1번째 줄에 수열의 크기 N이 주어진다. N은 10,000보다 작은 자연수다.
        //      2번째 줄부터 N개의 줄에 수열의 각 수가 주어진다.
        //      수열의 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수다.
        //출력 : 합이 최대가 나오게 수를 묶었을 때 그 합을 출력한다. 정답은 항상 231보다 작다.
        //[예제 입력1] : 9 // 수의 개수
        //              -1
        //              -8
        //              2
        //              1
        //              3
        //              6
        //              -5
        //              0
        //              1
        //[예제 출력1] : 62
        System.out.println("문제 3(06-2-034) : 수를 묶어서 최댓값 만들기");
        //myAnswer.bindNumber();

        //문제 4(06-2-035) : 회의실 배정하기
        /************************************** 개 요 *************************************
         * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을
         * 작성하시오.
         * */
        //입력 : 1번째 줄에 회의의 수 N(1 <= N <= 100,000)
        //      2번째 줄부터 N+1줄까지는 각 회의의 시작 기간과 끝나는 시간이 공백을 사이에 두고 주어진다
        //      시작 시간과 끝나는 시간은 -1보다 작거나 같은 자연수 또는 0이다.
        //출력 : 1번째 줄에 진행할 수 있는 회의의 최대 개수를 출력한다.
        //[예제 입력1] : 11 // 회의 개수
        //              1 4
        //              3 5
        //              0 6
        //              5 7
        //              3 8
        //              5 9
        //              6 10
        //              8 11
        //              8 12
        //              2 13
        //              12 14
        //[예제 출력1] : 4
        System.out.println("문제 4(06-2-035) : 회의실 배정하기");
        //myAnswer.assignMeetingRoom_Answer();

        //문제 5(06-2-036) : 최솟값은 만드는 괄호 배치 찾기
        /************************************** 개 요 *************************************
         * 세준이는 양수와 +,- 그리고 괄호를 이용해 어떤 수식을 만들었다. 그리고 괄호를 모두 지우고, 다시 괄호를 적절히 넣어
         * 이 수식의 값을 최소로 만들려고 한다. 이렇게 수식의 괄호를 다시 적절하게 배치해 수식의 값을 최소로 만드는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 식이 주어진다. 식은 '0'~'9', '+' 그리고 '-'만으로 이뤄져 있고, 가장 처음과 마지막 문자는 숫자이다.
        //      그리고 연속해서 2개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
        //      수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
        //출력 : 1번째 줄에 정답을 출력한다.
        //[예제 입력1] : 100-40+50+74-30+29-45+43+11
        //[예제 출력1] : 222
        System.out.println("문제 5(06-2-036) : 최솟값은 만드는 괄호 배치 찾기");
        myAnswer.findParenthesis();
    }
}
