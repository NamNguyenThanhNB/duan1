package com.example.duan1.model;

public class Favorite {
    int id;
    Object object;
    String time;

    public Favorite() {
    }

    public Favorite(int id, Object object, String time) {
        this.id = id;
        this.object = object;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
