package com.example.splitwise.dsa;

import java.util.ArrayList;
import java.util.List;

public class Question2 {


    public static int solve(List<List<Integer>> arr, int len){
        int ans = -1;

        int max = 1440;

         arr.sort((a, b) -> {
             int i = a.get(0) - b.get(0);
             return i;
         });

         int curr_min = arr.get(0).get(0);
         int curr_max = arr.get(0).get(1);
         if ( curr_min == len) return 0;
        for(int i=1; i< arr.size(); i++){
            int start = arr.get(i).get(0);

            if (start >  curr_max){
                int diff = start - curr_max;
                if (diff >=  len) return curr_max;
            }
            curr_max = arr.get(i).get(1);

        }
        if (max - curr_max>=len) return curr_max;
        return ans;
    }
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        int length =10;
        solve(list, length);
    }
}
