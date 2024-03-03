package com.algorism.graph.implementation;

import java.awt.image.VolatileImage;
import java.io.*;
import java.util.*;

public class implementation_MyAnswer {

    static int visited[];
    static ArrayList<Integer>[] A;
    static int N,M,K,X;
    static List<Integer> answer;

    public void findCity4SpecificDistance() throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 노드의 수
        M = scan.nextInt(); // 에지의 수
        K = scan.nextInt(); // 에지의 수
        X = scan.nextInt(); // 에지의 수

        A = new ArrayList[N + 1];
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        //인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
        }
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for(int i = 0; i <= N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for(int temp:answer) {
                System.out.println(temp);
            }
        }
    }

    static int answer2[];
    static boolean visited2[];

    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : A[now_Node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now_Node] + 1;
                    queue.add(i);
                }
            }
        }
    }

    private static void BFS2(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : A[now_Node]) {
                if (visited2[i] == false) {
                    visited2[i] = true;
                    //신규 노드 인덱스의 정답 배열 값을 증가시킴
                    answer2[i]++;
                    queue.add(i);
                }
            }
        }
    }

    public void hackingEfficiently() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //노드
        N = Integer.parseInt(st.nextToken());
        //에지
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer2 = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        // 모든 노드로 BFS 실행하기
        for (int i =1; i <= N; i++) {
            visited2 = new boolean[N + 1];
            BFS(i);
        }
        int maxVal = 0;
        for (int i = 1; i <= N; i ++) {
            maxVal = Math.max(maxVal, answer2[i]);
        }
        for (int i = 1; i <= N; i++) {
            // answer 배열에서 maxVal 같은 값을 지닌 index가 정답
            if (answer2[i] == maxVal) System.out.println(i + " ");
        }
    }

    static ArrayList<Integer>[] A3;
    static int[] check3;
    static boolean visited3[];
    static boolean IsEven;

    /*
    * DFS로 실행하는 이유는 그래프의 모든 노드가 이어져 있지 않고, 여러 개의 부분 그래프로 이뤄진 케이스가 존재할 수 있기 때문
    * */
    public void identifyBipartiteGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스 개수
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++){
            String[] s = br.readLine().split(" ");
            //노드
            int V = Integer.parseInt(s[0]);
            //에지
            int E = Integer.parseInt(s[1]);
            A3 = new ArrayList[V + 1];
            visited3 = new boolean[V + 1];
            check3 = new int[V + 1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 인접 리스트로 그래프 저장하기
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int Start = Integer.parseInt(s[0]);
                int End = Integer.parseInt(s[1]);
                A[Start].add(End);
                A[End].add(Start);
            }
            // 주어진 그래프가 1개로 연걸돼 있다는 보장이 없으므로 모든 노드에서 수행하기
            for (int i = 1; i <= V; i++) {
                if (IsEven) DFS(i);
                else break;
            }
            check3[1] = 0;
            if (IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void DFS (int node) {
        visited3[node] = true;
        for (int i : A[node]) {
            if (!visited3[i]) {
                //인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                check3[i] = (check3[node] + 1) % 2;
                DFS(i);
            }
            //이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
            else if (check3[node] == check3[i]) {
                IsEven = false;
            }
        }
    }

    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0 ,2, 0, 1};
    static boolean visited4[][]; //A,B의 무게가 있으면 C의 무게가 고정되므로 2개만 체크
    static boolean answer4[];
    static int now[];

    /*
    * 그래프를 저장하고 저장한 자료구조를 이용하는 방식과 달리, 그래프 원리를 적용해 그래프를 역으로 그리는 방식으로 접근하는 문제
    * A,B,C의 특정 무게 상태를 1개의 노드로 가정한다.
    * 조건에 따라 이 상태에서 변경할 수 있는 이후 무게 상태가 에지로 인접한 노드라고 생각한다.
     * */
    public void findTheAmountOfWater() throws IOException {
        Scanner scan = new Scanner(System.in);
        now = new int[3];
        //A, B, C 물의양을 저장하는 배열
        now[0] = scan.nextInt();
        now[1] = scan.nextInt();
        now[2] = scan.nextInt();
        visited4 = new boolean[201][201];
        answer4 = new boolean[201];

        BFS4();

        for(int i = 0; i < answer4.length; i++) {
            if (answer4[i]) System.out.println(i + " ");
        }
    }
    
    public static void BFS4() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited4[0][0] = true;
        answer4[now[2]] = true;
        
        while(!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            //C는 전체 물의 양에서 a와 b를 뺀 것
            int C = now[2] - A - B;
            
            // A -> B, A -> C, B -> A, B -> C, C -> A, C ->B
            for (int k = 0; k < 6; k++) {
                int [] next = {A, B, C};
                next[Receiver[K]] += next[Sender[k]];
                next[Sender[k]] = 0;
                
                //물이 넘칠 때
                if (next[Receiver[k]] > now[Receiver[k]]) {
                    //초과하는 만큼 다시 이전 물통에 넣어줌
                    next[Sender[k]] = next[Receiver[K]] - now[Receiver[K]];
                    //대상 물통은 최대로 채워줌
                    next[Receiver[K]] = now[Receiver[K]];
                }
                // A와 B의 물의 양을 이용해 방문 배열 체크
                if (!visited4[next[0]][next[1]]) {
                    visited4[next[0]][next[1]] = true;
                    queue.add(new AB(now[0], now[1]));
                    // A의 물의 양이 0일 때, C의 물의 무게를 정답 변수에 저장
                    if (next[0] == 0) {
                        answer4[next[2]] = true;
                    }
                }
            }
        }
    }
}

// AB클래스 선언
// A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
class AB {
    int A;
    int B;
    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
