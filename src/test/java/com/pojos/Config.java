package com.pojos;

import java.util.Map;

public class Config {
    public Map<String, Env> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Config{" +
                "data=" + data +
                '}';
    }

    public void setData(Map<String, Env> data) {
        this.data = data;
    }

    private Map<String,Env> data;
}
