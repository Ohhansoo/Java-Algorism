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
}
