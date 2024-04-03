package com.algorism.graph.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MST_MyAnswer {

    static int[] parent;
    static PriorityQueue<pEdge> queue;

    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void findMST () throws IOException {
        int N = sc.nextInt(); //노드 수
        int M = sc.nextInt(); //에지 수
        queue = new PriorityQueue<>(); //자동 정렬을 위해 우선순위 큐 자로구조 선택하기
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }
        int useEdge = 0;
        int result = 0;
        while (useEdge < N - 1) {
            pEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    // union 연산 : 대표 노드끼리 연결하기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
            // 재귀 함수의 형태로 구현 -> 경로 압축 부분
        else return parent[a] = find(parent[a]);
    }

    //************* 2번째 문제 *************/
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N,M, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;

    // 1. 주어진 지도에서 섬으로 표현된 값을 각각의 섬마다 다르게 표현해야한다.
    // 2. 각 섬의 모든 위치에서 다른 섬으로 연결할 수 있는 에지가 있는지 확인해 에지 리스트를 만든다.
    // 3. 최소 신장 트리 적용
    public void makeBridge () throws IOException {
        //1. 지도의 정보를 2차원 배열에 저장하고 섬으로 표시된 모든 점에서 BFS를 실행해 섬을 구분
        //2. 모든 섬에서 상하좌우로 다리를 지어 다른 섬으로 연결할 수 있는지 확인
        //3. 수집한 모든 에지를 오름차순 정렬해 최소 신장 트리 수행
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 맵 정보 저장하기
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        //각 자리에서 BFS 탐색으로 섬들을 분리하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        queue = new PriorityQueue<>();
    }

    private static void BFS(int i ,int j) {
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            //네 방향 검색하기
            for (int d = 0; d < 4; d++) {
                int tempR = dr[d];
                int tempC = dc[d];
                while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                    //현재 방문한 적이 없고 바다가 아니면 같은 섬으로 취급하기
                    if (visited[r + tempR][c + tempC] == false && map[r + tempR][c + tempC] != 0) {
                        addNode(r + tempR, c + tempC, queue);
                    }
                    else break;
                    if (tempR < 0) tempR--;
                    else if (tempR > 0) tempR++;
                    else if (tempC < 0) tempC--;
                    else if (tempC > 0) tempC++;
                }
            }
        }
    }
    //특정 위치를 섬의 정보로 넣어 주는 함수
    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i, j};
        mlist.add(temp);
        queue.add(temp);
    }

    //************* 3번째 문제 *************88

    static int sum;

    // 인접 행렬의 형태로 데이터가 들어오기 때문에 이 부분을 최소 신장 트리가 가능한 형태로 변형하는게 핵심
    // 1. 문자열로 주어진 랜선의 길이를 숫자로 변형해 랜선의 총합 저장
    // 2. 이 때 i와 j가 같은 곳의 값은 같은 컴퓨터를 연결한다는 의미이므로 별도로 저장하지 않는다.
    // 3. 나머지 위치의 값들을 i -> j로 가는 에지로 생성하고, 에지리스트에 저장한다
    public void helpUnfortunateNeighbors() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                int temp = 0;
                if (tempc[j] >= 'a' && tempc[j] <= 'z') {
                    temp = tempc[j] - 'a' + 1;
                }
                else if (tempc[j] >= 'A' && tempc[j] <= 'Z') {
                    temp = tempc[j] - 'A' + 27;
                }
                // 총 랜선의 길이 저장하기
                sum = sum + temp;
                if (i != j && temp != 0) queue.add(new pEdge (i, j, temp));
            }
        }

        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        //최소 신장 트리 알고리즘 수행하기
        while (!queue.isEmpty()) {
            pEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        if (useEdge == N - 1) System.out.println(sum - result);
        else System.out.println(-1);
    }
}

class pEdge implements Comparable<pEdge> {
    int s;
    int e;
    int v;
    pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(pEdge o) {
        //가중치를 기준으로 오름차순 정렬하기 위해 compareTo 재정의하기
        return this.v - o.v;
    }
}

class lEdge implements Comparable<lEdge> {
    int s;
    int e;
    int v;
    lEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge o) {
        //가중치를 기준으로 오름차순 정렬하기 위해 compareTo 재정의하기
        return this.v - o.v;
    }
}