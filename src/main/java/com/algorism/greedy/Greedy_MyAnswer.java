package com.algorism.greedy;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

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

        int[] arrCard = new int[cntCard];

        for (int i = 0; i < cntCard; i++) {
            arrCard[i] = sc.nextInt();
        }

        Arrays.sort(arrCard);

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
    public void bindNumber() {
        Scanner sc = new Scanner(System.in);
        //카드 묶음의 수 저장하기
        int N = sc.nextInt();
        // 양수는 내림차순 정렬하기
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        //4개의 그룹으로 분리해 저장하기
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            if (data > 1){
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }
        int sum = 0;
        //양수 처리하기
        while (plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }
        if (!plusPq.isEmpty()) {
            sum = sum + plusPq.remove();
        }
        //음수 처리하기
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }
        //1 처리하기
        sum = sum + one;
        System.out.println(sum);

    }

    public void assignMeetingRoom() throws IOException{
        Scanner sc = new Scanner(System.in);
        int cntMeeting = sc.nextInt();
        int[] start = new int[cntMeeting];
        HashMap<Integer, Integer> hmTime = new HashMap<>();

        for (int i = 0; i < cntMeeting; i++) {
            start[i] = sc.nextInt();
            int end = sc.nextInt();
        }

        int maxMeeting = 0;

        //start
    }

    public void assignMeetingRoom_Answer() throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        Arrays.sort(A, new Comparator<int[]>(){
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1] == E[1]) {
                    // 종료 시간이 같을 때
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });
        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            //겹치지 않는 다음 회의가 나온 경우
            if (A[i][0] >= end) {
                //종료 시간 업데이트 하기
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
