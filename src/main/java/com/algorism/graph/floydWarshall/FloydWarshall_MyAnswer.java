package com.algorism.graph.floydWarshall;

import org.springframework.util.comparator.Comparators;

import java.io.*;
import java.util.*;

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

    //최단 거리를 구하는 문제가 아니기 때문에 기존 플로이드-워셜 알고리즘에서 최단 거리를 업데이트하는 부분만 조금 수정 필요
    public void findFRoute () throws IOException {
        N = Integer.parseInt(br.readLine());
        distance = new int[N][N];
        //입력되는 인접 행렬의 값을 그대로 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                distance[i][j] = v;
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    // k를 거치는 모든 경로 중 1개라도 연결돼 있는 경로가 있다면 i와 j는 연결 노드로 취급
                    if (distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    * BFS 탐색 알고리즘을 이용해도 찾을 수 있는 문제.
    * 하지만 유저의 최대 수가 100 정도로 작기 때문에 플로이드-워셜 알고리즘으로도 해결 가능
    * 이 문제에선 1번째로 사람들이 직접적인 친구 관계를 맺은 상태를 비용 1로 계산. -> 즉 가중치를 1로 정한 후 인접 행렬에 저장
    * 또한 플로이드-워셜은 모든 쌍과 관련된 최단 경로이므로 한 row의 배열값은 이 row의 index값에서 다른 모든 노드와 관련된 최단 경로
    * 즉 i번째 row의 합이 i번째 사람의 케빈 베이컨의 수가 된다는 의미이다.
    * */
    public void SixDegreesOfKevinBacon () throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];
        //인접 행렬 초기화하기
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = 10000001; //충분히 큰 수로 저장
                }
            }
        }
        // 친구 관게이므로 양방향 저장을 하며 1로 가중치 통일
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }
        // 플로이드-워셜 알고리즘 수행하기
        for (int k = 1; k < N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        int Min = Integer.MAX_VALUE;
        int Answer = -1;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                temp = temp + distance[i][j];
            }
            //가장 작은 케빈 베이컨의 수를 지니고 있는 i를 찾기
            if (Min > temp) {
                Min = temp;
                Answer = i;
            }
        }
        System.out.println(Answer);
    }
}
