package com.algorism.numberTheory.euclidean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Euclidean_MyAnswer {

    // 최소 공배수는  'A * B / 최대 공약수'를 계산해 구할 수 있다.
    public void leastCommonMultiple() throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a,b);
            System.out.println(result);
        }
    }

    public static int gcd(int a, int b){
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    /* 들어오는 값의 단위가 크므로 일반적인 방법으론 최소 공배수를 찾을 수 없다
       다음과 같은 규칙을 생각해 적용해보자.
       1. 수의 길이를 나타내는 두 수의 최대 공약수는 A와 B의 최대 공약수의 길이를 나타낸다.
       2. 즉, 3.6의 최대 공약수 3은 A(111)와 B(111111)의 최대 공약수(111)의 길이로 나타난다.
     */
    public void greatestCommonDivisor() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = gcd(a, b);
        while (result > 0){
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    /*
    * 문제에서는 N - 1 개의 비율로 N개의 재료와 관련된 전체 비율을 알아낼 수 있다고 했습니다.
    * 이것을 그래프 관점으로 생각함현 사이클이 없는 트리구조로 이해할 수 있습니다.
    * 이 내용을 바탕으로 임의의 노드에서 DFS를 진행하면서 정답을 찾으면 됩니다.
    * DFS 과정에서 유클리드 호제법을 사용해 비율들의 최소 공배수와 최대 공약수를 구하고, 재료의 최소 질량을 구하는데 사용
    * */
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];

    public void makeCocktail() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        for (int i = 0; i < N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b, p ,q));
            A[b].add(new cNode(a, p ,q));
            //최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(D[i] / mgcd + " ");
        }
    }
    //최대 공약수 함수 구현은 위에꺼 사용

    public static void DFS(int Node) {
        visited[Node] = true;
        for (cNode i : A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                // 주어진 비율로 다음 노드값 갱신하기
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}
class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = q;
        this.q = q;
    }
    public int getB(){
        return b;
    }
    public int getP(){
        return p;
    }
    public int getQ(){
        return q;
    }
}
