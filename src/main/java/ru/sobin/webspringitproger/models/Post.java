package ru.sobin.webspringitproger.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String anons;

    @Column(name = "full_text")
    private String fullText;

    private int views;

    private boolean remove;
}
