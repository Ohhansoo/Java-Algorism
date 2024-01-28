package com.algorism.sort.quick;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class QuickSort_MyAnswer {


    /*
     * [TIP] N의 최대 범위가 5,000,000 이므로 O(nlogn)의 시간복잡도로 정렬을 수행하면 된다.
     *      어떤 값을 pivot으로 정하면 K번째 수를 더 빨리 구할 수 있을지 생각 필요
     * */
    public void findKthNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K) {
                return;
            }
            // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
            else if (K < pivot){
                quickSort(A, S, pivot-1, K);
            }
            // K가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
            else {
                quickSort(A, pivot + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;
        //중앙값을 1번째 요소로 이동하기
        swap(A, S, M);

        int pivot = A[S];
        int i = S, j = E;
        while (i < j) {
            while (pivot < A[j]){
                j--;
            }
            while (i < j && pivot >= A[i]) {
                i++;
            }
            swap(A, i, j);
        }
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
