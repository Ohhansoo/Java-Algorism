package com.algorism.sort.insertion;

import java.util.Scanner;

public class InsertionSort_MyAnswer {

    /*
     * [TIP] N의 최대값이 1,000이고, 시간 제한이 1초이므로 시간 복잡도가 O(n2)이하인 정렬 알고리즘 사용
     * */
    public void ATMWithdrawalTime(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        //삽입 정렬
        for (int i = 1; i < N; i++) {
           int insert_point = i;
           int insert_value = A[i];

           for (int j = i-1; j >= 0; j--) {
               if(A[j] < A[i]) {
                   insert_point = j + 1;
                   break;
               }
               if(j == 0){
                   insert_point = 0;
               }
           }

           for(int j = i; j > insert_point; j++){
               A[j] = A[j-1];
           }
           A[insert_point] = insert_value;
        }
        //합 배열 만들기
        S[0] = A[0];

        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + A[i];
        }

        //합배열 총합 구하기
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum = sum + S[i];
        }
        System.out.println(sum);

    }

}
