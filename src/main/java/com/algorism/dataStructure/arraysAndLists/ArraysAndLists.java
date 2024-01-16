package com.algorism.dataStructure;

import java.util.Arrays;

public class ArraysAndLists {

    //03-1 배열과 리스트
    public static void main(String[] args){
        /**
         * 배열 : 메모리의 연속 공간에 값이 채워져 있는 형태의 자료구조
         * 1. 인덱스를 사용하여 바로 접근할 수 있다.
         * 2. 새로운 값을 삽입하거나 특정 인덱스에 있는 값을 삭제하기 어렵다.
         * 3. 값을 삽입하거나 삭제하려면 해당 인덱스 주변에 있는 값을 이동시키는 과정이 필요하다.
         * 4. 구조가 간단하므로 코딩테스트에서 많이 사용한다.
         * */

        /**
         * 리스트 : 값과 포인터를 묶은 노드라는 것을 포인터로 연결한 자료구조
         * 1. 인덱스가 없으므로 값에 접근하려면 Head 포인터로부터 순서대로 접근해야 한다. 다시 말해 값에 접근하는 속도가 느리다.
         * 2. 포인터로 연결되어 있으므로 데이터를 삽입하거나 삭제하는 연산 속도가 빠르다.
         * 3. 선언할 때 크기를 별도로 지정하지 않아도 된다. 다시말해 리스트의 크기는 정해져 있지 않으며, 크기가 변하기 쉬운 데이터를 다룰 때 적절하다.
         * 4. 포인터를 저장할 공간이 필요하므로 배열보다 구조가 복잡하다.
         * */

        //문제 : 숫자의 합 구하기
        int answer = sum(25, 10987654321L);
        System.out.println(answer);
    }

    /**
     * 1번째 줄에 숫자의 개수 N (1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
     * */
    public static int sum(int count, Long num){
        int answer = 0;

        String[] numbers = (num + "").split("");

        for(int i=0; i <= numbers.length-1; i++){
            answer += Integer.parseInt(numbers[i]);
        }

        return answer;
    }

}
