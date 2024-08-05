package com.LoversDogs.Lovers.entity;

import jakarta.persistence.*;
import lombok.*;



@Data
@NoArgsConstructor
@ToString
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String content;
    private String category;
    private String author;

    @Builder
    public Board(Long id, String title, String content, String category, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
    }


}
