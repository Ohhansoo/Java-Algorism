package com.algorism.dataStructure.arraysAndLists;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Average {

    public static void average (int intCnt, int[] intScore){

        int intMax = Arrays.stream(intScore).max().getAsInt();
        int intSum = Arrays.stream(intScore).sum();

        double Answer = intSum * 100.0 /intMax /intCnt;

        System.out.println(Answer);
    }
    public static void average_answer (int intCnt, int[] intScore){

        //변환 점수의 평균을 구하는 식(점수가 A,B,C,인 경우)
        // (A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M / 3
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i < N; i++){
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            if (A[i] > max) max = A[i];
            sum = sum + A[i];
        }

        // 100뒤에 .0을 붙여야 소수점이 나옴
        System.out.println(sum * 100.0 / max / N);
    }

}
