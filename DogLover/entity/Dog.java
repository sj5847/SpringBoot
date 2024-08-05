package com.LoversDogs.Lovers.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data  //기본 생성자, toString, 게더,세더가 자동 생성
@NoArgsConstructor  //매개변수 없는 생성자 포함
//@AllArgsConstructor 모든 필드를 초기화시키는 생성자 포함
@Entity(name = "dog")

public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String age;

    @Column(nullable = false, length = 30)
    private String gender;

    @Column(nullable = false, length = 30)
    private String special;

    @Column(nullable = false, length = 100)
    private String vaccination;

    @Column(length = 30)
    private String neutered;

    @Column(length = 100)
    private String reason;

    @Column(length = 100)
    private String noticeNumber;

    @Column(length = 100)
    private String like;

    @Column(length = 100)
    private String dislikes;

    @ElementCollection
    @CollectionTable(name = "dog_images", joinColumns = @JoinColumn(name = "dog_id"))
    @Column(name = "image_url")
    private List<String> images;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createTime;

    public String getName() {
        return name;
    }

    @Builder
    public Dog(Long id, String name, String age, String gender, String special, String vaccination, String neutered, String reason, String noticeNumber, String like, String dislikes, List<String> images) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.special = special;
        this.vaccination = vaccination;
        this.neutered = neutered;
        this.reason = reason;
        this.noticeNumber = noticeNumber;
        this.like = like;
        this.dislikes = dislikes;
        this.images = images;
    }
}

