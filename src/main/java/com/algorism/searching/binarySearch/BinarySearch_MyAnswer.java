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
     * 이진 탐색의 시작 인덱스는 최대 레슨 시간, 종료 인덱스는 레슨 시간을 모두 합한 값
     * */
    public void makeBlueLay_MyAnswer(){
        Scanner sc = new Scanner(System.in);
        int lesseonCnt = sc.nextInt();
        int bluelayCnt = sc.nextInt();

        int[] arrLesson = new int[lesseonCnt];

        for (int i = 0; i < arrLesson.length; i++) {
            arrLesson[i] = sc.nextInt();
        }
        Arrays.sort(arrLesson);
        boolean find = false;
        while(true) {
            if (find) break;

            for (int i = 0; i < bluelayCnt; i++) {

            }
        }
        for (int i = 0; i < bluelayCnt; i++) {
            //이진 탐색 시작
            int stIndex = arrLesson[lesseonCnt-1];
            int edInex = Arrays.stream(arrLesson).sum();

            while(stIndex <= edInex){
                int midi = (stIndex + edInex) / 2;
                int midV = arrLesson[midi];
            }
        }
    }
    public void makeBlueLay() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
            //레슨 최대값을 시작 인덱스로 저장하기
            if (start < A[i]) start = A[i];
            //모든 레슨의 총합을 종료 인덱스로 저장하기
            end = end + A[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > middle) {
                    count++;
                    sum = 0;
                }
                //현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체한다는 의미
                sum = sum + A[i];
            }
            // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더하기
            if (sum != 0) {
                count++;
            }
            if (count > M) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
            System.out.println(count);
        }
        System.out.println(start);
    }

    /*
     * [TIP] k의 범위가 1 ~ min(10^9, N^2)이므로 시간 복잡도가 N^2인 일고리즘은 사용할 수 없다.
     * 따라서 이진 탐색을 이용한다.
     * 중앙값보다 작거나 같은 수의 개수는 Math.min(middle / i,N)으로 계산합니다.
     * */
    public void findKthNumber() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1;
        long end = K;
        long ans = 0;

        //이진 탐색 수행하기
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            // 중앙값보다 작은 수는 몇 개인지 계산하기
            for (int i = 1; i <= N; i++) {
                //작은 수를 카운트하는 핵심 로직
                cnt += Math.min(middle / i, N);
            }
            if (cnt < K) {
                start = middle + 1;
            }
            else {
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
}
