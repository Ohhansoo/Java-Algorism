package com.algorism.graph.MinimumSpanningTree;

import com.algorism.graph.floydWarshall.FloydWarshall_MyAnswer;

import java.io.IOException;

/**
 * 최소 신장 트리(minimum spanning tree) : 그래프에서 모든 노드를 연결할 때 사용된 에지들의 가중치의 합을 최소로 하는 트리

 * [최소 신장 트리]
 *  특징 : 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않는다.
 *        N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1개이다.

 *
 * [원리 이해]
 *  1. 에지 리스트로 그래프를 구현하고 유니온 파인드 배열 초기화하기
 *  2. 그래프 데이터를 가중치 기준으로 정렬하기
 *  3. 가중치가 낮은 에지부터 연결 시도하기 -> 크루스칼 or 프림 알고리즘 수행
 *  4. 과정 3 반복하기 -> V(노드 개수) - 1 이 될떄까지 반복
 *  5. 총 에지 비용 출력하기

 * */
public class MST {

    public static void main(String[] args) throws IOException {

        MST_MyAnswer myAnswer = new MST_MyAnswer();

        //문제 1(08-7-064) : 최소 신장 트리 구하기
        //[예제 입력1] : 3 3 // 노드 개수, 에지 개수
        //             1 2 1
        //             2 3 2
        //             1 3 3
        //[예제 출력1] : 3
        System.out.println("문제 1(08-7-064) : 최소 신장 트리 구하기");
        myAnswer.findMST();

        //문제 2(08-7-065) : 다리 만들기
        //[예제 출력1] : 3
        //[예제 입력1] : 7 8 // 행렬 크기
        //             0 0 0 0 0 0 1 1
        //             1 1 0 0 0 0 1 1
        //             1 1 0 0 0 0 0 0
        //             1 1 0 0 0 1 1 0
        //             0 0 0 0 0 1 1 0
        //             0 0 0 0 0 0 0 0
        //             1 1 1 1 1 1 1 1
        System.out.println("문제 2(08-7-065) : 다리 만들기");
        myAnswer.makeBridge();

        //문제 3(08-7-066) : 불우이웃돕기
        //[예제 출력1] : 3
        //             abc
        //             def
        //             ghi
        //[예제 입력1] : 40
        System.out.println("문제 3(08-7-066) : 불우이웃돕기");
        myAnswer.helpUnfortunateNeighbors();
    }
}
