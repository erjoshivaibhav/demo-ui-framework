package com.pojos;

import java.util.List;
import java.util.Map;

public class LoginTestPojo {
    public List<User> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LoginTestPojo{" +
                "data=" + data +
                '}';
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    private List<User> data;


}

