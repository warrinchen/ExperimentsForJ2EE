package com.exp.entity;

public class TreeItem {
    private String id;
    private String parent;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TreeItem{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
