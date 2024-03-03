package com.algorism.graph.unionFind;

import com.algorism.graph.implementation.implementation_MyAnswer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnionFind_MyAnswer {

    public static int[] parent;

    public void representSet() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];

        //대표 노드를 자기 자신으로 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (question == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // union 연산 : 대표 노드끼리 연결하기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if ( a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    // 두 원소가 같은 집합인지 확인하기
    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }

    //2번째
    public void planTrip () throws IOException {
        Scanner sc = new Scanner(System.in);
        // 도시 개수
        int N = sc.nextInt();
        // 여행 경로
        int M = sc.nextInt();
        int[][] dosi = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dosi[i][j] = sc.nextInt();
            }
        }
        int[] route = new int[M + 1];
        //여행 도시 정보 저장하기
        for (int i = 1; i <= M; i++) {
            route[i] = sc.nextInt();
        }
        parent = new int[N + 1];
        // 대표 노드를 자기 자신으로 초기화하기
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        // 인접 행렬에서 도시가 연결돼 있으면 union 실행하기
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N; j++) {
                if (dosi[i][j] == 1) union(i, j);
            }
        }

        // 여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인하기
        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }


    //3번째
    //3번째
    public static int[] trueP;
    public static ArrayList<Integer>[] party;
    public static int result;

    public void avoidLiar () throws IOException {
        Scanner sc = new Scanner(System.in);
        //사람 수
        int N = sc.nextInt();
        //파티 수
        int M = sc.nextInt();
        //진실을 아는 사람 수
        int T = sc.nextInt();
        result = 0;
        trueP = new int[T];

        //진실을 아는 사람 저장하기
        for (int i = 0; i < T; i++) {
            trueP[i] = sc.nextInt();
        }
        party = new ArrayList[M];

        // 파티 데이터 저장하기
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>();
            int party_size = sc.nextInt();
            for (int j = 0; j < party_size; j++) {
                party[i].add(sc.nextInt());
            }
        }
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            // 대표 노드를 자기 자신으로 초기화
            parent[i] = i;
        }
        //각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        //각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }
        System.out.println(result);
    }
}
