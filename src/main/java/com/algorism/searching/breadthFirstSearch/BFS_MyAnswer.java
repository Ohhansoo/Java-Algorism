package com.algorism.searching.breadthFirstSearch;


import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class BFS_MyAnswer {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public void DFSAndBFSProgram_MyAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cntNode = Integer.parseInt(st.nextToken());
        int cntEdge = Integer.parseInt(st.nextToken());

        //인접리스트 생성
        ArrayList<Integer> arrNum = new ArrayList<Integer>(cntNode);

        //방문 배열 생성
        ArrayList<String> arrVisit = new ArrayList<String>(cntNode);

        for (int i = 0; i < arrNum.size(); i++) {
            arrVisit.add(i, "F");
        }
    }

    /*
     * [TIP] 노드의 최대 개수가 1,000 이므로 시간 복잡도 N2 이하의 알고리즘 사용 가능
     * */
    public void DFSAndBFSProgram() throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();        // 노드 개수
        int M = scan.nextInt();        // 에지 개수
        int Strat = scan.nextInt();        // 시작점
        A = new ArrayList[N + 1];          // 그래프 데이터 저장 인접 리스트

        // A 인접 리스트의 각 ArrayList 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // A 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        //번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        // 방문 배열 초기화하기
        visited = new boolean[N + 1];
        DFS(Strat);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(Strat);
        System.out.println();
    }

    public static void DFS(int Node) {
        // 현재 노드 출력
        System.out.println(Node + " ");
        // 방문 기록
        visited[Node] = true;
        // 재귀함수 형태로 방문하지 않는 노드로 DFS  실행
        for (int i : A[Node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int Node) {
        // QUEUE 자료 구조에 시작 노드 삽입
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        // 현재 노드 방문 기록
        visited[Node] = true;

        while (!queue.isEmpty()) {
            // QUEUE에서 노드 데이터 가져오기
            int now_Node = queue.poll();
            // 가져온 노드 출력
            System.out.println(now_Node + " ");
            // 현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록
            for (int i : A[now_Node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // dx, dy(상하좌우를 탐색하기 위한 define값 정의 변수)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    // visited 방문 기록 저장 배열
    static boolean[][] visited2;
    // A 데이터 저장, 2차원 행렬
    static int[][] A2;
    static int N, M;

    /*
     * [TIP] N, M의 최대 데이터의 크기가 100으로 매우 작기 때문에 시가 제한은 별도로 생각하지 않아도 된다.
     * 최솟값을 찾는문제이므로 완전 탐색을 진행하여 몇 번째 깊이에서 원하는 값을 찾을 수 있는지 구하는 것과 동일하다.
     * */
    public void exploreMaze() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N(row), M(column)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // A 배열 초기화하기
        A2 = new int[N][M];
        // visited 배열 초기화하기
        visited2 = new boolean[N][M];

        // 이중 반복문으로 A배열에 데이터 저장하기(N과 M)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A2[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        // BFS(0,0) 실행하기
        BFS2(0, 0);
        System.out.println(A2[N - 1][M - 1]);
    }
    public static void BFS2(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        // 1. 큐 자로구조에 시작 노드 삽입
        queue.offer(new int[] {i, j});
        // 3. visited 배열에 현재 노드 방문 기록
        visited2[i][j] = true;
        // 3. while문으로 큐가 비어있을 때까지 돈다.
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            // 3-1. 반복문으로 상하좌우 탐색하며 유효한 좌표면서 이동 가능하고, 방문하지 않았는지 체크
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //3-2. 3-1 조건이 맞다면 visited 배열에 방문 기록하고 depth를 + 1 하여 업데이트하고 큐에 삽입
                // 좌표 유효성 검사
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // 갈 수 있는 칸 && 방문 검사하기
                    if (A2[x][y] != 0 && !visited2[x][y]) {
                        visited2[x][y] = true;
                        // 깊이 업데이트하기
                        A2[x][y] = A2[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }

    static boolean visited3[];
    static int[] distance;
    static ArrayList<Edge>[] A3;

    static class Edge {
        int e; // 목적지 노드
        int value; // 에지의 가중치
        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
    /*
     * [TIP] 가장 긴 경로를 찾는 문제
     *       임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나다.
     *       (노드, 가중치)를 표현하기 위해 노드는 클래스로 선언
     * */
    public static void findTreeDiameter() throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();               // 노드 개수
        A3 = new ArrayList[N + 1];          // 그래프 데이터 저장 인접 리스트
        for (int i = 1; i <= N; i++) {
            A3[i] = new ArrayList< Edge>(); // A 인접 리스트의 각 ArrayList 초기화
        }

        // A 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) break;
                int V = sc.nextInt();
                A3[S].add(new Edge(E, V));
            }
        }

        distance = new int[N + 1];            // 배열 초기화 하기
        visited3 = new boolean[N + 1];        // 배열 초기화 하기
        BFS3(1);                        // 임의의 점을 시작점으로 실행하기
        int Max = 1;
        // distance 배열에서 가장 큰 값으로 다시 시작점 설정
        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i])
                Max = i;
        }
        // 새로운 시작점으로 다시 실행
        distance = new int[N + 1];
        visited3 = new boolean[N + 1];
        BFS3(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS3(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited3[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge i : A3[now_node]) {
                int e = i.e;
                int v = i.value;
                if (!visited3[e]) {
                    visited3[e] = true;
                    queue.add(e);
                    // 거리 배열 업데이트
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }
}
