package com.algorism.dataStructure.slidingWindow;


import java.io.IOException;

/**
 * 슬라이딩 윈도우는 2개의 포인터로 범위를 지정한 다음 범위(window)를 유지한 채로 이동(sliding)하며 문제를 해결하는 방식
 * */
public class SlidingWindow {

    public static void main(String[] args) throws NumberFormatException, IOException {
        SlidingWindow_MyAnswer myAnswer = new SlidingWindow_MyAnswer();

        //문제 1(03-3-009) : DNA 비밀번호
        //입력 : 1번째 줄에 임의로 만든 DNA 문자열의 길이 |S|와 비밀번호로 사용할 부분 문자열의 길이 |P|가 주어진다.(1 <= |P| <= |S| <= 1,000,000)
        //      2번째 줄에 임의로 만든 DAN 문자열이 주어진다.
        //      3번째 줄에 부분 문자열에 포함돼야 할 {'A', 'C', 'G', 'T'}의 최소 개수가 공백 문자를 사이에 두고 각각 주어진다.
        //      각각의 수는 |S|보다 작거나 같은 음이 아닌 정수로 총합은 |S|보다 작거나 같다는 것이 보장된다.
        //[예제 입력1] : 9 (DNA 문자열의 길이) 8 (비밀번호로 사용할 부분 문자열의 길이)
        //             CCTGGATTG (DNA 문자열)
        //             2 0 1 1 (부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수)
        //[예제 출력1] : 0
        //System.out.println("문제 1(03-3-009) : DNA 비밀번호");
        //myAnswer.DNAPassword();

        //문제 2(03-3-010) : 최솟값 찾기
        //입력 : 1번째 줄에 N과 L (1 <= L <= N <= 5,000,000)
        //      2번째 줄에 N개의 수 Ai가 주어진다 (-109 <= Ai <= 109)
        //[예제 입력1] : 12 (숫자의 개수) 3 (슬라이딩 윈도우의 크기)
        //             1 5 2 3 6 2 3 7 3 5 2 6
        //[예제 출력1] : 1 1 1 2 2 2 2 2 3 3 2 2
        System.out.println("문제 2(03-3-010) : 최솟값 찾기");
        myAnswer.findMin();

    }



}
