package com.algorism.numberTheory.primeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrimeNumber_MyAnswer {

    /*
    * N의 최대 범위가 1,000,000이므로 일반적인 소수 구하기 방식으로 풀면 시간 초과
    * 따라서 에라토스테네스 방식으로 풀어야 한다.
    * */
    public void findPrimeNumber() throws IOException{
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[] A = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }
        //제곱근까지만 수행하기
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j = j + i){
                A[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[(int) i]);
            }
        }
    }

    /*
    * 에라토스테네스의 체를 이용해 빠르게 소수를 구한다.
    * 주어진 소수들이 A ~ B 범위안에 존재하는지 판별해 유효한 소수의 개수를 센다
    * */
    public void sumRemainder() throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        long[] A = new long[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        //제곱근까지만 수행하기
        for (int i = 2; i <= Math.sqrt(A.length); i++) {

            if (A[i] == 0){
                continue;
            }
            //배수 지우기
            for (int j = i + i; j < A.length; j = j+i) {
                A[j] = 0;
            }
        }
        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (A[i] != 0) {
                long temp = A[i];
                while ((double)A[i] <= (double) Max/(double) temp){
                    if ((double) A[i] >= (double) Min / (double) temp) {
                        count++;
                    }
                    temp = temp * A[i];
                }
            }
        }
        System.out.println(count);
    }

    public void findMinOfRemainderAndPalindrome() throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[10000001];
        //N의 범위까지 소수 구하기
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        //제곱근까지만 수행하기
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }
            //배수 지우기
            for (int j = i + i; j < A.length; j = j + i){
                A[j] = 0;
            }
        }
        int i = N;
        //N부터 1씩 증가시키면서 소수와 팰린드롬 수가 맞는지 확인하기
        while (true) {
            if (A[i] != 0) {
                int result = A[i];
                if (isPalindrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }
    //팰린드롬 수 판별 함수
    //@@ 왜 굳이 char로 바꿔서 진행하는지?
    private static boolean isPalindrome(int target) {
        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        while (s < e) {
            if (temp[s] != temp[e]) return false;
            s++;
            e--;
        }
        return true;
    }

    public void findNotSquare() throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        //최대값과 최솟값의 차이만큼 배열 선언하기
        boolean[] Check = new boolean[(int) (Max - Min + 1)];
        //2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i;
            long start_index = Min / pow;
            if (Min % pow != 0) {
                // 나머지가 있으면 1을 더해야 Min보다 더 큰 제곱수에서 시작됨
                start_index++;
            }
            // 제곱수를 true로 변경하기
            for (long j = start_index; pow * j <= Max; j++) {
                Check[(int) ((j * pow) - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!Check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
