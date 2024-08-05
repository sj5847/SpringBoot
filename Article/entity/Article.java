package com.demo.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity  //DB가 해당 객체를 인식 가능
@Getter

public class Article {
//    public String getId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //숫자를 자동으로 생성해줌
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


}
