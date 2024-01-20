package com.algorism.dataStructure.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindPrefixSum {

    public static void findPrefixSum01() {

        Scanner sc = new Scanner(System.in);

        int dataCnt = sc.nextInt();
        int questionCnt = sc.nextInt();

        int[] PrefixSumArray = new int[dataCnt];
        PrefixSumArray[0] = sc.nextInt();

        for (int i = 1; i <= dataCnt - 1; i++) {
            PrefixSumArray[i] = PrefixSumArray[i - 1] + sc.nextInt();
        }

        for (int i = 1; i <= questionCnt; i++) {
            int firstIndex = sc.nextInt() - 2;

            int firstNum = firstIndex < 0 ? 0 : PrefixSumArray[firstIndex];
            int lasttNum = PrefixSumArray[sc.nextInt() - 1];
            System.out.println(lasttNum - firstNum);
        }
    }


    public static void findPrefixSum02() {

        Scanner sc = new Scanner(System.in);

        int squareNum = sc.nextInt();

        int [][] arrSquareNum = new int[squareNum + 1][squareNum + 1];
        int questionCnt = sc.nextInt();

        //D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
        for (int i = 1; i <= squareNum; i++) {
            for (int j = 1; j <= squareNum; j++) {
                arrSquareNum[i][j] = arrSquareNum[i][j-1] + arrSquareNum[i-1][j] - arrSquareNum[i-1][j-1] + sc.nextInt();
            }
        }
       // D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
        for (int i = 1; i <= squareNum; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int answer = arrSquareNum[x2][y2] - arrSquareNum[x1-1][y2] - arrSquareNum[x2][y1-1] + arrSquareNum[x1-1][y1-1];
            System.out.println(answer);
        }

    }

    public static void findPrefixSum03() {

    }

    public static void findPrefixSum01_Answer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            for(int j =1; j <= N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int D[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++){
            for(int j =1; j <= N; j++){
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }

    }

    public static void findPrefixSum02_Answer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= suNo; i++){
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q = 0; q < quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }

    public static void findPrefixSum03_Answer() throws IOException {
        Scanner sc = new Scanner(System.in);
        //수열의 개수
        int N = sc.nextInt();
        //나누어떨어져야하는 수
        int M = sc.nextInt();
        //합 배열
        long[] S = new long[N];
        //같은 나머지의 인덱스를 카운트하는 배열
        long[] C = new long[M];

        long answer = 0;
        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++){
            S[i] = S[i - 1] + sc.nextInt();
        }

        //합 배열의 모든 값에 % 연산 수행하기
        for(int i = 0; i < N; i++){
            int remainder = (int) (S[i] % M);
            // 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
            if (remainder ==0) answer++;
            //나머지가 같은 인덱스의 개수 카운팅
            C[remainder]++;
        }

        for (int i = 0; i < M; i++){
            if (C[i] > 1){
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }

}
