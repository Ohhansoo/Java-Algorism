package com.algorism.numberTheory.extendedEuclidean;

import java.io.IOException;

/**
 * 확장 유클리드 호제법 : 유클리드 호제법의 목적이 두 수의 최대 공약수를 구하는 것이었다면,
 *                     확장 유클리드 호제법의 목적은 방정식의 해를 구하는 것이다

 * [확장 유클리드 호제법]
 *  확장 유클리드 호제법의 핵심이론은 ax + by = c(a, b, c, x, y는 정수)이다
 *  이 때 방정식은 c % gcd(a, b) = 0인 경우에만 정수해를 가진다.
 *  다시 말해 c가 a와 b의 최대 공약수의 배수인 경우에만 정수해를 가진다.
 *  이는 ax + by = c가 정수해를 갖게하는 c의 최솟값이 gcd(a, b)라는 것을 의미한다.
 * */
public class ExtendedEuclidean {
    public static void main(String[] args) throws IOException {
        ExtendedEuclidean_MyAnswer myAnswer = new ExtendedEuclidean_MyAnswer();

        //문제 1(07-4-045) : Ax + By = C
        /************************************** 개 요 *************************************
         * A, B, C가 주어졌을 때 Ax + By = C를 만족하면서 다음 조건을 만족하는 (x, y)쌍을 찾으시오.
         * x,y는 정수
         * 1,000,000,000 <= x,y <= 1,000,000,000
         * */
        //입력 : 1번째 줄에 정수 A,B,C가 주어진다.
        //출력 : Ax + By = C를 만족하는 x,y를 공백으로 구분해 출력한다. 문제의 조건을 만족하는 (x,y)가 존재하지 않을 떄는 -1를 출력한다.
        //[예제 입력1] : 1 2 3 // A B C
        //[예제 출력1] : 3 0

        System.out.println("문제 1(07-2-042) : 최소 공배수 구현하기");
        myAnswer.extendedEuclidean();

    }
}
