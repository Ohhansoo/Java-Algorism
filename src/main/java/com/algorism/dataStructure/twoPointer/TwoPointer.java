package com.algorism.dataStructure.twoPointer;

/**
* 투포인터는 2개의 포인터로 알고리즘의 시간 복잡도를 최적화합니다.
* */
public class TwoPointer {

    //[03-3] 투 포인터
    public static void main(String[] args){

        TwoPointer_MyAnswer myAnswer = new TwoPointer_MyAnswer();

        //문제 1(03-3-006) : 연속된 자연수의 합 구하기
        /************************************** 개 요 *************************************
         * 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
         * 어떤 자연수 N(1<=N<= 10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알아보자
         * */
        //입력 : 1번째 줄에 정수 N이 주어진다
        //[예제 입력1] : 15 (N) 
        //[예제 출력1] : 4
        //System.out.println("문제 1(03-3-006) : 연속된 자연수의 합 구하기");
        //myAnswer.consecutiveNaturalNum();

        //문제 2(03-3-007)  : 주몽의 명령
        /************************************** 개 요 *************************************
         * 주몽의 명령으로 갑옷을 만드는 도중 갑옷을 만드는 재료들은 각각 고유한 번호가 있고,
         * 갑옷은 2개의 재료로 만드는 데 2가지 재료의 고유한 번호를 합쳐 (1 <= M <= 10,000,000)이 되면 갑옷이 만들어진다는 사실을 발견했다.
         * N(1 <= N <= 15,000)개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 정수 N이 주어진다
        //[예제 입력1] : 6 (재료의 개수)
        //             9 (갑옷이 완성되는 번호의 합)
        //             2 7 4 1 5 3 (재료들)
        //[예제 출력1] : 4
        //System.out.println("문제 2(03-3-007)  : 주몽의 명령");
        //myAnswer.jumongsOrder();

        //문제 3(03-3-008) : '좋은 수' 구하기
        /************************************** 개 요 *************************************
         * 주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다.
         * N개의 수 중 좋은 수가 총 몇 개 인지 출력하시오.
         * */
        //입력 : 1번째 줄에 수의 개수 N(1 <= N <= 2,000), 2번째 줄에 N개의 수의 값(Ai)이 주어진다.
        //     |Ai| <= 1,000,000,000, Ai는 정수)
        //[예제 입력1] : 10 (수의 개수)
        //             1 2 3 4 5 6 7 8 9 10
        //[예제 출력1] : 8
        System.out.println("문제 3(03-3-008) : '좋은 수' 구하기");
        myAnswer.findGoodNumber();

    }
}