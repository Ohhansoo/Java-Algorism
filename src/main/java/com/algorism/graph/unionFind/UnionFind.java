package com.algorism.graph.unionFind;

import com.algorism.graph.implementation.implementation_MyAnswer;

import java.io.IOException;


/**
 *  유니온 파인드(union-find)는 일반적으로 여러 노드가 있을 때
 *      특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과
 *      두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성되어 있는 알고리즘
 *
 * [유니온 파인드의 핵심 이론 : union과 find]
 *  union 연산 : 각 노드가 속한 집합을 1개로 합치는 연산
 *              노드 a,b가 A와 B에 속할 때, A와 B의 합집합
 *  find 연산 : 특정 노드에 a에 관해 a가 속한 집합의 대표 노드를 반환하는 연산
 *              노드 a가 A에 속할 때, find(a)는 A집합의 대표 노드를 반환
 *
 *  [find 연산의 작동 원리]
 *      1. 대상 노드 배열에 index 값과 value 값이 동일한지 확인
 *      2. 동일하지 않으면 value값이 가리키는 index 위치로 이동
 *      3. 이동 위치의 index값과 value 값이 같을 때까지 1~2를 반복. 반복이므로 재귀 함수로 구현
 *      4. 대표 노드에 도달하면 재귀함수를 빠져나오며 거치는 모든 노드값을 루트 노드값으로 변경
 * */
public class UnionFind {
    public static void main(String[] args) throws IOException {
        UnionFind_MyAnswer myAnswer = new UnionFind_MyAnswer();

        //문제 1(08-2-050) : 집합 표현하기
        /************************************** 개 요 *************************************
         * 초기에 {0}, {1}, {2}, ... {n}이 각각 n+1개의 집합을 이루고 있다.
         * 여기에 합집합 연산ㄴ과 두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산을 수행하려 한다.
         * 집합을 표현하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 n(1< = n <= 1,000,000) m(1 < m <= 100,000)이 주어진다.
        //      m은 입력으로 주어지는 연산의 개수다.
        //      다음 m개의 줄에는 각각의 연산이 주어진다.
        //      합집합은 0 a b의 형태로 입력이 주어진다.
        //      이는 a가 포함돼 있는 집합과 b가 포함돼 있는 집합을 합친다는 의미다.
        //      두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산은 1 a b 형태로 입력이 주어진다.
        //      이는 a와 b가 같은 집합에 포함돼 있는지를 확인하는 연산이다.
        //      a와 b는 n이하의 자연수 또는 0이고, 같을 수도 있다.
        //출력 : 1로 시작하는 입력에 1줄에 1개씩 YES 또는 NO로 결과를 출력한다
        //[예제 입력1] : 7 8 //원소 개수, 질의 개수
        //              0 1 3
        //              1 1 7
        //              0 7 6
        //              1 7 1
        //              0 3 7
        //              0 4 2
        //              0 1 1
        //              1 1 1
        //[예제 출력1]    NO
        //               NO
        //[              YES
        System.out.println("문제 1(08-2-050) : 집합 표현하기");
        //myAnswer.representSet();

        //문제 2(08-2-051) : 여행 계획 짜기
        /************************************** 개 요 *************************************
         * 동혁이는 친구들과 함께 여행을 가려 한다. 한국는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도 없을 수도 있다.
         * 동혁이는 여행 계획이 주어졌을 때 이 계획대로 여행할 수 있는지를 알아보려 한다.
         * 물론 중간에 다른 도시를 경유해 여행할 수도 있다.
         * 예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고,
         * 동혁이의 여행 계획이 E,C,B,C,D라면 E-A-B-C-B-C-B-D 라는 여행 경로를 이용해 계획대로 여행할 수 있다.
         * 도시의 개수와 도시 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때
         * 계획대로 여행이 가능한지를 판별하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 도시의 수 N이 주어진다(N <= 200)
        //      2번째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다(M <= 1000)
        //      다음 N개의 줄에는 N개의 정수가 주어진다.
        //      i번째 줄에 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다.
        //      1이면 연결된 것이고, 0이면 연결되지 않은 것이다. A와 B가 연결됐으면 B와 A도 연결되어 있다.
        //      마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1에서 N까지 차례대로 매겨져 있다.
        //출력 : 1번째 줄에 가능하마녀 YES, 불가능하면 NO를 출력한다
        //[예제 입력1] : 3 // 도시 개수
        //              3 // 여행 경로 데이터
        //              0 1 0
        //              1 0 1
        //              0 1 0
        //              1 2 3
        //[예제 출력1]    YES
        System.out.println("문제 2(08-2-051) : 여행 계획 짜기");
        //myAnswer.planTrip();

        //문제 3(08-2-052) : 거짓말쟁이가 되긴 싫어
        /************************************** 개 요 *************************************
         * 지민이는 파티에 갈 때마다 자기가 가장 좋아하는 이야기를 한다. 한 번 씩 이야기를 과장하면서 이야기 한다.
         * 문제는 몇몇 사람들이 그 이야기의 진실을 안다는 것이다.
         * 사람의 수는 N이 주어지고, 이야기의 진실을 아는 사람이 주어진다.
         * 그리고 각 파티에 오는 사람들의 번호가 주어진다.
         * 지민이는 모든 파티에 참가해야 한다.
         * 이 때 지민이가 거짓말로 알려지지 않으면서 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.
         * */
        //입력 : 1번째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
        //      2번째 줄에 이야기의 진실을 아는 사람의 수와 번호가 주어진다.
        //      진실을 아는 사람의 수가 먼저 주어지고, 그 개수만큼 사람들의 번호가 주어진다.
        //      번호는 1부터 n까지의 수로 주어진다.
        //      3번째 줄에서 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
        //      N, M은 50 이하의 자연수, 진실을 아는 사람의 수와 각 파티마다 오는 사람의 수는 모두 0 이상 50 이하의 정수다.
        //[예제 입력1] : 4 3 // 사람 수, 파티 수
        //              0 // 진실을 아는 사람 정보
        //              2 1 2 // 파티 정보
        //              1 3
        //              3 2 3 4
        //[예제 출력1]    YES
        System.out.println("문제 2(08-2-051) : 여행 계획 짜기");
        myAnswer.avoidLiar();

    }

}
