package com.algorism.graph.dijkstra;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Dijkstra_MyAnswer {

    public static int V,E,K;
    public static int distance[];
    public static boolean visited[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    public void shortestPath() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // 가중치가 있는 인접 리스트 초기화하기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        //K를 시작점으로 설정하기
        q.add(new Edge(K, 0));
        distance[K] = 0;
        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            // 이미 방문한 적이 있는 노드는 다시 큐에 얺지 않음
            if (visited[c_v]) continue;
            visited[c_v] = true;

            for (int i = 0; i < list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                // 최소 거리로 업데이트 하기
                if (distance[next] > distance[c_v] + value) {
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        // 거리 배열 출력하기
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }

    //인접 리스트로 그래프 표현하기
    static int N, M;
    // 최단거리 배열
    static ArrayList<Node>[] list2;
    static int[] dist;
    // 사용 노드인지 확인하는 배열
    static boolean[] visit;

    public void findMinimumCost() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list2 = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        //거리 배열을 충분히 큰 수로 초기화하기
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            list2[i] = new ArrayList<Node>();
        }
        //주어진 그래프의 에지를 인접 리스트 자료구조에 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list2[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if (!visit[now]) {
                visit[now] = true;
                for (Node n : list2[now]) {
                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value) {
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }

    static final int INF = 100000000;

    //K번째 최단경로 해결방법
    //1. 최단 경로를 표현하는 배열을 우선순위 큐 배열(크기는 K)로 변경하고자 한다.
    //   이렇게 하면 최단 경로뿐 아니라 최단 경로 ~K번째 최단 경로까지 표현할 수 있지 않을까?
    //2. 사용한 노드는 방문 배열에 확인해 두고 재사용하지 않는 부분은 삭제가 필요해 보인다.
    //   K번째 경로를 찾기 위해서는 노드를 여러 번 쓰는 경우가 생기기 때문이다.
    public static void KthShortestPath () throws IOException {
        int N, M, K;
        int[][] W = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        //오름차순 정렬 기준 설정
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i < N + 1; i++) {
            distQueue[i] = new PriorityQueue<Integer>(K, cp);
        }
        // 인접 행렬에 그래프 데이터 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.add(new Node2(1,0));
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            Node2 u = pq.poll();
            for (int adjNode = 1; adjNode <= N; adjNode++) {
                //연결된 모든 노드로 검색하기(시간 복잡도 측면에서 인접 행렬이 불리한 이유)
                if(W[u.node][adjNode] != 0) {
                    // 저장된 경로가 K개가 안 될 떄는 그냥 추가하기
                    if (distQueue[adjNode].size() < K) {
                        distQueue[adjNode].add(u.cost);
                    }
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex, value;
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
    public int compareTo(Edge e) {
        if (this.value > e.value) return 1;
        else return -1;
    }
}


class Node implements Comparable<Node> {
    int targetNode;
    int value;

    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }

}
class Node2 implements Comparable<Node> {
    int node;
    int cost;

    Node2(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        //Node2로 받아야하는데 방법이 없을까..
        // return this.cost < o.cost ? -1 : 1;
        return 1;
    }
}