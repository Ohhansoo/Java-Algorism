package com.programmers.pcce;

import java.util.*;
public class run {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};

        int[][] answer = s.solution(data, "date", 20300501, "remain");

        for(int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }
}

class Solution {

    public void putPQ(PriorityQueue pq1, int[] datas, String ext) {
        pq1.offer(new Data(datas[0], datas[1], datas[2], datas[3], ext));
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        //code, date(제조일), maximum(최대수량), 현재 수량(remain)
        //데이터만 뽑아 정렬
        // ext : 정보 기준, val_ext : 기준값, sort_by : 정렬
        //HashMap<String, Integer> hm = new Map<>();
        PriorityQueue pq1 = new PriorityQueue<>(1, new DataComparator());

        for (int i = 0; i < data.length; i++) {
            if (ext.equals("code")){
                if (data[i][0] < val_ext) {
                    putPQ(pq1, data[i], "code");
                }
            }
            else if (ext.equals("date")) {
                if (data[i][1] < val_ext) {
                    putPQ(pq1, data[i], "date");
                }
            }
            else if (ext.equals("maximum")) {
                if (data[i][2] < val_ext) {
                    putPQ(pq1, data[i], "maximum");
                }
            }
            else if (ext.equals("remain")) {
                if (data[i][3] < val_ext) {
                    putPQ(pq1, data[i], "remain");
                }
            }
        }

        int index = 0;
        answer = new int[pq1.size()][4];

        while(!pq1.isEmpty()) {
            Data dt = (Data) pq1.poll();
            answer[index][0] = dt.code;
            answer[index][1] = dt.date;
            answer[index][2] = dt.maximum;
            answer[index][3] = dt.remain;
            index++;
        }

        return answer;
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    String order;

    public Data(int code, int date, int maximum, int remain, String order){
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
        this.order = order;
    }
}

class DataComparator implements Comparator<Data> {
    @Override
    public int compare(Data d1, Data d2){
        if ("code".equals(d1.order)) {
            return d2.code- d1.code;
        }
        else if ("date".equals(d1.order)) {
            return d2.date - d1.date;
        }
        else if ("maximum".equals(d1.order)) {
            return d2.maximum - d1.maximum;
        }
        else if ("remain".equals(d1.order)) {
            return d2.remain - d1.remain;
        }
        return 1;
    }
}