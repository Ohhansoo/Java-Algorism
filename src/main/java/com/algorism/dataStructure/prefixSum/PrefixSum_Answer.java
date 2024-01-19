package com.algorism.dataStructure.prefixSum;

import static com.algorism.dataStructure.prefixSum.FindPrefixSum.findPrefixSum01;

/** 구간 합 : 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘
 * */
public class PrefixSum {

    /**
     * 합 배열 : 기존의 배열을 전처리한 배열
     * 미리 합 배열을 구해놓음으로써, 시간 복잡도를 O(N) -> O(1)로 줄일 수 있다.
     * [정의] : S[i] = A[0] + A[1] + A[2] + ... + A[i-1] + A[i]
     * [합 배열 S를 만드는 공식] : S[i] = S[i-1] + A[i]
     * [i에서 j까지의 구간합 공식] : S[j] - S[i-1]
     * */

    public static void main(String[] args){
        //문제 1 : 구간 합 구하기
        //입력 : 1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야 하는 횟수 M(1 <= M <= 100,000)
        //      2번째 줄에 N개의 수가 주어진다.
        //      각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
        findPrefixSum01();
    }



}
