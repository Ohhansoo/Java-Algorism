package com.algorism.dataStructure.slidingWindow;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SlidingWindow_MyAnswer {

    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static final Scanner scanner = new Scanner(System.in);

    //[Tip] P와 S의 길이가 1,000,000으로 매우 크게 잡혀있다.
    //이러한 상황에서는 O(nlogn)의 시간 복잡도 알고리즘을 사용하면 제한 시간을 초과하므로 O(n)의 시간 복잡도 알고리즘을 사용해야한다.
    public void DNAPassword() throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int DNALength = Integer.parseInt(st.nextToken());
        int partLength = Integer.parseInt(st.nextToken());
        int result = 0;

        char DNAChar[] = new char[DNALength];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        DNAChar = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) checkSecret++;
        }

        //초기 partLength 부분 문자열 처리 부분
        for(int i = 0; i < partLength; i++){
            Add(DNAChar[i]);
        }

        //유효한 비밀번호
        if(checkSecret == 4) {
            result++;
        }
        else {
            //슬라이딩 윈도우 처리 부분
            for(int i = partLength; i < DNALength; i++){
                int j = i - partLength;
                Add(DNAChar[i]);
                Remove(DNAChar[j]);
                //유효한 비밀번호
                if(checkSecret == 4) result++;
            }
        }
        System.out.println(result);
        bf.close();
    }

    //새로 들어온 문자를 처리하는 함수
    private static void Add(char c){
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    //제거되는 문자를 처리하는 함수
    private static void Remove(char c){
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret++;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret++;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret++;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret++;
                myArr[3]--;
                break;
        }
    }

    //[Tip] L과 N의 범위가 5,000,000으로 잡혀있다.
    //이러한 상황에서는 O(nlogn)의 시간 복잡도 알고리즘을 사용하면 제한 시간을 초과하므로 O(n)의 시간 복잡도 알고리즘을 사용해야한다.
    //따라서 nlogn 시간복잡도를 가진 정렬은 사용하지 못한다.
    //O(n) 시간 복잡도 해결을 위해 덱(deque)로 구현하여 정렬 효과를 봐보자.
    /**
     * 덱에서는 (인덱스,숫자) 형태의 노드를 클래스로 구현하여 저장한다.
     * 신규 삽입 시, addFirst(), addLast(), removeFirst(), removeLast()를 사용하여 정렬
     * 최소값은 덱에서 맨 앞에 있는 노드의 숫자
     * */
    public void findMin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력을 버퍼에 넣고 한 번에 출력하기 위해 BurreredWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N과 L 선언
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // Ai
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for (int i =0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

            while (!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            //범위에서 벗어난 값은 덱에서 제거
            if(mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
