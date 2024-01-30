package com.algorism.sort.merge;

import java.io.*;

public class MergeSort_MyAnswer {

    /*
     * [TIP] N의 최대 범위가 1,000,000 이므로 O(nlogn)의 시간 복잡도로 정렬을 수행하면 된다.
     *      앞에서 배운 병합 정렬로 정렬을 수행한 후 결과 출력
     * */
    public static int[] A, temp;
    public static long result;

    public void sortNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        temp = new int[N+1];
        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;

        //재귀 함수 형태로 구현
        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while (index1 <= m && index2 <= e) {
            // 두 그룹을 병합하는 로직
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고
            // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기.
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                k++;
                index2++;
            }
            else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }

}
