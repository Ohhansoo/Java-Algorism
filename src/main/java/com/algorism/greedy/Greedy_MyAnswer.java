package com.algorism.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_MyAnswer {

    public void findMinimumCoins_MyAnswer() throws IOException {
        Scanner sc = new Scanner(System.in);
        int coinCnt = sc.nextInt();
        int targetMoney = sc.nextInt();

        int[] tempArr = new int[coinCnt];

        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = sc.nextInt();
        }

        //내림차순 정렬
        Integer [] TempCoinType = Arrays.stream(tempArr).boxed().toArray(Integer [] :: new);
        Arrays.sort(TempCoinType, Collections.reverseOrder());
        int[] coinType = Arrays.stream(TempCoinType).mapToInt(i -> i).toArray();

        int money = 0;
        int necessaryCoin = 0;
        int remainCoin = 0;

        for (int i = 0; i < coinType.length; i++) {
            if(targetMoney <= 0) break;

            if (targetMoney / coinType[i] > 0) {
                necessaryCoin += targetMoney / coinType[i];
                money += coinType[i] * necessaryCoin;
                targetMoney -= money;
            }
        }
        System.out.println(necessaryCoin);
    }
    public void findMinimumCoins(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if(A[i] <= K) {
                count += (K/A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
    }

    public void sortCard_MyAnswer() {
        Scanner sc = new Scanner(System.in);
        int cntCard = sc.nextInt();

        Integer[] arrTempCard = new Integer[cntCard];

        for (int i = 0; i < cntCard; i++) {
            arrTempCard[i] = sc.nextInt();
        }

        Arrays.sort(arrTempCard);

        int[] arrCard = Arrays.stream(arrTempCard).mapToInt(i -> i).toArray();
        int[] arrSum;

        if (cntCard > 1) {
            arrSum = new int[cntCard-1];
            arrSum[0] = arrCard[0] + arrCard[1];

            for (int i = 1; i < cntCard-1; i++) {
                arrSum[i] = arrSum[i-1] + arrCard[i+1];
            }
        }
        else {
            arrSum = new int [] {arrCard[0]};
        }
        System.out.println(Arrays.stream(arrSum).sum());
    }

    public void sortCard() {

    }
}
