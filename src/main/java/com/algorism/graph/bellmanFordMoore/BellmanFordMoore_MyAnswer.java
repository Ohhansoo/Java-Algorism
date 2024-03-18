package com.algorism.graph.bellmanFordMoore;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BellmanFordMoore_MyAnswer {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static long distance[];
    static Edge edges[];

    public void goFast() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
        }

        //벨만-포드 알고리즘
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //더 작은 최단 거리가 있을 때 업데이트하기
                if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;

        //음수 사이클 확인
        for(int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }

        if(!mCycle) {
            for (int i =2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(distance[i]);
            }
        }
        //음의 사이클 있을 떄
        else {
            System.out.println("-1");
        }
    }

    public void considerOfSalesMan() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

    }
}

class Edge {
    int start, end, time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
