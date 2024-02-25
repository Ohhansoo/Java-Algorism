package com.algorism.numberTheory.euclidean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
}
