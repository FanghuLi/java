package com.lifanghu.model;

public class Blog {
    private int id;
    private String title;
    private String date;
    private String authername;
    private  String content;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAuthername() {
        return authername;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthername(String authername) {
        this.authername = authername;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
