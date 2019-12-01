package com.example.duan1.model;

public class BaiTap {
    int id;
    String name;
    String content;
    String example;

    public BaiTap() {
    }

    public BaiTap(int id, String name, String content, String example) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
