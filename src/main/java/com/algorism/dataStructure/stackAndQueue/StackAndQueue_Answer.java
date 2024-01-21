package com.algorism.dataStructure.stackAndQueue;

import java.io.*;
import java.util.*;

public class StackAndQueue_Answer {

     public void ascendingSequence(){
         Scanner sc = new Scanner(System.in);
         int cntNum = sc.nextInt();
         int[] A = new int[cntNum];

         for(int i = 0; i < cntNum; i++){
            A[i] = sc.nextInt();
         }

         Stack<Integer> stack = new Stack<>();

         StringBuffer bf = new StringBuffer();
         //오름차순 수
         int num = 1;
         boolean result = true;

         for(int i = 0; i < A.length; i++) {
             //현재 수열의 수
             int su = A[i];

             //현재 수열 값 >= 오름차순 자연수이면, 자연수의 값이 같아질 때 push() 수행
             if (su >= num) {
                 while (su >= num) {
                     stack.push(num++);
                     bf.append("+\n");
                 }
                 stack.pop();
                 bf.append("-\n");
             }
             //현재 수열 값 < 오름차순 자연수이면, pop()을 수행해 수열 원소를 꺼냄
             else {
                 int n = stack.pop();

                 //스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                 if (n > su) {
                     System.out.println("NO");
                     result = false;
                     break;
                 } else {
                     bf.append("-\n");
                 }
             }
         }
         if (result) System.out.println(bf.toString());
     }


    //[Tip] N의 최대 크기가 1,000,000이므로 반복문으로 오큰수를 찾으면 제한시간(1초)를 초과한다.
    //다음과 같은 아이디어로 풀이해본다.
    // 1. 스택에 새로 들어오는 수가 top에 존재하는 수보다 크면 그 수는 오큰수가 된다.
    // 2. 오큰수를 구한 후 수열에서 오큰수가 존재하지 않는 숫자에 -1을 출력해야 한다.
    public void rightBigNum() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        //수열 배열 생성
        int[]A = new int[n];
        //정답 배열 생성
        int[]ans = new int[n];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < n; i++){
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> myStack = new Stack<>();
        // 처음에는 항상 스택이 비어있으므로 최초 값을 push해 초기화
        myStack.push(0);
        for(int i = 1; i < n; i++){
            //스택이 비어있지않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]){
                //정답배열에 오큰수를 현재 수열로 저장하기
                ans[myStack.pop()] = A[i];
            }
            //신규 데이터 push
            myStack.push(i);
        }
        //반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때까지
        while (!myStack.isEmpty()){
            //스택에 쌓인 index에 -1을 넣는다.
            ans[myStack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            //출력한다
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    //[Tip] N의 최대 크기가 500,000이므로 시간 복잡도의 제약이 크기 않다.
    //queue의 선입선출을 이용하면 쉽게 구현 가능하다.
    public void cardGame(){
         Scanner sc = new Scanner(System.in);
         Queue<Integer> myQueue = new LinkedList<>();

         //카드 개수
         int N = sc.nextInt();
         //카드를 큐에 저장
         for (int i = 1; i <= N; i++){
             myQueue.add(i);
         }
         while (myQueue.size() > 1){
             myQueue.poll();
             myQueue.add(myQueue.poll());
         }
        System.out.println(myQueue.peek());
    }

    //[Tip] N의 최대 크기가 100,000이므로 O(nlon)으로 가능
    //데이터가 새로 삽입될 때 마다 절댓값과 관련된 정렬이 필요하므로 우선순위 큐로 문제 해결 가능
    //하지만 절댓값 정렬이 필요하기 때문에 정렬 기준은 직접 정의해야 한다.
    public void absoluteValHeap() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //개수
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
           int first_abs = Math.abs(o1);
           int second_abs = Math.abs(o2);
           
           //절대값이 같으면 음수 우선 정렬하기
           if (first_abs == second_abs)
               return o1 > o2 ? 1 : -1;
           // 절대값 기준으로 정렬하기
           else
               return first_abs - second_abs;
        });

        for (int i = 0; i < N; i++){
            int request = Integer.parseInt(br.readLine());
            if (request == 0){
                if (MyQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(MyQueue.poll());
            }
            else {
                MyQueue.add(request);
            }
        }

    }

}
