package com.example.splitwise.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {

    public static int solve(List<String> words){
        int count =0;

        Collections.sort(words);
        String word = words.get(0);

        for(int i =1 ;i <words.size(); i++){
                if( words.get(i).indexOf(word) ==0) {
                    ++count;
                }
                else {
                    word = words.get(i);
            }
        }

        return count;
    }
    public static void main(String[] args) {

        List<String> word= List.of("abc", "a", "a", "b", "ab", "ac");

        List<String> words = new ArrayList<>(word);


        System.out.println(solve(words));
    }
}
