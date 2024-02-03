package com.algorism.searching.depthFirstSearch;

import java.io.*;
import java.util.ArrayList;
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
        for (int i = 1; i < n; i++) {
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

    public void findAmazingPrimeNumber_MyAnswer(){

    }
    // 재귀 함수에 자릿수 개념을 붙여 구현.
    public void findAmazingPrimeNumber(){

    }
}
