package com.algorism.sort.radix;

import java.io.*;

/**
 * 기수 정렬 : 값을 비교하지 않는 특이한 정렬
 *           값을 놓고 비교할 자릿수를 정한 다음 해당 자릿수만 비교한다.
 *           시간 복잡도는 O(kn)으로, 여기서 k는 데이터의 자릿수를 말한다.
 *           시간 복잡도가 가장 짧은 정렬로 데이터 개수가 많을 경우 고려해본다.
 * */
public class RadixSort_MyAnswer {
    public static int[] A;
    public static long result;

    /*
     * [TIP] N의 최대 범위가 1,000,000 이므로 O(nlogn)의 시간 복잡도로 정렬을 수행하면 된다.
     *      앞에서 배운 병합 정렬로 정렬을 수행한 후 결과 출력
     * */
    public void sortingNumbers03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A, 5);
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void Radix_Sort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;

        // 최대 자릿수만큼 반복하기
        while (count != max_size) {
            int[] bucket = new int[10];
            // 일의 자리부터 시작하기
            for(int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++;
            }
            // 합 배열을 이용해 index 계산하기
            for(int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            // 현재 자릿수를 기준으로 정렬하기
            for(int i = A.length - 1; i >= 0; i--) {
                output[bucket[(A[i] / jarisu % 10)] -1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
            for(int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
