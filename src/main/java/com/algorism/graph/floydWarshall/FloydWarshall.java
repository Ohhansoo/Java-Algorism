package com.algorism.graph.floydWarshall;

import com.algorism.graph.bellmanFordMoore.BellmanFordMoore_MyAnswer;

import java.io.IOException;

/**
 * 플로이드-워셜(floyd-warshall) : 최단거리를 구하는 알고리즘
 *                              A노드에서 B노드까지 최단 경로를 구했다고 가정했을 때
 *                             최단 경로 위에 K노드가 존재한다면 그것을 이루는 부분 경로 역시 최단 경로
 * - 플로이드-워셜 점화식 : 전체 경로의 최단 경로는 부분 경로의 최단 경로의 조합
 *      D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E])
 * [플로이드-워셜 ]
 *  기능 : 모든 노드 간에 최단 경로 탐색
 *  특징 : 음수 가중치 에지가 있어도 수행할 수 있음
 *        동적 계획법의 원리를 이용해 알고리즘에 접근
 *  시간 복잡도(노드 수 : V, 에지 수 : E) : O(V3)
 *
 * [원리 이해]
 *  1. 배열을 선언하고 초기화하기
 *  2. 최단 거리 배열에 그래프 데이터 저장하기
 *  3. 점화식으로 배열 업데이트하기
 *      - 플로이드-워셜 알고리즘 로직
 *          for 경유지 K에 관해 (1 ~ N) //N : 노드 개수
 *              for 출발 노드 S에 관해 (1 ~ N)
 *                  for 도착 노드 E에 관해 (1 ~ N)
 *                  D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E])
 * */
public class FloydWarshall {

    public static void main(String[] args) throws IOException {

        FloydWarshall_MyAnswer myAnswer = new FloydWarshall_MyAnswer();

        //문제 1(08-6-061) : 가장 빠른 버스 노선 구하기
        //[예제 입력1] : 5 // 도시 개수
        //             14 // 노선 개수
        //             1 2 2
        //             1 3 3
        //             1 4 1
        //             1 5 10
        //             2 4 2
        //             3 4 1
        //             3 5 1
        //             4 5 3
        //             3 5 10
        //             3 1 8
        //             1 4 2
        //             5 1 7
        //             3 4 2
        //             5 2 4
        //[예제 출력1] : 0 2 3 1 4
        //             12 0 15 2 5
        //             8 5 0 1 1
        //             10 7 13 0 3
        //             7 4 10 6 0
        System.out.println("문제 1(08-6-061) : 가장 빠른 버스 노선 구하기");
        //myAnswer.findFastestBusRoute();

        //문제 2(08-6-062) : 경로 찾기
        //[예제 입력1] : 3 // 인접 행렬의 크기
        //             0 1 0
        //             0 0 1
        //             1 0 0
        //[예제 출력1] : 1 1 1
        //              1 1 1
        //              1 1 1
        System.out.println("문제 2(08-6-062) : 경로 찾기");
        myAnswer.findFRoute();
    }
}
