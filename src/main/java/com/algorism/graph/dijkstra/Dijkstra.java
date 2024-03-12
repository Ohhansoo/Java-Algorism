package com.algorism.graph.dijkstra;


import com.algorism.graph.topologySort.TopologySort_MyAnswer;

import java.io.IOException;

/**
 * 다익스트라 : 그래프에서 최단 거리를 구하는 알고리즘
 *            특정 노드에서 다른 노드들의 최단 거리 구하는 문제
 * [위상 정렬]
 *  기능 : 출발 노드와 모든 노드간의 최단 거리 탐색
 *  특징 : 에지는 모두 양수
 *  시간 복잡도(노드 수 : V, 에지 수 : E) : O(ElogV)
 *
 * [원리 이해]
 *  1. 인접 리스트로 그래프 구현
 *  2. 최단 거리 배열 초기화하기
 *  3. 값이 가장 작은 노드 고르기
 *  4. 최단 거리 배열 업데이트하기
 *      - Min(선택 노드의 최단 거리 배열의 값 + 에지 가중치, 연결 노드의 최단 거리 배열의 값)
 *  5. 과정 3~4를 반복해 최단 거리 배열 완성하기
 * */
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        Dijkstra_MyAnswer myAnswer = new Dijkstra_MyAnswer();

        //문제 1(08-4-056) : 최단 경로 구하기
        /************************************** 개 요 *************************************
         * 에지의 가중치가 10 이하의 자연수인 방향 그래프가 있다. 이 그래프의 시작점에서
         * 다른 모든 노드로의 최단 경로를 구하시오
         * */
        //입력 : 1번째 줄에 노드의 개수 V와 에지의 개수 E가 주어진다(1 <= V <= 20,000, 1 <= E <= 300,000)
        //      모든 노드에는 1부터 V까지 번호가 매겨져 있다.
        //      2번째 줄에 출발 노드의 번호 K가 주어진다(1 <= K <= V)
        //      3번째 줄에서 E개의 줄에 걸쳐 각 에지의 정보(u, v, w)가 순서대로 주어진다.
        //      이는 u에서 v로 가는 가중치 w인 에지가 존재한다는 뜻으로, u와 v는 서로 다르다.
        //      두 노드 사이에 에지가 2개 이상 존재할 수 있다는 것에 유의하자.
        //출력 : 1번째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 노드까지 최단 경로값을 출력한다.
        //      시작점은 0, 경로가 없을 때는 INF를 출력한다.
        //[예제 입력1] : 5 6 //노드 개수, 에지 개수
        //              1   // 출발 노드의 번호
        //              5 1 1 //각 에지의 정보(u v w) -> u에서 v로 가는 가중치 w
        //              1 2 2
        //              1 3 3
        //              2 3 4
        //              2 4 5
        //              3 4 6
        //[예제 출력1] : 0
        //              2
        //              3
        //              7
        //              INF
        System.out.println("문제 1(08-3-053) : 줄 세우기");
        //myAnswer.shortestPath();

        //문제 2(08-4-057) : 최소 비용 구하기
        /************************************** 개 요 *************************************
         * N개의 도시가 있다. 그리고 한 도시에서 출발해 다른 도시에 도착하는 M개의 버스가 있다.
         * A번째 도시에서 B번째 도시까지 가는 데 드는 버스 비용을 최소화하려고 한다. A번째 도시에서 B번째 도시까지 가는데
         * 드는 최소 비용을 출력하라. 도시의 번호는 1부터 N까지다.
         * */
        //입력 : 1번째 줄에 도시의 개수 N(1 <= N <= 1,000)
        //      2번째 줄에 버스의 개수 M(1 <= M <= 100,000)이 주어진다.
        //      3번째 줄에서 M + 2줄까지 다음과 같은 버스의 정보가 주어진다.
        //      가장 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그 다음에는 도착지의 도시 번호가 주어지고, 그 버스 비용이 주어진다.
        //      버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수다. 그리고 M + 3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시 번호와 도착점의 도시 번호가 주어진다.
        //      출발점에서 도착점을 갈 수 있을 때만 입력으로 주어진다.
        //출력 : 1번째 줄의 출발 도시에서 도착 도시까지 가는 데 드는 최소 비용을 출력한다.
        //[예제 입력1] : 5 // 도시 개수
        //              8 // 버스 개수
        //              1 2 2
        //              1 3 3
        //              1 4 1
        //              1 5 10
        //              2 4 2
        //              3 4 1
        //              3 5 1
        //              4 5 3
        //              1 5
        //[예제 출력1] : 4
        System.out.println("문제 2(08-4-057) : 최소 비용 구하기");
        myAnswer.findMinimumCost();

        //문제 3(08-4-058) : K번째 최단 경로 찾기
        /************************************** 개 요 *************************************
         * 너무 오래 걸리지도 너무 빠르지도 않는 적당한 길을 가는것을 좋아한다.
         * 적당한 타협안인 k번째 최단 경로를 구해보자
         * */
        //입력 : 1번째 줄에 n, m , k가 주어진다. (1 <= n <= 1000), (0 <= m <= 2,000,000), (1 <= k <= 100)
        //      n과 m은 각각 김조교가 여행을 고려하고 있는 도시들의 개수와 도시 간에 존재하는 도로의 수다.
        //      이어지는 m개의 줄에는 각각 도로의 정보를 제공하는 3개의 정수 a, b, c가 포함돼 있다.
        //      이것은 a번 도시에서 b번 도시로 갈때는 c의 시간이 걸린다는 의미다. (1 <= a,b <= n), (1 <= c <= 1,000)
        //      도시의 번호는 1번부터 n번까지 연속해 있고, 1번은 시작 도시다.
        //출력 : n개의 줄을 출력한다.
        //      i번째 줄에 1번 도시에서 i번 도시로 가는 K번째 최단 경로의 소요 시간을 출력한다.
        //      경로의 소요 시간은 경로 위에 있는 도로들을 따라 이동하는 데 필요한 시간들의 합이다.
        //      i번 도시에서 i번 도시로 가는 최단 경로는 0이지만, 일반적인 K번째 최단 경로는 0이 아닐 수 있다는 것에 유의한다.
        //      또 K번째 최단 경로가 존재하지 않으면 -1을 출력한다.
        //      최단 경로에 같은 노드가 여러 번 포함될 수 있다.
        //[예제 입력1] : 5 10 2 // 도시 수, 도로 수, k
        //              1 2 2
        //              1 3 7
        //              1 4 5
        //              1 5 6
        //              2 4 2
        //              2 3 4
        //              3 4 6
        //              3 5 8
        //              5 2 4
        //              5 4 1
        //[예제 출력1] : -1
        //              10
        //              7
        //              5
        //              14
        System.out.println("K번째 최단 경로 찾기");
        myAnswer.KthShortestPath();
    }
}
