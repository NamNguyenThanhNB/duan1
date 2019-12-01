package com.example.duan1.model;

public class MTDL {

    int id;
    String type;
    String title;
    String context;
    String start;
    String end;
    String status;

    public MTDL(int id, String title, String context, String start, String end, String status) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public MTDL() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MTDL(int id, String type, String title, String context, String start, String end, String status) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.context = context;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
