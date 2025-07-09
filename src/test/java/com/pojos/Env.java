package com.pojos;

public class Env {
    private String URL;
    private String MAX_RETRY_COUNT;

    public String getMAX_RETRY_COUNT() {
        return MAX_RETRY_COUNT;
    }

    public void setMAX_RETRY_COUNT(String MAX_RETRY_COUNT) {
        this.MAX_RETRY_COUNT = MAX_RETRY_COUNT;
    }


    @Override
    public String toString() {
        return "Env{" +
                "url='" + URL + '\'' +
                '}';
    }

    public String getUrl() {
        return URL;
    }

    public void setUrl(String url) {
        this.URL = url;
    }
}
