package com.algorism.searching.depthFirstSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DFS_MyAnswer {

    static ArrayList<Integer>[] A;
    static boolean visited[];

    /*
     * [TIP] 노드의 최대 개수가 1,000 이므로 시간 복잡도 N2 이하의 알고리즘 사용 가능
     * */
    public void countConnectedComponent_MyAnswer() throws IOException {
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

    public void countConnectedComponent() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n(노드 개수) m(에지 개수)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //A(그래프 데이터 저장 인접 리스트)
        A = new ArrayList[n+1];
        //visited(방문 기록 저장 배열)
        visited = new boolean[n+1];

        // A인접 리스트의 각 ArrayList 초기화하기
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        // A인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향 에지이므로 양쪽에 에지 더하기
            A[s].add(e);
            A[e].add(s);
        }

        // DFS 실행
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public void DFS(int v){
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }

    public void findAmazingPrimeNumber_MyAnswer() throws IOException {
        //N 가져오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leng = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrPrimeNumber = new ArrayList<Integer>();

        //N의 자리 소수 뽑기

        //반복문 - 1 ~ N까지 자른수가 소수인지 확인
        //        모두 맞다면 출력
    }

    static int N;

    // 재귀 함수에 자릿수 개념을 붙여 구현.
    public void findAmazingPrimeNumber(){
        Scanner in = new Scanner(System.in);
        //N 자릿수
        N = in.nextInt();
        //DFS2 실행하기 (숫자 2, 3, 5, 7로 탐색 시작)
        DFS2(2, 1);
        DFS2(3, 1);
        DFS2(5, 1);
        DFS2(7, 1);

    }
    //DFS2 함수 구현하기
    public void DFS2(int number, int jarisu) {
        // - 자릿수 == N이고 소수면 출력
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        // - 1 ~ 9 반복하고 뒤에 붙는 수가 홀수이면서 소수 일때 재귀 함수
        for (int i = 1; i < 10; i++) {
            //짝수면 탐색할 필요가 없다.
            if (i % 2 == 0) {
                continue;
            }
            //소수라면 재귀함수로 자릿수를 늘림
            if (isPrime(number * 10 + i)) {
                DFS2(number * 10 + i, jarisu + 1);
            }
        }
    }

    // 소수 구하기 함수 구현
    public boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void findFriend_MyAnswer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cntNode = Integer.parseInt(st.nextToken());
        int cntEdge = Integer.parseInt(st.nextToken());
        visited = new boolean[cntNode];
        boolean arrive_My = false;

        for (int i = 0; i < cntNode; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < cntEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());
            A[me].add(friend);
            A[friend].add(me);
        }

        for (int i = 0; i < cntNode; i++) {
            A[i] = new ArrayList<Integer>();
        }
    }

    public void DFS3_MyAnswer(){

    }

    static boolean arrive;
    /*
     * [TIP] N의 최대 범위가 2,000이므로 알고리즘의 시간 복잡도를 고려할 때 자유롭다.
     * 주어진 노드에 DFS를 수행하고 재귀의 깊이가 5 이상이면 1, 아니면 0 출력
     * 시간 복잡도는 O(V + E)이므로 최대 4,000 모든 노드를 진행했을 때 4,000 * 2,000.
     * */
    public void findFriend(){
        // arrive(도착 확인 변수)
        arrive = false;
        Scanner scan = new Scanner(System.in);
        // N (노드개수) M (에지 개수)
        int N = scan.nextInt();
        int M = scan.nextInt();
        // A (그래프 데이터 저장 인접 리스트)
        A = new ArrayList[N];
        // visited(방문 기록 저장 배열)
        visited = new boolean[N];

        // 반복문으로 A 인접 리스트의 각 ArrayList 초기화
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        // 반복문으로 A 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            DFS3(i, 1);
            if (arrive) break;
        }
        if (arrive) System.out.println("1");
        else System.out.println("0");
    }

    // 각 노드마다 DFS 실행하고 DEPTH가 5면 종료
    public void DFS3(int now, int depth){
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS3(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
