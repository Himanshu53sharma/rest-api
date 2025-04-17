package com.exp3.Exp3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    // Default no-argument constructor for JPA
    public Course() {
    }

    // Optionally, you can keep the constructor for specific use cases
    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course: (" +
                "id: " + id + ", " +
                "title: '" + title + "', " +
                "description: '" + description + "'" +
                ")";
    }
}
