package com.example.splitwise.core;

final class ImmutableData {

    private final String data;

    private ImmutableData(String data){
        this.data = data;
    }

    public String getData(){
        return new String(data);
    }


}
