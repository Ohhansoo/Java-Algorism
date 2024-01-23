package com.algorism.sort.bubble;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort_MyAnswer {

    //[Tip] N의 최대값이 1,000으로 웬만한 방법을 적용하여도 풀이가 가능하다.
    //O(n2)인 버블정력을 사용해도 시간복잡도 안에 문제를 해결할 수 있다.
    public void sortingNumbers01() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 개수를 변수에 담는다.
        int cntNum = Integer.parseInt(st.nextToken());

        //2. 수 정렬을 int[]에 담는다.
        int[] arrNum = new int[cntNum];

        for(int i = 0; i < cntNum; i++){
            st = new StringTokenizer(br.readLine());
            arrNum[i] =  Integer.parseInt(st.nextToken());
        }

        //3-1. 순서대로 i와 i+1을 비교해 i+1이 더 작으면 서로 위치를 바꾼다.
        //3-2. length까지 마치면 마지막 index를 제외하고 3-1을 돌린다.
        for(int i = 0; i < cntNum - 1; i++){
            for(int j = 0; j < cntNum - 1 - i; j++){
                if(arrNum[j] > arrNum[j+1]){
                    int swapNum = arrNum[j];
                    arrNum[j] = arrNum[j+1];
                    arrNum[j+1] = swapNum;
                }
            }
        }

        for(int i = 0; i < cntNum; i++){
            System.out.println(arrNum[i]);
        }
    }

    //[Tip] N의 최대값이 500,000으로 일반적인 버블정렬로는 풀지 못한다.
    //자바에서 기본적으로 제공하는 sort()는 시간복잡도가 O(nlon)으로 사용가능하다.
    //데이터 정렬 전 index와 정렬 후 index를 비교해 왼쪽으로 가장 많이 이동한 값을 찾으면 해결 가능하다.
    public void sortProgram01() throws IOException {

    }

}
