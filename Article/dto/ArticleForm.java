package com.demo.demo.dto;


import com.demo.demo.entity.Article;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
//@NoArgsConstructor
//@Entity
@AllArgsConstructor
@ToString
//@Entity
public class ArticleForm {

    private String title;
    private String content;




    public Article toEntity() {
        return new Article(null, title, content);
    }

}
