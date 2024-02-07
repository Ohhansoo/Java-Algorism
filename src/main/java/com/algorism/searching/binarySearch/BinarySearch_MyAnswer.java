package com.algorism.searching.binarySearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_MyAnswer {


    /*
     * [TIP] N의 최대 범위가 100,000 이므로 단순 반복문으로는 이 문제를 풀 수 없다.
     * 이진 탐색을 적용하면 O(nlogn) 시간 복잡도로 해결할 수 있다.
     * */
    public void findInteger() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            //이진 탐색 시작
            int start = 0;
            int end = A.length - 1;
            while (start <= end) {
                int midi = (start + end) / 2;
                int midV = A[midi];
                if (midV > target) {
                    end = midi - 1;
                } else if (midV < target) {
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    /*
     * [TIP] '블루레이의 크기가 모두 같고 녹화 순서가 바뀌지 않아아함' 이라는 문제 조건이 이진 탐색 알고리즘을 선택하는 실마리이다.
     * 모두 저장할 수 있다면 블루레이 크기를 줄이고, 저장할 수 없다면 블루레이 크기를 늘리는 방식으로 블루레이 크기의 최솟값을 알 수 있다.
     * */
    public void makeBlueLay(){

    }
}
