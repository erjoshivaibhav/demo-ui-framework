package com.pojos;

public class Env {
    private String URL;

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
