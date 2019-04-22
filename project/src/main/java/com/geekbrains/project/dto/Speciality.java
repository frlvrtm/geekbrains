package com.geekbrains.project.dto;

public class Speciality {
    private int id;
    private String title;
    private String description;

    public Speciality() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'';
    }
}
