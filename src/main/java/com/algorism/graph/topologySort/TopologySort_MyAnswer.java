package com.algorism.graph.topologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySort_MyAnswer {

    public void lineUp() throws IOException {
        Scanner sc = new Scanner(System.in);
        //노드
        int N = sc.nextInt();
        //에지
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        //진입 차수 배열
        int[] indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;
        }
        //위상 정렬 수행하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for (int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }

    public void developGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        //진입 차수 배열
        int[] indegree = new int[N + 1];
        //자기 자신을 짓는 데 걸리는 시간
        int[] selfBuild = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //건물을 짓는 데 걸리는 시간
            selfBuild[i] = Integer.parseInt(st.nextToken());
            //인접 리스트 초기화하기
            while (true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1) break;
                A.get(preTemp).add(i);
                //진입 차수 배열 초기화하기
                indegree[i]++;
            }
        }
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[N+1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A.get(now)) {
                indegree[next]--;
                //시간 업데이트하기
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }

    public void findCriticalPath() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> A = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }
        //진입 차수 배열
        int[] indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            A.get(S).add(new dNode (E, V));
            //역방향 에지 정보 저장하기
            reverseA.get(E).add(new dNode(S, V));
            //진입 차수 배열 초기화하기
            indegree[E]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startDosi);
        int[] result = new int[N+1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : A.get(now)) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        //위상 정렬 reverse
        int resultCount = 0;
        boolean visited[] = new boolean[N+1];
        queue = new LinkedList<>();
        queue.offer(endDosi);
        visited[endDosi] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : reverseA.get(now)) {
                //1분도 쉬지 않는 도로 체크하기
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    // 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외하기
                    if (visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endDosi]);
        System.out.println(resultCount);;
    }
}

class dNode {
    int targetNode;
    int value;
    dNode (int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}
