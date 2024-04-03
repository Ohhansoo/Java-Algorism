package com.programmers.one;

import java.util.Arrays;

public class run {
    
    /*
    * 시간초과에 걸림
    * */
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        for (String callName : callings) {
            int callIndex = Arrays.asList(players).indexOf(callName);
            String strChangedName = players[callIndex - 1];

            players[callIndex - 1] = callName;
            players[callIndex] = strChangedName;
        }

        return players;
    }

    /*
    * 붕대감기 틀린문제
    * */
    public int solution2(int[] bandage, int health, int[][] attacks){
        int answer = 0;
        int current_health = health;
        int last_time = attacks[attacks.length-1][0];
        int attack_count = 0;
        int series_heal_count = 0;

        for (int i = 1; i < last_time + 1; i++) {
            //몬스터 공격 확인
            if (attacks[attack_count][0] == i) {
                series_heal_count = 0;
                current_health -= attacks[attack_count][1];
                attack_count++;
                if (current_health <= 0) return -1;
            }

            //체력 회복
            else {
                series_heal_count += 1;

                if (current_health < health) {
                    current_health += bandage[1];
                }

                if (series_heal_count >= bandage[0]) {
                    current_health += bandage[2];
                }

                if (current_health > health) {
                    current_health = health;
                }
            }
        }

        answer = current_health;

        return answer;
    }

    public void test(){
        String[] arrNum = {"1 3 5"};
        Arrays.stream(arrNum).mapToInt(x -> Integer.parseInt(x)).max();
    }
}
