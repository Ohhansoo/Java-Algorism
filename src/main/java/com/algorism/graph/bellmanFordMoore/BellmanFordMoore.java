package com.algorism.graph.bellmanFordMoore;


import com.algorism.graph.dijkstra.Dijkstra_MyAnswer;

import java.io.IOException;

/**
 * 벨만-포드 알고리즘 : 그래프에서 최단 거리를 구하는 알고리즘
 *
 * [위상 정렬]
 *  기능 : 특정 출발 노드에서 다른 모든 노드까지의 최단 경로 탐색
 *  특징 : 1. 음수 가중치 에지가 있어도 수행할 수 있음
 *        2. 전체 그래프에서 음수 사이클의 존재 여부를 판단할 수 있음
 *  시간 복잡도(노드 수 : V, 에지 수 : E) : O(VE)
 *
 * [원리 이해]
 *  1. 에지 리스트로 그래프를 구현하고 최단 경로 배열 초기화하기
 *  2. 모든 에지를 확인해 정답 배열 업데이트하기
 *  3. 음수 사이클 유무 확인하기
 * */
public class BellmanFordMoore {

    public static void main(String[] args) throws IOException {
        BellmanFordMoore_MyAnswer myAnswer = new BellmanFordMoore_MyAnswer();

        //문제 1(08-5-059) : 타임머신으로 빨리 가기
        //[예제 입력1] : 3 4 // 노드, 에지
        //             1 2 4
        //             1 3 3
        //             2 3 -4
        //             3 1 -2
        //[예제 출력1] : -1
        System.out.println("문제 1(08-5-059) : 타임머신으로 빨리 가기");
        myAnswer.goFast();

        //문제 2(08-5-060) : 세일즈맨의 고민
        //[예제 입력1] : 5 0 4 5
        //             0 1 10
        //             1 2 10
        //             2 3 10
        //             3 1 10
        //             2 4 10
        //             0 10 10 110 10
        //[예제 출력1] : Gee
        System.out.println("문제 2(08-5-060) : 세일즈맨의 고민");
        myAnswer.considerOfSalesMan();
    }
}
