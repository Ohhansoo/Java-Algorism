package com.algorism.dataStructure.prefixSum;

import java.io.IOException;

import static com.algorism.dataStructure.prefixSum.FindPrefixSum.*;
import static com.algorism.dataStructure.prefixSum.FindPrefixSum.findPrefixSum03_Answer;

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
        //문제 2 : 구간 합 구하기
        //입력 : 1번째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다(1 <= N <= 1024, 1 <= M <= 100,000)
        //      2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
        //      다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며, (X1,Y1)에서 (X2,Y2)의 합을 구해 출력해야 한다.
        //      표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다(X1 <= X2, Y1 <= Y2)
        findPrefixSum02_Answer();

        //문제 3 : 나머지 합 구하기
        /**
         * 나머지 합 문제 풀이의 핵심 아이디어
         * (A + B ) % C는 ((A % C) + (B % C)) % C 와 같다.
         * 다시 말해 특정 구간 수들의 나머지 연산을 더해 나머지 연산을 한 값과 이 구간 합의 나머지 연산을 한 값은 동일하다.
         * 또한 S[i] % M의 값과 S[j] % M의 값이 같다면 (S[i] - S[j]) % M은 0이다.
         * S[i] - S[j]은 합 배열 공식으로서, 원본 배열의 j + 1부터 i까지의 구간 합이다. 따라서 해당 구간 합이 M으로 떨어진다는 것을 알 수 있다.
         * */
        //입력 : 1번째 줄에 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 출력한다.
        findPrefixSum03_Answer();

    }



}
