package com.algorism.graph.floydWarshall;

import org.springframework.util.comparator.Comparators;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FloydWarshall_MyAnswer {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int distance[][];
    public void findFastestBusRoute () throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = 10000001; //충분히 큰 수로 저장하기
                }
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //노선 데이터를 distance 행렬에 저장하기
            if (distance[s][e] > v) distance[s][e] = v;
        }
        //플로이드-워셜 알고리즘 수행하기
        // 경유지 K, 출발 노드 i, 도착 노드 j
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 10000001) System.out.println("0 ");
                else System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void findFRoute () throws IOException {

        int[] arr = {1,4,3,2,5};
        int[] min = Arrays.stream(arr).filter(i -> i % 2 == 0).sorted().toArray();
        for (int n : min) System.out.println(n);
        String[] strArr = {"a", "b", "c"};
        int num = Arrays.asList(strArr).indexOf("a");

        String str = "01023451234";

        String a = str.substring(str.length() - 4, str.length());
        System.out.println(a);
        char c = 'e';
        String b = a + "";
        b.charAt(0);
        Arrays.stream(arr).average().orElse(0);
        System.out.println(b);
    }
}
