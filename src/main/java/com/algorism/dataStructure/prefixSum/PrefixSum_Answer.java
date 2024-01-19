package com.algorism.dataStructure.prefixSum;

import java.io.IOException;

import static com.algorism.dataStructure.prefixSum.FindPrefixSum.*;

/** 구간 합 : 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘
 * */
public class PrefixSum_Answer {

    /**
     * 합 배열 : 기존의 배열을 전처리한 배열
     * 미리 합 배열을 구해놓음으로써, 시간 복잡도를 O(N) -> O(1)로 줄일 수 있다.
     * [정의] : S[i] = A[0] + A[1] + A[2] + ... + A[i-1] + A[i]
     * [합 배열 S를 만드는 공식] : S[i] = S[i-1] + A[i]
     * [i에서 j까지의 구간합 공식] : S[j] - S[i-1]
     * */
    public static void main(String[] args) throws IOException {
        /**
         * [i에서 j까지의 구간합 공식] : S[j] - S[i-1]
         * */
        //문제 1 : 구간 합 구하기
        //입력 : 1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야 하는 횟수 M(1 <= M <= 100,000)
        //      2번째 줄에 N개의 수가 주어진다.
        //      각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
        findPrefixSum01_Answer();

        /**
         * 2차원 구간 합 배열 D[X][Y] 정의 -> 원본 배열 (0,0) 부터 (X, Y)까지의 사각형 영역 안에 있는 수의 합
         * D[i][j]의 값을 채우는 구간 합 공식
         * D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
         * */
        /**
         * 질의 X1, Y1, X2, Y2에 대한 답을 구간 합으로 구하는 방법
         * D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
         * */
        //문제 1 : 구간 합 구하기
        //입력 : 1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야 하는 횟수 M(1 <= M <= 100,000)
        //      2번째 줄에 N개의 수가 주어진다.
        //      각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
        findPrefixSum02_Answer();

    }



}
