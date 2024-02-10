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

    }
}
