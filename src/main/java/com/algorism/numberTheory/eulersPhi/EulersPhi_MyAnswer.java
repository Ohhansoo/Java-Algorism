package com.algorism.numberTheory.eulersPhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EulersPhi_MyAnswer {

    /*
     * N의 최대 범위가 1,000,000이므로 일반적인 소수 구하기 방식으로 풀면 시간 초과
     * 따라서 에라토스테네스 방식으로 풀어야 한다.
     * 솔직히 잘 모르겠다. 왜 소인수가 n % p == 0으로 확인되는지
     * */
    public void findPrimeNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        // 제곱근까지만 진행하기
        for (long p = 2; p <= Math.sqrt(n); p++) {
            // p가 소인수인지 확인하기
            if (n % p == 0) {
                //결과값 업데이트하기
                result = result - result / p;
            }
            // 2^7 * 11이라면 2^7을 없애고 11만 남김
            while (n % p == 0) {
                n /= p;
            }
        }
        // 아직 소인수 구성이 남아 있을 때
        if (n > 1) {
            // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
            result = result - result / n;
            System.out.println(result);
        }
    }
}
