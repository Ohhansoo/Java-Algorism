package com.algorism.dataStructure.twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer_MyAnswer {

    //[Tip] N의 최대값이 10,000,000으로 매우 크게 잡혀있다.
    //이러한 상황에서는 O(nlogn)의 시간 복잡도 알고리즘을 사용하면 제한 시간을 초과하므로 O(n)의 시간 복잡도 알고리즘을 사용해야한다.
    public void consecutiveNaturalNum(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int stratIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != N){
            // count 증가, endIndex 증가, sum값 변경
            if(sum == N){
                count++;
                endIndex++;
                sum = sum + endIndex;
            }
            // sum값 변경, startIndex 증가
            else if (sum > N){
                sum = sum - stratIndex;
                stratIndex++;
            }
            // endIndex 증가, sum값 변경
            else {
                endIndex++;
                sum = sum + endIndex;
            }
        }
        System.out.println(count);
    }

    //[Tip] 투 포인터 이동 원칙
    // A[i] + A[j] > M: j--   -> 번호의 합이 M보다 크므로 큰 번호 index를 내립니다.
    // A[i] + A[j] < M: i++   -> 번호의 합이 M보다 작으므로 작은 번호 index를 올립니다.
    // A[i] + A[j] == M: i++, j--, count++ -> 양쪽 포인터를 모두 이동시키고 count를 증가시킵니다.
    public void jumongsOrder(){
        Scanner sc = new Scanner(System.in);
        int IngredientCnt = sc.nextInt();
        int requiredIngredients = sc.nextInt();

        int[] ingredients = new int[IngredientCnt];

        for(int i = 0; i < IngredientCnt; i++){
            ingredients[i] = sc.nextInt();
        }

        //정렬
        Arrays.sort(ingredients);
        int count = 0;
        int lowIndex = 0;
        int bigIndex = IngredientCnt - 1;

        while (lowIndex < bigIndex){
            int sum = ingredients[lowIndex] + ingredients[bigIndex];
            if(sum == requiredIngredients){
                count++;
                lowIndex++;
                bigIndex--;
            }
            else if(sum > requiredIngredients){
                bigIndex--;
            }
            else {
                lowIndex++;
            }
        }
        System.out.println(count);
    }

    //[Tip] N의 최대 개수가 2,000이라도 N제곱보다 작아야한다. 따라서 시간 복잡도는 최소 O(nlogn)이어야 한다.
    // A[i] + A[j] > M: j--   -> 번호의 합이 M보다 크므로 큰 번호 index를 내립니다.
    // A[i] + A[j] < M: i++   -> 번호의 합이 M보다 작으므로 작은 번호 index를 올립니다.
    // A[i] + A[j] == M: i++, j--, count++ -> 양쪽 포인터를 모두 이동시키고 count를 증가시킵니다.
    public void findGoodNumber() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int result = 0;

        Long[] arrNum = new Long[count];

        for(int i = 0; i < count; i++){
            arrNum[i] = sc.nextLong();
        }

        Arrays.sort(arrNum);

        for(int k = 0; k < count; k++){
            long find = arrNum[k];
            int lowIndex = 0;
            int bigIndex = count - 1;

            while(lowIndex < bigIndex){
                if(arrNum[lowIndex] + arrNum[bigIndex] == find){
                    if(lowIndex != k && bigIndex != k){
                        result++;
                        break;
                    }
                    //자기 자신 제외
                    else if(lowIndex == k){
                        lowIndex++;
                    }
                    //자기 자신 제외
                    else if(bigIndex == k){
                        bigIndex--;
                    }
                }
                else if(arrNum[lowIndex] + arrNum[bigIndex] < find){
                    lowIndex++;
                }
                else{
                    bigIndex--;
                }
            }
        }
        System.out.println(result);
    }
}
