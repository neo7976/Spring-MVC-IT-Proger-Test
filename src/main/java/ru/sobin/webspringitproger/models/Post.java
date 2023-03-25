package ru.sobin.webspringitproger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String anons;

    @Column(name = "full_text")
    private String fullText;

    private int views;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAnons() {
        return anons;
    }

    public String getFullText() {
        return fullText;
    }

    public int getViews() {
        return views;
    }
}
